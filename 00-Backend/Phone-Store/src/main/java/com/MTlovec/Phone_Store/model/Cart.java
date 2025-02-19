package com.MTlovec.Phone_Store.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;
import java.util.Date;

public class Cart {
    private Long cart_id ;

    private Date createAt;

    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;


}
