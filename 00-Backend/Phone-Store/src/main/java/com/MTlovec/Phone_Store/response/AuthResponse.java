package com.MTlovec.Phone_Store.response;

import com.MTlovec.Phone_Store.model.USER_ROLE;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AuthResponse {
    private String jwt;

    private String message;

    private int statusCode;
}
