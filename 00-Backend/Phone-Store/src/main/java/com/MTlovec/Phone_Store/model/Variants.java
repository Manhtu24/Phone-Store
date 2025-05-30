package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Variants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "variants",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<VariantValues>variantValues;

    private LocalDateTime createAt;
}
