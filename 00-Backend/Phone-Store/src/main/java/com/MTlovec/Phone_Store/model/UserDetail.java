package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;

import java.util.Date;

//@Entity
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userDetailId;

    private String firstName;

    private String lastName;

    private Date dateOfBirth;

    private String address;

    private String phoneNumber;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

}
