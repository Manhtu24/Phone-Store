package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.constant.ApplicationConstant;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.repository.UserRepository;
import com.MTlovec.Phone_Store.request.LogInRequest;
import com.MTlovec.Phone_Store.response.AuthResponse;
import com.MTlovec.Phone_Store.security.JWTGenerator;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JWTGenerator jwtGenerator;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    @PostMapping("/signIn")
    public ResponseEntity<AuthResponse> signIn(@RequestBody LogInRequest request){
        String email= request.getEmail();
        String password= request.getPassword();
        Authentication authentication= UsernamePasswordAuthenticationToken.unauthenticated(email,password);
        Authentication authenticationResponse= authenticationManager.authenticate(authentication);
        String jwt="";

        if( authenticationResponse!=null){
            jwt= jwtGenerator.GenerateToken(authenticationResponse);
        }
        return ResponseEntity.status(HttpStatus.OK).header(ApplicationConstant.JWT_HEADER,jwt)
                .body(new AuthResponse()); //NOT DONE
    }


    @PostMapping("/signUp")
    public ResponseEntity<AuthResponse> signUp(@RequestBody User user){
        User exittedUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if(exittedUser!=null){
            throw new  BadCredentialsException("Email is already exist");
        }
        String hasPwd= passwordEncoder.encode(user.getPassword());
        user.setPassword(hasPwd);
        User savedUser= userRepository.save(user);
        if (savedUser.getId()>0){
            String message="Given user detail is successfully registered";
            int code= HttpStatus.CREATED.value();
            return  ResponseEntity.status(HttpStatus.CREATED)
                    .body(new AuthResponse());
        }else{
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AuthResponse());
        }

    }
}
