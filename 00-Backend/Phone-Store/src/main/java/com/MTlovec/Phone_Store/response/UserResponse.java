package com.MTlovec.Phone_Store.response;

import com.MTlovec.Phone_Store.model.USER_ROLE;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String createAt;
    private USER_ROLE role;
}
