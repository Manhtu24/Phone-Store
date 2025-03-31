package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

//@Entity
@Data
@Table(name = "product_images")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = true)
    private Product product;

    @OneToOne
    @JoinColumn(name = "productVariant_id",nullable = true)
    private ProductVariant productVariant;

    private String imageUrl;

    private boolean isPrimary;

    private Date createAt;
}
