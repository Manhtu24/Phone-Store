package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.model.Brand;
import com.MTlovec.Phone_Store.response.BrandResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;

public interface BrandService {
    PaginatedResponse<BrandResponse> getBrands(int page, int size, String search);

    BrandResponse getBrand(Long id);

    BrandResponse createBrand(Brand brand);

    void updateBrand(Long id, Brand updateBrand);

    void deleteBrand(Long id);
}
