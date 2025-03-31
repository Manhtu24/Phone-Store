package com.MTlovec.Phone_Store.service;

import com.MTlovec.Phone_Store.exception.CategoryAlreadyExistException;
import com.MTlovec.Phone_Store.exception.NotFoundException;
import com.MTlovec.Phone_Store.model.Category;
import com.MTlovec.Phone_Store.repository.CategoryRepository;
import com.MTlovec.Phone_Store.request.CategoryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getParentCategory(String search) {
        return categoryRepository.findParentCategory(search);
    }

    @Override
    public List<Category> getSubCategory(Long parentId, String search) {
       List<Category> categories= categoryRepository.findByParentIsNotNull(parentId,search);
       return categories;
    }

    @Override
    public Category  createCategory(CategoryRequest categoryRequest) {
        Category exitstCategory=categoryRepository.findByName( categoryRequest.getName());
        if(exitstCategory!=null){
            throw new CategoryAlreadyExistException("Category already exist with name "+exitstCategory.getName());
        }
        Category category= new Category();
        category.setName(categoryRequest.getName());
        category.setDescription(categoryRequest.getDescription());
        if(categoryRequest.getParentId()!=null){
            Category parentCategory=categoryRepository.findById(categoryRequest.getParentId())
                    .orElseThrow(()->new NotFoundException("Could not found category"));
            category.setParent(parentCategory);
        }
        return categoryRepository.save(category);
    }

    @Override
    public void updateCategory(Long id, CategoryRequest newCategory) {
        Category category= categoryRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Can not found category to"));
        if(categoryRepository.existsByNameAndIdNot(newCategory.getName(),id)){
            throw new CategoryAlreadyExistException("Can not change because new category name already exist");
        }
        category.setName(newCategory.getName());
        category.setDescription(newCategory.getDescription());
        if (newCategory.getParentId()!=null){
            Category parentCategory=categoryRepository.findById(newCategory.getParentId())
                    .orElseThrow(()->new NotFoundException("Could not found parent category"));
            category.setParent(parentCategory);
        }
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        Category category= categoryRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Could not found this category"));
        if(!categoryRepository.findChildrenByParentId(id).isEmpty()){
            throw new RuntimeException("Can not remove this category because it has subcategory");
        }
        categoryRepository.delete(category);
    }
}
