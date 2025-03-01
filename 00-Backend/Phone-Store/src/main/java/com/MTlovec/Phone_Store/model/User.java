package com.MTlovec.Phone_Store.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.repository.cdi.Eager;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long userId;

    private  String email;

     private String password;

     private String name;

     private USER_ROLE role= USER_ROLE.ROLE_USER;

     private Date createAt;

//     @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
//     private UserDetail userDetail;
//
//     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//     private Set<Order> orders;


}
