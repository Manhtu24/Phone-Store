package com.MTlovec.Phone_Store.service;


import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public Optional<User> findUserByEmail(String email) {
        Optional<User> optional= userRepository.findByEmail(email);
        return  optional;
    }
}
