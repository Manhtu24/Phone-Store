package com.MTlovec.Phone_Store.repository;

import com.MTlovec.Phone_Store.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByUserId(Long userId);

    default boolean existData(){
        return count()>0;
    }

}
