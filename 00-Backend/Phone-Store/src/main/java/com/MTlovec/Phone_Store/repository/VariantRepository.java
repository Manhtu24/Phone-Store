package com.MTlovec.Phone_Store.repository;

import com.MTlovec.Phone_Store.model.Variants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantRepository extends JpaRepository<Variants,Long> {
    Variants findByName(String name);
    boolean existsByNameAndIdNot(String name, Long id);
}
