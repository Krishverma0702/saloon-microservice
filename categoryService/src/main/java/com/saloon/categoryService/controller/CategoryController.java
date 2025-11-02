package com.saloon.categoryService.controller;

import com.saloon.categoryService.model.Category;
import com.saloon.categoryService.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/saloon/{id}")
    public ResponseEntity<Set<Category>> getCategoriesBySaloon(@PathVariable int id) {
        Set<Category> categories = categoryService.getAllCategoriesBySaloon(id);

        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable int id) throws Exception{
        Category category = categoryService.getCategoryById(id);

        return ResponseEntity.ok(category);
    }
}
