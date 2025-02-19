package com.MTlovec.Phone_Store.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class CartItem {

    private Long cartItemId;

    private int quantity;

    @JoinColumn(name = "cart_id")
    @ManyToOne
    private Cart cart;

    @JoinColumn(name = "product_id")
    @ManyToOne
    private Product product;
}
