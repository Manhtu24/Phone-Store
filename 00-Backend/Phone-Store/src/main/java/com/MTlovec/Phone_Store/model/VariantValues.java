package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "variant_values")
public class VariantValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String value;

    private LocalDateTime createAt;

}
