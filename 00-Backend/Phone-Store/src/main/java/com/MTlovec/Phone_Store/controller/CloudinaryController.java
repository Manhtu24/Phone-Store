package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.constant.CloudinaryConstant;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.service.CloudinaryService;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class CloudinaryController {

    private final UserService userService;

    private final CloudinaryService cloudinaryService;

    @GetMapping("/signature")
    public ResponseEntity<Map<String, String>> generateSignature(@RequestHeader("Authorization")String jwt){
        User user = userService.findByJwt(jwt);
        Map<String,String> signature= cloudinaryService.generateSignature();
        signature.put("api_key", CloudinaryConstant.API_KEY);
        signature.put("cloud_name", CloudinaryConstant.CLOUD_NAME);
        return ResponseEntity.ok(signature);
    }
}
