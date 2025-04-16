package com.MTlovec.Phone_Store.repository;

import com.MTlovec.Phone_Store.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
}
