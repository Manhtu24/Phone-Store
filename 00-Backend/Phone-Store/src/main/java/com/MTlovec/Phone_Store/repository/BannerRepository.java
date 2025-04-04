package com.MTlovec.Phone_Store.repository;

import com.MTlovec.Phone_Store.model.Banner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, Long> {

    @Query("SELECT b FROM Banner b WHERE"+
            ":search IS NULL OR b.pageName = :search")
    Page<Banner> getBanners(Pageable pageable, @Param("search")String search);

    List<Banner> findByPageName(String pageName);

    List<Banner> findImageOrdersByPageName(String pageName);
}
