package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.model.Address;
import com.MTlovec.Phone_Store.security.JWTGenerator;
import com.MTlovec.Phone_Store.service.AddressService;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/api/addresses")
public class AddressController {
    private final AddressService addressService;

    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Address>> getUserAddresses(@RequestHeader("Authorization") String jwt){
        Long userId= userService.findByJwt(jwt).getId();
        List<Address> addresses= addressService.getUserAddress(userId);
        return ResponseEntity.ok(addresses);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestHeader("Authorization") String jwt,
                                              @RequestBody Address address){
        Long userId= userService.findByJwt(jwt).getId();
        return ResponseEntity.ok(addressService.addAddress(userId,address));
    }
    @PutMapping("/{addressId}")
    public ResponseEntity<Address> updateAddress(@RequestHeader("Authorization") String jwt,
                                                 @RequestBody Address updateAddress,
                                                 @RequestParam Long addressId){
        Long userId= userService.findByJwt(jwt).getId();
        Address address=addressService.getAddressById(addressId);
        if(!address.getUser().getId().equals(userId)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        return ResponseEntity.ok(addressService.updateAddress(userId,updateAddress));
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Void> deleteAddress(@RequestHeader("Authorization")String jwt,
                                              @RequestParam Long addressId){
        Long userId= userService.findByJwt(jwt).getId();
        Address address= addressService.getAddressById(addressId);
        if(!address.getUser().getId().equals(userId)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
        addressService.deleteAddress(addressId);
        return ResponseEntity.noContent().build();
    }
}
