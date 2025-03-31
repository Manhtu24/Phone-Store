package com.MTlovec.Phone_Store.repository;

import com.MTlovec.Phone_Store.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface BrandRepository  extends JpaRepository<Brand, Long> {

    @Query("SELECT b FROM Brand b WHERE "+
            ":search IS NULL OR b.name=:search")
    Page<Brand> getBrands(Pageable pageable, @Param("search")String search);

    boolean existsByNameAndIdNot(String name, Long id);

    boolean existsByName(String name);

}
