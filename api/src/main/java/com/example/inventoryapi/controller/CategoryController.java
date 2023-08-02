package com.example.inventoryapi.controller;

import com.example.inventoryapi.exception.ResourceNotFoundException;
import com.example.inventoryapi.model.CategoryModel;
import com.example.inventoryapi.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public Page<CategoryModel> getCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }


    @PostMapping("/category")
    public CategoryModel createCategory(@Valid @RequestBody CategoryModel category) {
        return categoryRepository.save(category);
    }

    @PutMapping("/category/{categoryId}")
    public CategoryModel updateCategory(@PathVariable Long categoryId,
                                   @Valid @RequestBody CategoryModel categoryRequest) {
        return categoryRepository.findById(categoryId)
                .map(category -> {
                    category.setTitle(categoryRequest.getTitle());
                    return categoryRepository.save(category);
                }).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));
    }


    @DeleteMapping("/category/{categoryId}")
    public ResponseEntity<?> deleteBrand(@PathVariable Long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(category -> {
                    categoryRepository.delete(category);
                    return ResponseEntity.ok().build();
                }).orElseThrow(() -> new ResourceNotFoundException("Category not found with id " + categoryId));
    }
}
