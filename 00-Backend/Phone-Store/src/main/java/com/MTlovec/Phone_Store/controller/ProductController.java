package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.constant.ResponseConstant;
import com.MTlovec.Phone_Store.model.Product;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.request.ProductRequest;
import com.MTlovec.Phone_Store.response.ResponseDTO;
import com.MTlovec.Phone_Store.service.ProductService;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class ProductController{

    private final UserService userService;
    private final ProductService productService;

    @PostMapping ("/admin/products")
    public ResponseEntity<ResponseDTO> createProduct(@RequestBody ProductRequest productRequest,
                                                     @RequestHeader("Authorization")String jwt){
        User user=userService.findByJwt(jwt);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(new ResponseDTO(ResponseConstant.STATUS_201,
                        ResponseConstant.MESSAGE_201));
    }
    @PutMapping("/admin/products/{productId}")
    public ResponseEntity<ResponseDTO> updateProduct(@RequestHeader("Authorization")String jwt,
                                                     @RequestBody ProductRequest updateProduct,
                                                     @PathVariable Long productId){

        productService.updateProduct(productId,updateProduct);
        return  ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(ResponseConstant.STATUS_200,
                        ResponseConstant.MESSAGE_200));
    }
    @DeleteMapping("/admin/products/{productId}")
    public ResponseEntity<ResponseDTO> deleteProduct(@RequestHeader("Authorization")String jwt,
                                                     @PathVariable Long productId){

        productService.deleteProduct(productId);
        return  ResponseEntity.ok(new ResponseDTO(
                ResponseConstant.STATUS_200,
                ResponseConstant.MESSAGE_200
        ));
    }

}
