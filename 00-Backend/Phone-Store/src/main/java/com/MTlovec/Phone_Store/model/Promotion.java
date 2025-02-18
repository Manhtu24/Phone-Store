package com.MTlovec.Phone_Store.model;

import java.math.BigDecimal;
import java.util.Date;

public class Promotion {
    private Long id;

    private  String code;

    private BigDecimal value;

    private Date startTime;

    private  Date expiredTime;

    private BigDecimal minOrderAmount;// min purchase amount to apply th this code

    private BigDecimal maxDiscount; // max decrease value

    private  int maxUsage; // number of this voucher

    private int usedCount;

    private String status;

    private String description;

    private Date createAt;

    private Date updateAt;




}
