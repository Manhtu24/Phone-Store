package com.MTlovec.Phone_Store.repository;

import com.MTlovec.Phone_Store.model.USER_ROLE;
import com.MTlovec.Phone_Store.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE "+
            "(:role IS NULL OR u.role = :role) AND (:search IS NULL OR LOWER(u.name) LIKE %:search)")
    Page<User> findUserByRoleAndSearch(Pageable pageable,
                                       @Param("role") USER_ROLE role,
                                       @Param("search")  String search);
}
