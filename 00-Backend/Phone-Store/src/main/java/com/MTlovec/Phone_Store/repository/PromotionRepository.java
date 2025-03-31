package com.MTlovec.Phone_Store.repository;

import com.MTlovec.Phone_Store.model.Promotion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface PromotionRepository  extends JpaRepository<Promotion, Long> {

    @Query("SELECT p FROM Promotion p WHERE "+
            "(:startedDate IS NULL AND :expiredDate IS NULL) "+
            "OR (:startedDate IS NOT NULL AND :expiredDate IS NOT NULL AND p.startTime >=:startedDate AND p.expiredTime >= :expiredDate) "+
            "OR (:startedDate IS NOT NULL AND :expiredDate IS NULL AND p.startTime >= :startedDate) "+
            "OR (:startedDate IS NULL AND :expiredDate IS NOT NULL AND p.expiredTime >= :expiredDate)")
    Page <Promotion> getVouchers(Pageable pageable,
                                 @Param("startedDate") LocalDate startedDate,
                                 @Param("expiredDate") LocalDate expiredDate);

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long id);
}
