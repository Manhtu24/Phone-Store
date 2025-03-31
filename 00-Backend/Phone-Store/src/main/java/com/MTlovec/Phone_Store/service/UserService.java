package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.response.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface UserService {
    void forgotPassword(String email);

     User findByJwt(String jwt);

     Page<UserResponse> getUsers(int page, int size,String role,String search);

     User addAdminUser(User user);

     User changePassword(User user, String oldPassword, String newPassword);

}
