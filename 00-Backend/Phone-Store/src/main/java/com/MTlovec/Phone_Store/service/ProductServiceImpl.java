package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final  CloudinaryService cloudinaryService;

}
