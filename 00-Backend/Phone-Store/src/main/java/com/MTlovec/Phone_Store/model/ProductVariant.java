package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

//@Entity
@Data
@Table(name = "variants")
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int stock;

    private BigDecimal importPrice;

    private BigDecimal sellPrice;

    private String sku;//stock  keeping unit (dung de luu id cua cac variant ma ta muon tao ra mix giua chung)

    @OneToMany
    @JoinColumn(name = "product_variant_id")
    private ProductImage productImage;

    private LocalDateTime createAt;


}
