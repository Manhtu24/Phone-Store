package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String code;

    private BigDecimal value;

    private String name;

    private LocalDate startTime;

    private  LocalDate expiredTime;

    private BigDecimal minOrderAmount;// min purchase amount to apply th this code

    private  Integer maxUsage; // number of this voucher

    private boolean status=true;

    private LocalDateTime createAt;

}
