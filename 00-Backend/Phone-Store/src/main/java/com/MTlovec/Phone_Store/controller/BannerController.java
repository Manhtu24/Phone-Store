package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.model.Banner;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.response.BannerResponse;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import com.MTlovec.Phone_Store.service.BannerService;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class BannerController {

    private final UserService userService;

    private final BannerService bannerService;

    @GetMapping("/admin/banners")
    public ResponseEntity<PaginatedResponse<BannerResponse>> getBanners(@RequestHeader("Authorization")String jwt,
                                                                        @RequestParam(defaultValue = "0")int page,
                                                                        @RequestParam(defaultValue = "10")int size,
                                                                        @RequestParam(required = false)String search){
        User user= userService.findByJwt(jwt);
        PaginatedResponse<BannerResponse> banners= bannerService.getBanners(page,size,search);
        return ResponseEntity.ok(banners);
    }

//    @GetMapping("admin/banners")
//    public ResponseEntity<List<BannerResponse>> getBanner(){
//        List<BannerResponse> responses=bannerService.getBanners();
//        return ResponseEntity.ok(responses);
//    }


    @PostMapping("/admin/banners")
    public ResponseEntity <BannerResponse> createBanner(@RequestHeader("Authorization")String jwt,
                                                        @RequestBody Banner banner){
        User user= userService.findByJwt(jwt);
        BannerResponse bannerResponse= bannerService.createBanner(banner);
        return ResponseEntity.ok(bannerResponse);
    }

    @PutMapping("/admin/banners/{bannerId}")
    public ResponseEntity<String> updateBanner(@RequestHeader("Authorization")String jwt,
                                             @PathVariable Long bannerId,
                                             @RequestBody Banner updateBanner) throws IOException {
        User user= userService.findByJwt(jwt);
        bannerService.updateBanner(bannerId,updateBanner);
        log.info("Update banner successfully");
        return ResponseEntity.ok("Update banner successfully");
    }
    @DeleteMapping("/admin/banners/{bannerId}")
    public ResponseEntity<String> deleteBanner(@RequestHeader("Authorization")String jwt,
                                               @PathVariable Long bannerId) throws IOException {
        User user=userService.findByJwt(jwt);
        bannerService.deleteBanner(bannerId);
        log.info("Delete successfully");
        return ResponseEntity.ok("Delete successfully");
    }
}
