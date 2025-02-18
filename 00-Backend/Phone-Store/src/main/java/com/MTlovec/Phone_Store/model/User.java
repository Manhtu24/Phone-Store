package com.MTlovec.Phone_Store.model;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private  Long id;

    private  String email;

     private String password;

     private String name;

     private USER_ROLE role= USER_ROLE.ROLE_USER;

     private Date createAt;


}
