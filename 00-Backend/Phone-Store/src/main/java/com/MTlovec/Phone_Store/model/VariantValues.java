package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "variant_values")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VariantValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String value;

    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "variant_id")
    private Variants variants;

    @OneToMany(mappedBy = "variantValues")
    private List<ProductVariantValues> productVariantValues;

    private LocalDateTime createAt;

}
