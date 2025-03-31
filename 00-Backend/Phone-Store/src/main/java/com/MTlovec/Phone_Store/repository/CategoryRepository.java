package com.MTlovec.Phone_Store.repository;

import com.MTlovec.Phone_Store.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long>  {
    @Query("SELECT c FROM Category c WHERE "+
             "(:search IS NULL OR LOWER(c.name) LIKE %:search) "+
                "AND (c.parent IS NULL)")
    List<Category> findParentCategory(@Param("search")String search);

    @Query("SELECT c FROM Category c WHERE "+
                 "(c.parent IS NOT NULL) AND (:parentId is NULL OR c.parent.id=:parentId) "+
                    "AND (:search IS NULL OR LOWER(c.name) LIKE %:search)")
    List<Category> findByParentIsNotNull(@Param("parentId")Long parentId, @Param("search")String search);

    Category findByName(String name);

    List <Category>  findByParentId(Long id);

    boolean existsByNameAndIdNot(String name,Long id);

    @Query("SELECT c FROM Category c WHERE c.parent.id=:parentId")
    List <Category> findChildrenByParentId(@Param("parentId")Long parentId);
}
