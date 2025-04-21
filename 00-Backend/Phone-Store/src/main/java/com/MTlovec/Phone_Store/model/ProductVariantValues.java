package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProductVariantValues {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_variant_value")
    private ProductVariant productVariant;

    @ManyToOne
    @JoinColumn(name = "variant_value_id")
    private VariantValues variantValues;
}
