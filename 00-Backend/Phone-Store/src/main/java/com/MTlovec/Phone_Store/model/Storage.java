package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.Data;

//@Entity
@Data
@Table(name = "storages")
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String size;
}
