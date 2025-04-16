package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.exception.AlreadyExistException;
import com.MTlovec.Phone_Store.exception.NotFoundException;
import com.MTlovec.Phone_Store.model.Image;
import com.MTlovec.Phone_Store.model.PageSection;
import com.MTlovec.Phone_Store.repository.ImageRepository;
import com.MTlovec.Phone_Store.repository.PageSectionRepository;

import com.MTlovec.Phone_Store.response.ImageResponse;
import com.MTlovec.Phone_Store.response.PageSectionResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PageSectionServiceImpl implements PageSectionService{

    private final PageSectionRepository pageSectionRepository;

    private final  CloudinaryService cloudinaryService;

    private final ImageRepository imageRepository;

    @Override
    public PaginatedResponse<PageSectionResponse> getAllSections(int page, int size, String search, String searchGroup) {
        Pageable pageable= PageRequest.of(page,size);
        Page<PageSection> pageSections=pageSectionRepository.getAllSection(pageable,search,searchGroup);
        List<PageSection> pageSectionList=pageSections.getContent();
        List<PageSectionResponse> responses=pageSectionList.stream().map(sec->{
            List<Image> images=sec.getImages();
            List <ImageResponse>responses1=new ArrayList<>();
            for (Image image:images){
                ImageResponse imageResponse=new ImageResponse();
                imageResponse.setId(image.getId());
                imageResponse.setNewsImageUrl(image.getImageUrl());
                imageResponse.setNewsImagePublicId(image.getPublicId());
                responses1.add(imageResponse);
            }
            return new PageSectionResponse(sec.getId(),
                    sec.getTitle(),
                    sec.getDescription(),
                    sec.getSectionGroup(),
                    responses1);
        }).collect(Collectors.toList());

        return new  PaginatedResponse<>(responses,
                pageSections.getTotalPages(),
                pageSections.getNumber()+1);
    }

    @Override
    public PageSection createPageSection(PageSection pageSection) {
        PageSection existPageSection=pageSectionRepository.findByTitle(pageSection.getTitle());
        if (existPageSection!=null){
            throw  new AlreadyExistException("This page section is already exist: "+pageSection.getTitle());
        }
        PageSection savePageSection=pageSectionRepository.save(pageSection);
        List<Image> images=pageSection.getImages();
        for (Image image:images){
            Image img=image;
            img.setCreateAt(LocalDate.now());
            img.setRelatedType("footer");
            img.setRelatedId(savePageSection.getId());
            imageRepository.save(img);
        }
        return savePageSection;
    }

    @Override
    @Transactional
    public void updatePageSection(Long sectionId, PageSection updateSection) {
        PageSection pageSection=pageSectionRepository.findById(sectionId).orElseThrow(()->
                new NotFoundException("Could not found this section with id: "+sectionId));
        pageSection.setTitle(updateSection.getTitle());
        pageSection.setDescription(updateSection.getDescription());
        pageSection.setSectionGroup(updateSection.getSectionGroup());
        pageSectionRepository.save(pageSection);

        List<Long> imagesIdFromClient=updateSection.getImages().stream().
                filter(img->img.getId()!=null)
                .map(Image::getId)
                .toList();
        pageSection.getImages().removeIf(image -> {
            boolean isInside=!imagesIdFromClient.contains(image.getId());
            if (isInside){
                imageRepository.deleteById(image.getId());
            }
            return isInside;
        });
        for(Image img:updateSection.getImages()){
            if (img.getId()==null){
                Image image=new Image();
                image.setImageUrl(img.getImageUrl());
                image.setPublicId(img.getPublicId());
                image.setRelatedId(pageSection.getId());
                image.setRelatedType("footer");
                image.setCreateAt(LocalDate.now());
                imageRepository.save(image);
            }
        }
    }

    @Transactional
    @Override
    public void deleteSection(Long sectionId) {
        PageSection pageSection=pageSectionRepository.findById(sectionId).orElseThrow(()->
                new NotFoundException("Could not found this section with id: "+sectionId));
        List<Image> images=pageSection.getImages();
        for (Image image:images){
            try {
                cloudinaryService.deleteImage(image.getPublicId());
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        pageSectionRepository.delete(pageSection);
    }
}
