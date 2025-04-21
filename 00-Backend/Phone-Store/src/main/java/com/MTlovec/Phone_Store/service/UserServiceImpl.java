package com.MTlovec.Phone_Store.service;


import com.MTlovec.Phone_Store.exception.AlreadyExistException;
import com.MTlovec.Phone_Store.exception.NotFoundException;
import com.MTlovec.Phone_Store.exception.PasswordNotMatchException;
import com.MTlovec.Phone_Store.model.LOGIN_TYPE;
import com.MTlovec.Phone_Store.model.USER_ROLE;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.repository.UserRepository;
import com.MTlovec.Phone_Store.response.UserResponse;
import com.MTlovec.Phone_Store.security.JWTGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private  final JWTGenerator jwtGenerator;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JavaMailSender javaMailSender;

    @Override
    public void forgotPassword(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user!=null){
            String newPassword= UUID.randomUUID().toString().
                    replace("-","").substring(0,8);
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

    @Override
    public User findByJwt(String jwt) throws NotFoundException {
        String email= jwtGenerator.getEmailFromJWT(jwt);
        User user= userRepository.findByEmail(email).orElseThrow(()->new NotFoundException("Can not found user"));
        return user;
    }

    @Override
    public Page<UserResponse> getUsers(int page, int size,
                                       String role, String search) {
        Pageable pageable= PageRequest.of(page, size);
        USER_ROLE userRole = null;
        if(role!=null){
            try {
                userRole = USER_ROLE.valueOf(role);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid role value: " + role);
            }
        }
        Page <User> pageUser= userRepository.findUserByRoleAndSearch(pageable,userRole,search);
        SimpleDateFormat formater= new SimpleDateFormat("yyyy-MM-dd");

        return pageUser.map(user->new UserResponse(user.getId(),
                user.getEmail(),
                user.getName(),
                user.getPhoneNumber(),
                formater.format(user.getCreateAt()),
                user.getRole()));
    }

    @Override
    public User addUser(User user){
        User newUser= userRepository.findByEmail(user.getEmail()).orElse(null);
        if(newUser!=null){
            throw  new AlreadyExistException("Email already used with another account");
        }
        user.setCreateAt(new Date());
        user.setPassword("");
        user.setType(LOGIN_TYPE.GOOGLE);
        return userRepository.save(user);
    }
    @Override
    public User addAdminUser(User user) {
        User newUser= userRepository.findByEmail(user.getEmail()).orElse(null);
        if(newUser!=null){
            throw  new AlreadyExistException("Email already used with another account");
        }
        user.setRole(USER_ROLE.ROLE_ADMIN);
        user.setCreateAt(new Date());
        return userRepository.save(user);
    }

    @Override
    public User changePassword(User user, String oldPassword, String newPassword) {
        if(passwordEncoder.matches(user.getPassword(),oldPassword )){
            throw new PasswordNotMatchException("Password is not match");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        return  userRepository.save(user);
    }
}
