//package com.MTlovec.Phone_Store.repository;
//
//import com.MTlovec.Phone_Store.model.News;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//public interface NewsRepository extends JpaRepository<News, Long> {
//
//    @Query("SELECT p FROM News p ORDER BY p-createAt :sortDirection")
//    Page<News> getPost(Pageable pageable,
//                       @Param("sortDirection") String sortDirection);
//
//
//}
