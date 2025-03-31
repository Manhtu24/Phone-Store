package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.model.Category;
import com.MTlovec.Phone_Store.request.CategoryRequest;

import java.util.List;

public interface CategoryService {
    List <Category> getParentCategory(String search);

    List <Category> getSubCategory(Long parentId,String search);

    Category  createCategory(CategoryRequest category);

    void updateCategory(Long id, CategoryRequest newCategory);

    void deleteCategory(Long id);

}
