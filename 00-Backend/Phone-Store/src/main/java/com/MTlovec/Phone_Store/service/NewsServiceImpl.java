package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.exception.AlreadyExistException;
import com.MTlovec.Phone_Store.exception.NotFoundException;
import com.MTlovec.Phone_Store.model.Image;
import com.MTlovec.Phone_Store.model.News;
import com.MTlovec.Phone_Store.repository.ImageRepository;
import com.MTlovec.Phone_Store.repository.NewsRepository;
import com.MTlovec.Phone_Store.request.ImageRequest;
import com.MTlovec.Phone_Store.request.NewsRequest;
import com.MTlovec.Phone_Store.response.ImageResponse;
import com.MTlovec.Phone_Store.response.NewResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService{

    private final NewsRepository newsRepository;

    private final ImageRepository imageRepository;

    private final CloudinaryService cloudinaryService;


    @Override
    public PaginatedResponse<NewResponse> getPosts(int page, int size, String search) {
        Sort sort=Sort.by("createAt");
        if ("desc".equalsIgnoreCase(search)){
            sort=sort.descending();
        }else {
            sort= sort.ascending();
        }
        Pageable pageable=PageRequest.of(page,size);
        Page<News> pageNews=newsRepository.getPosts(pageable);
        List<News> news= pageNews.getContent();
        List<NewResponse> newResponses=news.stream().map(post-> {
            List<Image> postImage = post.getImages();
            List<ImageResponse> imageResponses=new ArrayList<>();
            for(Image image:postImage){
                imageResponses.add(new ImageResponse(image.getId(),
                        image.getImageUrl(),
                        image.getPublicId()));
            }
            return new NewResponse(post.getId(),
                    post.getCoverImageUrl(),
                    post.getCreateAt(),
                    post.getTitle(),
                    post.getNewsDescribe(),
                    post.getDescription(),
                    imageResponses);
        }).collect(Collectors.toList());
        return new PaginatedResponse<>(newResponses,
                           pageNews.getTotalPages(),
                pageNews.getNumber()+1);
    }

    @Override
    @Transactional
    public NewResponse createPost(NewsRequest request) {
        if (newsRepository.existsByTitle(request.getTitle())){
            throw new AlreadyExistException("This post already exist");
        }
        News news=new News();
        news.setTitle(request.getTitle());
        news.setAuthor(request.getAuthor());
        news.setNewsDescribe(request.getDescribe());
        news.setDescription(request.getDescription());
        news.setCoverImageUrl(request.getCoverImageUrl());
        news.setCoverImagePublicId(request.getPublicId());
        news.setCreateAt(LocalDateTime.now());
        News saveNes=newsRepository.save(news);
        //take iamge
        List<ImageRequest> imgsReq=request.getImages();
        List<Image> images=imgsReq.stream().map(img->{
            Image image=new Image();
            image.setImageUrl(img.getImageUrl());
            image.setPublicId(img.getPublicId());
            image.setRelatedType("news");
            image.setRelatedId(saveNes.getId());
            return  imageRepository.save(image);
        }).collect(Collectors.toList());
        List<ImageResponse> imgRes=images.stream().map(img->
                new ImageResponse(img.getId(),
                        img.getImageUrl(),
                        img.getPublicId())).collect(Collectors.toList());
        return new NewResponse(news.getId(),
                news.getCoverImageUrl(),
                news.getCreateAt(),
                news.getTitle(),
                news.getNewsDescribe(),
                news.getDescription(),
                imgRes);
    }

    @Override
    @Transactional
    public void updatePost(Long id, NewsRequest request) {
        News existNews=newsRepository.findById(id).orElseThrow(()->
                new NotFoundException("Could not found news with id: "+id));
        if (newsRepository.existsByTitleAndIdNot(request.getTitle(), existNews.getId())){
            throw new AlreadyExistException("News with this title already exitst");
        }
        existNews.setTitle(request.getTitle());
        existNews.setAuthor(request.getAuthor());
        existNews.setNewsDescribe(request.getDescribe());
        existNews.setDescription(request.getDescription());
        existNews.setCoverImageUrl(request.getCoverImageUrl());
        existNews.setCoverImagePublicId(request.getPublicId());
        newsRepository.save(existNews);
        List<Long> imagesIdFromClient=request.getImages().stream().
                filter(img->img.getId()!=null)
                .map(ImageRequest::getId)
                .toList();
        existNews.getImages().removeIf(image -> {
            boolean isInside=!imagesIdFromClient.contains(image.getId());
            if (isInside){
                imageRepository.deleteById(image.getId());
            }
            return isInside;
        });
        for(ImageRequest img:request.getImages()){
            if (img.getId()==null){
                Image image=new Image();
                image.setImageUrl(img.getImageUrl());
                image.setPublicId(img.getPublicId());
                image.setRelatedId(existNews.getId());
                image.setRelatedType("news");
                image.setCreateAt(LocalDate.now());
                imageRepository.save(image);
            }
        }
    }

    @Override
    @Transactional
    public void deletePost(Long id) throws IOException {
        News existNews=newsRepository.findById(id).orElseThrow(()->
                new NotFoundException("Could not found news with id: "+id));
        cloudinaryService.deleteImage(existNews.getCoverImagePublicId());
        if(!existNews.getImages().isEmpty()){
            List<Image> images=existNews.getImages();
            //Delete both from cloudinary
            for (Image image:images){
                cloudinaryService.deleteImage(image.getPublicId());
            }
        }
        newsRepository.delete(existNews);
    }
}
