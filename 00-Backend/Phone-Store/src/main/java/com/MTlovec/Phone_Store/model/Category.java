package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

    @Column(unique = true)
    private String name;

    private String description;

    private LocalDateTime createAt;

    public Category(){
        this.createAt= LocalDateTime.now();
    }
}
