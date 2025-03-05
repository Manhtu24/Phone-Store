package com.MTlovec.Phone_Store.service;


import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JavaMailSender javaMailSender;

    @Override
    public void forgotPassword(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user!=null){
            String newPassword= UUID.randomUUID().toString().substring(0,8);
            user.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(user);
            sendNewPasswordEmail(user.getEmail(),newPassword);
        }
    }
    private void sendNewPasswordEmail(String email, String newPassword) {
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setTo(email);
        simpleMailMessage.setSubject("Your new password");
        simpleMailMessage.setText("Your new password is: "+newPassword);
        javaMailSender.send(simpleMailMessage);
    }
}
