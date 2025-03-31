package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

//@Entity
@Data
@Table(name = "variants")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productVariantID;

    private String name;

    private String storage;

    private BigDecimal extraPrice;//for special color or

    private String condition; //new, like new,...

    private int stock;

    @ManyToOne
    @JoinColumn(name = "product_id" )
    private Product product;

    @OneToOne(mappedBy = "productVariant", cascade = CascadeType.ALL)
    private ProductImage image;
}
