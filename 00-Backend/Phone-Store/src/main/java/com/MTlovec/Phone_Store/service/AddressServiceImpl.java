package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.model.Address;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.repository.AddressRepository;
import com.MTlovec.Phone_Store.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService{

    private final UserRepository userRepository;

    private final AddressRepository addressRepository;


    @Override
    public Address getAddressById(Long addressId) {
        Address address= addressRepository.findById(addressId).orElseThrow(()->
                new RuntimeException("Can not found this address"));
        return address;
    }

    @Override
    public Address addAddress(Long userId, Address address) {
        User user= userRepository.findById(userId).orElseThrow(()->
                new RuntimeException("User not found"));
        address.setUser(user);
        if(!addressRepository.existData()){
            address.setDefault(true);
        }
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long addressId, Address updateAddress) {
        Address address= addressRepository.findById(addressId).orElseThrow(()->
                new RuntimeException("Address not found")
        );
        address.setCompanyName(updateAddress.getCompanyName());
        address.setAddress(updateAddress.getAddress());
        address.setCity(updateAddress.getCity());
        address.setDistrict(updateAddress.getDistrict());
        address.setCommune(updateAddress.getCommune());
        address.setPinCode(updateAddress.getPinCode());
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Long addressId) {
        if(!addressRepository.existsById(addressId)){
            throw  new RuntimeException("Address not found");
        }
        addressRepository.deleteById(addressId);
    }

    @Override
    public List<Address> getUserAddress(Long userId) {
        return addressRepository.findByUserId(userId);
    }
}
