package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.model.Banner;
import com.MTlovec.Phone_Store.response.BannerResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;

import java.io.IOException;

public interface BannerService {
    PaginatedResponse<BannerResponse> getBanners(int page, int size,String search);

    BannerResponse createBanner(Banner banner);

    void updateBanner(Long id, Banner updateBanner) throws IOException;

    void deleteBanner(Long id) throws IOException;
}
