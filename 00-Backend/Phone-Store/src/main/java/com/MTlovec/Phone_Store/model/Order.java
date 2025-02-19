package com.MTlovec.Phone_Store.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private Long orderId;

    private BigDecimal totalPrice;

    private String status;

    private Date createAt;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @OneToOne
    @JoinColumn(name = "promotion_id")
    private Promotion promotion;



}
