package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.model.USER_ROLE;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.repository.UserRepository;
import com.MTlovec.Phone_Store.request.ChangePasswordRequest;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import com.MTlovec.Phone_Store.response.UserResponse;
import com.MTlovec.Phone_Store.security.JWTGenerator;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    private final UserService userService;


    @GetMapping("/admin/users")
    public ResponseEntity<PaginatedResponse<UserResponse>> getUsers(@RequestHeader("Authorization") String jwt,
                                                                    @RequestParam(defaultValue = "0") int page,
                                                                    @RequestParam(defaultValue = "10") int size,
                                                                    @RequestParam(required = false) String role,
                                                                    @RequestParam(required = false) String search
                                                                    ) {
        User existUser = userService.findByJwt(jwt);
        Page<UserResponse> pageUser= userService.getUsers(page,size,role,search);
        PaginatedResponse<UserResponse> pageResponse= new PaginatedResponse<>(
                pageUser.getContent(),
                pageUser.getTotalPages(),
                pageUser.getNumber()+1 //spring start from 0
        );
        return  ResponseEntity.status(HttpStatus.OK).body(pageResponse);
    }
    @PostMapping ("/admin/users")
    public  ResponseEntity<UserResponse> addAdmin(@RequestBody User user, @RequestHeader("Authorization") String jwt){
        User existUser = userService.findByJwt(jwt);
        User saveUser=userService.addAdminUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(saveUser.getId(),
                saveUser.getEmail(),
                saveUser.getName(),
                saveUser.getPhoneNumber(),
                saveUser.getCreateAt().toString(),
                saveUser.getRole()));
    }
    @GetMapping("/users")
    public ResponseEntity<UserResponse> getUserInformation(@RequestHeader("Authorization") String jwt){
        User exitUser= userService.findByJwt(jwt);
        return ResponseEntity.ok(new UserResponse(exitUser.getId(),
                exitUser.getEmail(),
                exitUser.getName(),
                exitUser.getPhoneNumber(),
                exitUser.getCreateAt().toString(),
                exitUser.getRole()));
    }
    @PutMapping("/users/change-password")
    public ResponseEntity <?> changePassword(@RequestHeader("Authorization") String jwt,
                                             @RequestBody ChangePasswordRequest request) {
        User exitUser = userService.findByJwt(jwt);
        User changeSuccessUser= userService.changePassword(exitUser,
                request.getOldPassword(),
                request.getNewPassword());
        return ResponseEntity.ok("Change password successfully");
    }

}
