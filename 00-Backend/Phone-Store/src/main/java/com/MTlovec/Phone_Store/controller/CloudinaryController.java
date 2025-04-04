package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.constant.CloudinaryConstant;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.service.CloudinaryService;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class CloudinaryController {

    private final UserService userService;

    private final CloudinaryService cloudinaryService;

    @GetMapping("/signature")
    public ResponseEntity<Map<String, Object>> generateSignature(@RequestHeader("Authorization")String jwt,
                                                                  @RequestParam String folder) throws NoSuchAlgorithmException, InvalidKeyException {
        User user = userService.findByJwt(jwt);
        Map<String,Object> signature= cloudinaryService.generateSignature2(folder);
        signature.put("api_key", CloudinaryConstant.API_KEY);
        signature.put("cloud_name", CloudinaryConstant.CLOUD_NAME);
        return ResponseEntity.ok(signature);
    }
//    @DeleteMapping("/delete-images")
//    public ResponseEntity<Void> deleteImage(@RequestHeader("Authorization")String jwt,
//                                            @RequestBody Map<String,String> images){
//        for (int i=0;i<images.size();i++){
//            cloudinaryService.deleteImage(images.)
//        }
//    }
}
