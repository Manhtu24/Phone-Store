package com.MTlovec.Phone_Store.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LogInRequest {
    private String email;
    private String password;
}
