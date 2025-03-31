package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.exception.NotFoundException;
import com.MTlovec.Phone_Store.model.Brand;
import com.MTlovec.Phone_Store.repository.BrandRepository;
import com.MTlovec.Phone_Store.response.BrandResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BrandServiceImpl implements  BrandService{

    private final BrandRepository brandRepository;

    @Override
    public PaginatedResponse<BrandResponse> getBrands(int page, int size, String search) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Brand> brands= brandRepository.getBrands(pageable,search);
        List<Brand> brandList= brands.getContent();
        List <BrandResponse> brandResponses= brandList.stream().map(brand ->
                            new BrandResponse(brand.getId(),
                                              brand.getName(),
                                              brand.getDescription()))
                            .toList();
        PaginatedResponse<BrandResponse> response= new PaginatedResponse<>(
                                                         brandResponses,
                                                         brands.getTotalPages(),
                                                brands.getNumber()+1);
        return response;
    }

    @Override
    public BrandResponse getBrand(Long id) {
        Brand brand= brandRepository.findById(id).orElseThrow(()->
                new NotFoundException("Could not found this brand"));

        BrandResponse brandResponse= new BrandResponse(brand.getId(),
                brand.getName(),
                brand.getDescription());

        return brandResponse;
    }

    @Override
    public BrandResponse createBrand(Brand brand) {
        if(!brandRepository.existsByName(brand.getName())){
            throw  new RuntimeException("Brand name already exist");
        }
        Brand brand1= brandRepository.save(brand);
        return new BrandResponse(brand.getId(),
                brand.getName(),
                brand.getDescription());
    }

    @Override
    @Transactional
    public void updateBrand(Long id, Brand updateBrand) {
        Brand brand = brandRepository.findById(id).orElseThrow(()->
                new NotFoundException("Could not found this brand"));
        if(brandRepository.existsByNameAndIdNot(updateBrand.getName(),id)){
            throw new RuntimeException("Brand name already exist");
        }
        brand.setName(updateBrand.getName());
        brand.setDescription(updateBrand.getDescription());
        brandRepository.save(brand);
    }

    @Override
    @Transactional
    public void deleteBrand(Long id) {
        Brand brand =brandRepository.findById(id).orElseThrow(()->
                new NotFoundException("Could not found this brand"));
        brandRepository.delete(brand);
    }
}
