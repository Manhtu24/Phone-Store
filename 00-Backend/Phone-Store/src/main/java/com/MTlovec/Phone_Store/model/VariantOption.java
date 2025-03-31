package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
//@Entity
@Data
public class VariantOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long variantOptionId;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "variant_id",nullable = false)
    private ProductVariant productVariant;

    @ManyToOne
    @JoinColumn(name = "storage_id",nullable = false)
    private Storage storage;
}
