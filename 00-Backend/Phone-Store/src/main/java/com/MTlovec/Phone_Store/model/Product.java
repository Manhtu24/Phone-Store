package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

//@Entity
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<ProductVariant> productVariants;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id",nullable = true)
    private List<ProductImage> productImages;

    @OneToMany
    @JoinColumn(name = "related_id")
    private List<Image> descriptionImages;

    private LocalDateTime createAt;
}
