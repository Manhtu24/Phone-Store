package com.MTlovec.Phone_Store.repository;

import com.MTlovec.Phone_Store.model.News;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NewsRepository extends JpaRepository<News, Long> {
    News findByTitle(String title);
    boolean existsByTitleAndIdNot(String title, Long id);
    @Query("SELECT n FROM News n")
    Page<News> getPosts(Pageable pageable);
    boolean existsByTitle(String title);
}
