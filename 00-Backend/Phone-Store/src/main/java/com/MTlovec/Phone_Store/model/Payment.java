package com.MTlovec.Phone_Store.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;


public class Payment {
    private Long paymentId;

    private Date paymetDate;

    private String paymentStatus;

    private String paymentMethod;

    @JoinColumn(name = "order_id")
    @OneToOne
    private Order order;
}
