package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.model.Brand;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.response.BrandResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import com.MTlovec.Phone_Store.service.BrandService;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BrandController {
    private final UserService userService;

    private final BrandService brandService;

    @GetMapping("/admin/brands")
    public ResponseEntity<PaginatedResponse<BrandResponse>> getBrands(@RequestHeader("Authorization")String jwt,
                                                                      @RequestParam(defaultValue = "0")int page,
                                                                      @RequestParam(defaultValue = "10")int size,
                                                                      @RequestParam(required = false)String search){
        User user = userService.findByJwt(jwt);
        PaginatedResponse<BrandResponse> brands= brandService.getBrands(page,size,search);
        return ResponseEntity.ok(brands);
    }

    @GetMapping("/admin/brands/{brandId}")
    public ResponseEntity<BrandResponse> getBrand(@RequestHeader("Authorization")String jwt,
                                                  @PathVariable Long brandId){
        User user = userService.findByJwt(jwt);
        BrandResponse brandResponse= brandService.getBrand(brandId);
        return  ResponseEntity.ok(brandResponse);
    }

    @PostMapping("/admin/brands")
    public ResponseEntity<BrandResponse> createBrand(@RequestHeader("Authorization")String jwt,
                                                     @RequestBody Brand brand){
        User user = userService.findByJwt(jwt);
        BrandResponse brandResponse= brandService.createBrand(brand);
        return ResponseEntity.ok(brandResponse);
    }

    @PutMapping("/admin/brands/{bradId}")
    public ResponseEntity<String> updateBrand(@RequestHeader("Authorization")String jwt,
                                              @RequestBody Brand updateBrand,
                                              @PathVariable Long brandId){
        User user = userService.findByJwt(jwt);
        brandService.updateBrand(brandId,updateBrand);
        return ResponseEntity.ok("Update successfully brand id: "+brandId);

    }

    @DeleteMapping("/admin/brands/{brandId}")
    public ResponseEntity<String> deleteBrad(@RequestHeader("Authorization")String jwt,
                                             @PathVariable Long brandId){
        User user = userService.findByJwt(jwt);
        brandService.deleteBrand(brandId);
        return ResponseEntity.ok("Delete successfully brand id :"+brandId);
    }

}
