package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.model.Address;

import java.util.List;

public interface AddressService {

    Address addAddress(Long userId, Address address);

    Address updateAddress(Long addressId, Address updateAddress);

    void deleteAddress(Long addressId);

    List<Address> getUserAddress(Long userId);

    Address getAddressById(Long addressId);
}
