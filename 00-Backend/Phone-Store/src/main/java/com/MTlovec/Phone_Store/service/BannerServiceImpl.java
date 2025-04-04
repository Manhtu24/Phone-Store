package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.exception.NotFoundException;
import com.MTlovec.Phone_Store.model.Banner;
import com.MTlovec.Phone_Store.repository.BannerRepository;
import com.MTlovec.Phone_Store.response.BannerResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements  BannerService{

    private final BannerRepository bannerRepository;

    private final  CloudinaryService cloudinaryService;

    @Override
    public PaginatedResponse<BannerResponse> getBanners(int page, int size, String search) {
        Pageable pageable= PageRequest.of(page,size);
        Page <Banner> banners=bannerRepository.getBanners(pageable,search);
        List<BannerResponse> bannerResponses= banners.getContent().stream().map(banner->
                new BannerResponse(banner.getId(),
                        banner.getImageUrl(),
                        banner.getPageName(),
                        banner.getBannerType(),
                        banner.getImageOrder())).toList();
        PaginatedResponse<BannerResponse> response = new PaginatedResponse<>(bannerResponses,
                           banners.getTotalPages(),
                banners.getNumber()+1);
        return response;
    }

    @Override
    public BannerResponse createBanner(Banner banner) {
        List<Banner> existImageOrder=bannerRepository.findByPageName(banner.getPageName());
        if(!existImageOrder.isEmpty()){
            boolean orderExist=existImageOrder.stream().anyMatch(existOrder->
                    existOrder.getImageOrder()==banner.getImageOrder());
            if (orderExist){
                throw  new RuntimeException("Already exist order image for position: "+banner.getImageOrder());
            }
        }
        Banner saveBanner=bannerRepository.save(banner);
        BannerResponse response=new BannerResponse(saveBanner.getId(),
                saveBanner.getImageUrl(),
                saveBanner.getPageName(),
                saveBanner.getBannerType(),
                saveBanner.getImageOrder());
        return  response;
    }

    @Override
    public void updateBanner(Long id, Banner updateBanner) throws IOException {
        Banner existBanner= bannerRepository.findById(id).orElseThrow(()->
                new NotFoundException("Could not find banner with id: "+id));
        List<Banner> existImageOrder=bannerRepository.findByPageName(updateBanner.getPageName());
        if(!existImageOrder.isEmpty()){
            boolean orderExist=existImageOrder.stream().anyMatch(existOrder ->
                    existOrder.getImageOrder()==updateBanner.getImageOrder());
            if (orderExist){
                throw  new RuntimeException("Already exist order image for position: "+updateBanner.getImageOrder());
            }
        }
        if(!updateBanner.getPublicId().equals(existBanner.getPublicId())){
            cloudinaryService.deleteImage(existBanner.getPublicId());
            existBanner.setImageUrl(updateBanner.getImageUrl());
            existBanner.setPublicId(updateBanner.getPublicId());
        }
        existBanner.setPageName(updateBanner.getPageName());
        existBanner.setBannerType(updateBanner.getBannerType());
        existBanner.setImageOrder(updateBanner.getImageOrder());
        bannerRepository.save(existBanner);
    }

    @Override
    public void deleteBanner(Long id) throws IOException {
        Banner existBanner=bannerRepository.findById(id).orElseThrow(()->
                new NotFoundException("Could not found banner with id: "+id));
        String imagePublicId=existBanner.getPublicId();
        cloudinaryService.deleteImage(imagePublicId);
        bannerRepository.delete(existBanner);
    }
}
