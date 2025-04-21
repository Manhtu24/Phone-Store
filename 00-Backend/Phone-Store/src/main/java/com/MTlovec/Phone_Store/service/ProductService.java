package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.request.ProductRequest;
import com.MTlovec.Phone_Store.response.PaginatedResponse;

public interface ProductService {

    void createProduct(ProductRequest productRequest);

    void updateProduct(Long productId, ProductRequest updateProduct);

    void deleteProduct(Long productId);
}
