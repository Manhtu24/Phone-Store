package com.MTlovec.Phone_Store.response;

import com.MTlovec.Phone_Store.model.USER_ROLE;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AuthResponse {
    private String jwt;

    private String message;

    private int statusCode;

    private USER_ROLE role;
}
