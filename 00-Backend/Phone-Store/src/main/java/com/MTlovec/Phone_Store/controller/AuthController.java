package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.constant.ApplicationConstant;
import com.MTlovec.Phone_Store.constant.ResponseConstant;
import com.MTlovec.Phone_Store.model.USER_ROLE;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.repository.UserRepository;
import com.MTlovec.Phone_Store.request.LogInRequest;
import com.MTlovec.Phone_Store.response.AuthResponse;
import com.MTlovec.Phone_Store.response.ResponseDTO;
import com.MTlovec.Phone_Store.security.JWTGenerator;
import com.MTlovec.Phone_Store.service.AuthService;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.security.authentication.*;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    private final JWTGenerator jwtGenerator;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserService userService;

    private final AuthService authService;

    @PostMapping("/signIn")
    public ResponseEntity<AuthResponse> signIn(@RequestBody LogInRequest request){
        String email= request.getEmail();
        String password= request.getPassword();
        Authentication authentication= UsernamePasswordAuthenticationToken.unauthenticated(email,password);
        Authentication authenticationResponse= authenticationManager.authenticate(authentication);
        Collection<?extends GrantedAuthority> authorities= authenticationResponse.getAuthorities();
        String role= authorities.isEmpty()?null:authorities.iterator().next().getAuthority();
        String jwt="";
        if( authenticationResponse!=null){
            jwt= jwtGenerator.GenerateToken(authenticationResponse);
        }
        return  ResponseEntity.status(HttpStatus.OK).header(ApplicationConstant.JWT_HEADER,jwt)
                .body(new AuthResponse(jwt,
                        "Login success",
                                 HttpStatus.OK.value(),
                                 USER_ROLE.valueOf(role)));
    }
    @PostMapping("/register")
    public ResponseEntity<AuthResponse> signUp(@RequestBody User user) {
        User exittedUser = userRepository.findByEmail(user.getEmail()).orElse(null);
        if (exittedUser != null) {
            throw new BadCredentialsException("Email is already exist");
        }
        String password = user.getPassword();
        String hashPwd = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPwd);
        user.setRole(user.getRole());
        user.setCreateAt(new Date());
        User savedUser = userRepository.save(user);
        if (savedUser.getId() > 0) {
            //Automatic sign in if register success
            Authentication authentication = UsernamePasswordAuthenticationToken.unauthenticated(user.getEmail(), password);
            Authentication authenticationResponse = authenticationManager.authenticate(authentication);
            String jwt = jwtGenerator.GenerateToken(authenticationResponse);
            return ResponseEntity.status(HttpStatus.CREATED).body(new AuthResponse(
                    jwt, "Register success", HttpStatus.CREATED.value(), savedUser.getRole()
            ));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).
                    body(new AuthResponse(null, "User Register Failed",
                            HttpStatus.BAD_REQUEST.value(), null));
        }
    }
    @GetMapping("/social-login")
    public ResponseEntity<String>socialAuth(@RequestParam("login_type") String loginType){
        loginType=loginType.trim().toLowerCase();
        String url=authService.generateAuthUrl(loginType);
        return ResponseEntity.ok(url);
    }

    @GetMapping("/social/callback")
    public ResponseEntity<AuthResponse> callback(@RequestParam("code")String code,
                                                @RequestParam("login_type")String loginType) throws IOException {
        Map<String ,Object> userInfo=authService.authenticateAndFetchUser(code,loginType);
        if (userInfo==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new AuthResponse("","Failed to authenticate",
                            HttpStatus.BAD_REQUEST.value(),
                            USER_ROLE.NO_ROLE));
        }
//        String accountId="";
        String name="";
        String email="";

        if (loginType.toLowerCase().equals("google")){
//            accountId=(String) Objects.requireNonNullElse(userInfo.get("sub"),"");
            name=(String) Objects.requireNonNullElse(userInfo.get("name"),"");
            email=(String) Objects.requireNonNullElse(userInfo.get("email"),"");
        }
        User user=new User();
        user.setEmail(email);
        user.setName(name);
        User saveU=userService.addUser(user);
        LogInRequest logInRequest=new LogInRequest(saveU.getEmail(), saveU.getPassword());
        return  this.signIn(logInRequest);
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(@RequestParam("email") String email){
        userService.forgotPassword(email);
        return "Done";
    }
}
