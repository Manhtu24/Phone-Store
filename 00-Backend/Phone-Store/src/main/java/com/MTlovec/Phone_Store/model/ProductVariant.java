package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

//@Entity

@Table(name = "product_variants")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int stock;

    private BigDecimal importPrice;

    private BigDecimal sellPrice;

    private String sku;//stock  keeping unit (dung de luu id cua cac variant ma ta muon tao ra mix giua chung)

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy = "productVariant")
    private List<ProductVariantValues> productVariantValues;

    @OneToMany
    @JoinColumn(name = "product_variant_id")
    private List<ProductImage> productVariantImage;

    private LocalDateTime createAt;
}
