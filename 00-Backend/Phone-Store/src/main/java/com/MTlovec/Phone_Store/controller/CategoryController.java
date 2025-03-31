package com.MTlovec.Phone_Store.controller;

import com.MTlovec.Phone_Store.exception.NotFoundException;
import com.MTlovec.Phone_Store.model.Category;
import com.MTlovec.Phone_Store.model.User;
import com.MTlovec.Phone_Store.request.CategoryRequest;
import com.MTlovec.Phone_Store.response.CategoryResponse;
import com.MTlovec.Phone_Store.service.CategoryService;
import com.MTlovec.Phone_Store.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CategoryController {

    private final UserService userService;

    private final CategoryService categoryService;


    @GetMapping("/parent-categories")
    public ResponseEntity<List<CategoryResponse>> getParentCategories(@RequestParam(required = false)String search){
        List<Category> parentCategory=categoryService.getParentCategory(search);
        List<CategoryResponse> responses=parentCategory.stream().map(
                parent->new CategoryResponse(
                        parent.getId(),
                        parent.getName(),
                        null
                )).toList();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/sub-categories")
    public ResponseEntity<List<CategoryResponse>> getSubCategories(@RequestParam(required = false)Long parentId,
                                                                   @RequestParam(required = false)String search){
        List<Category> categories=categoryService.getSubCategory(parentId,search);
        List<CategoryResponse> responses=categories.stream().map(
                subCate->new CategoryResponse(
                        subCate.getId(),
                        subCate.getName(),
                        subCate.getParent().getName()
                )
        ).toList();
        return ResponseEntity.ok(responses);
    }

    @PostMapping("/admin/categories")
    public ResponseEntity<Category> addCategory(@RequestHeader("Authorization")String jwt,
                                                @RequestBody CategoryRequest request){
        User user= userService.findByJwt(jwt);
        Category category= categoryService.createCategory(request);
        return ResponseEntity.ok(category);
    }

    @PutMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestHeader("Authorization") String jwt,
                                                 @PathVariable Long categoryId,
                                                 @RequestBody CategoryRequest newCategory){
        User user= userService.findByJwt(jwt);
        categoryService.updateCategory(categoryId,newCategory);
        return ResponseEntity.ok("Update Successfully");
    }


    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@RequestHeader("Authorization")String jwt,
                                               @PathVariable Long categoryId){
        User user= userService.findByJwt(jwt);
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Delete successfully");
    }
}
