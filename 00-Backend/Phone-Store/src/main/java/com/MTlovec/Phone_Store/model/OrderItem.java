package com.MTlovec.Phone_Store.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.math.BigDecimal;

public class OrderItem {
    private Long orderItemId;

    private int quantity;

    private BigDecimal productPrice;

    @JoinColumn(name = "order_id")
    @ManyToOne
    private Order order;

    @JoinColumn(name = "product_id")
    @OneToOne
    private Product product;


}
