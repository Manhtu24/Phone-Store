package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.constant.ResponseConstant;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.request.VariantRequest;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import com.MTlovec.Phone_Store.response.ResponseDTO;
import com.MTlovec.Phone_Store.response.VariantResponse;
import com.MTlovec.Phone_Store.service.UserService;
import com.MTlovec.Phone_Store.service.VariantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class VariantController {

    private final UserService userService;

    private final VariantService variantService;


    @GetMapping("/variants")
    public ResponseEntity<List<VariantResponse>>getVariants(@RequestHeader("Authorization")String jwt){
        User user=userService.findByJwt(jwt);
        List <VariantResponse> variants=variantService.getVariants();
        return ResponseEntity.status(HttpStatus.OK)
                .body(variants);
    }

    @PostMapping("/variants")
    public ResponseEntity<ResponseDTO> createVariant(@RequestHeader("Authorization")String jwt,
                                                     @RequestBody VariantRequest variantRequest){
        User user=userService.findByJwt(jwt);
        variantService.createVariant(variantRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDTO(ResponseConstant.STATUS_201,
                        ResponseConstant.MESSAGE_201));
    }
    @PutMapping("/variants/{variantId}")
    public ResponseEntity<ResponseDTO> updateVariant(@RequestHeader("Authorization")String jwt,
                                                     @PathVariable Long variantId,
                                                     @RequestBody VariantRequest updateVariant){
        User user=userService.findByJwt(jwt);
        variantService.updateVariant(variantId,updateVariant);
        return ResponseEntity.status(HttpStatus.OK)
                    .body(new ResponseDTO(ResponseConstant.STATUS_200,
                            ResponseConstant.MESSAGE_200));
    }
    @DeleteMapping("/variants/{variantId}")
    public  ResponseEntity<ResponseDTO> deleteVariant(@RequestHeader("Authorization")String jwt,
                                                      @PathVariable Long variantId){
        User user=userService.findByJwt(jwt);
        variantService.deleteVariant(variantId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDTO(ResponseConstant.STATUS_200,
                        ResponseConstant.MESSAGE_200));
    }

}
