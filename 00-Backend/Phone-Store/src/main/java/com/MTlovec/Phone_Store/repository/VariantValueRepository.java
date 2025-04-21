package com.MTlovec.Phone_Store.repository;

import com.MTlovec.Phone_Store.model.VariantValues;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantValueRepository extends JpaRepository<VariantValues,Long> {
    VariantValues findByName(String name);

    Long findIdByName(String name);
}
