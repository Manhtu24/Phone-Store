package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

//@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    private String status;

    private Date createAt;

    @Column(nullable = false)
    private Long userId;

    @OneToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;
}
