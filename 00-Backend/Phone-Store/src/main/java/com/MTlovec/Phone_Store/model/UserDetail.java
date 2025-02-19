package com.MTlovec.Phone_Store.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class UserDetail {
    @Id
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
