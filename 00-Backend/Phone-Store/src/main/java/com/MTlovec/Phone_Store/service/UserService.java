package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.model.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface UserService {
    void forgotPassword(String email);
}
