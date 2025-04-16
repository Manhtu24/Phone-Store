package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.model.Product;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductController{

    private final UserService userService;



}
