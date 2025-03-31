package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.model.Promotion;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.response.PaginatedResponse;
import com.MTlovec.Phone_Store.service.PromotionService;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class PromotionController {

    private final PromotionService promotionService;

    private final UserService userService;

    @GetMapping("/admin/vouchers")
    public ResponseEntity<PaginatedResponse<Promotion>> getVouchers(@RequestHeader("Authorization") String jwt,
                                                         @RequestParam int page,
                                                         @RequestParam int size,
                                                         @RequestParam(required = false) LocalDate startedDate,
                                                         @RequestParam(required = false) LocalDate expiredDate){
        User user= userService.findByJwt(jwt);
        PaginatedResponse<Promotion> response= promotionService.getVouchers(page,size,startedDate,expiredDate);
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/admin/vouchers/{voucherId}")
    public ResponseEntity<Promotion> getVoucher(@RequestHeader("Authorization") String jwt,
                                                @PathVariable Long voucherId){
        User user= userService.findByJwt(jwt);
        Promotion voucher= promotionService.getVoucher(voucherId);

        return ResponseEntity.ok(voucher);
    }

    //create promotion (voucher)
    @PostMapping("/admin/vouchers")
    public ResponseEntity<Promotion> createVoucher(@RequestHeader("Authorization") String jwt,
                                                   @RequestBody Promotion promotion){
        User user= userService.findByJwt(jwt);
        Promotion voucher= promotionService.createVoucher(promotion);
        return  ResponseEntity.ok(voucher);
    }

    @PutMapping("/admin/vouchers/{voucherId}")
    public ResponseEntity<String> updateVoucher(@RequestHeader("Authorization")String jwt,
                                                @RequestBody Promotion updateVoucher,
                                                @PathVariable Long voucherId){
        User user= userService.findByJwt(jwt);
        promotionService.updateVoucher(voucherId,updateVoucher);
        log.info("Update voucher successfully "+voucherId);
        return ResponseEntity.ok("Update successfully voucher with id: "+voucherId );
    }


    @DeleteMapping("/admin/vouchers/{voucherId}")
    public ResponseEntity<String> deleteVoucher(@PathVariable Long voucherId,
                                                @RequestHeader("Authorization") String jwt){
        User user= userService.findByJwt(jwt);
        promotionService.deleteVoucher(voucherId);
        return ResponseEntity.ok("Delete voucher successfully");
    }
    private LocalDate formatDate(String date){
        DateTimeFormatter inputFormater= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter outputFormater= DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate date1 =LocalDate.parse(date,inputFormater);
        String localDate= date1.format(outputFormater);
        return LocalDate.parse(localDate);

    }
}
