package com.MTlovec.Phone_Store.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.Date;
@Data
public class ShippingInformation {
    private Long shippingId;

    private String address;

    private String recipientName;

    private  String phoneNumber;

    private Date shippingDate;

    private String guestNote;

    @JoinColumn(name = "order_id")
    @OneToOne
    private Order order;

}
