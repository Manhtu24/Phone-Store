package com.MTlovec.Phone_Store.repository;

import com.MTlovec.Phone_Store.model.PageSection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PageSectionRepository extends JpaRepository<PageSection,Long> {
    @Query("SELECT p FROM PageSection p WHERE "+
            ":searchTitle IS NULL OR p.title LIKE %:searchTitle AND "+
                ":searchGroup IS NULL OR p.sectionGroup=:searchGroup")
    Page<PageSection> getAllSection(Pageable pageable, @Param("searchTitle")String searchTitle,
                                    @Param("searchGroup") String searchGroup);

    PageSection findByTitle(String title);
}
