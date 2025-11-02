package com.saloon.categoryService.controller;

import com.saloon.categoryService.dto.SaloonDTO;
import com.saloon.categoryService.model.Category;
import com.saloon.categoryService.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/categories/saloon-owner")
@RequiredArgsConstructor
public class SaloonCategoryController {

    private final CategoryService categoryService;

    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {

        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1);
        Category savedCategory = categoryService.saveCategory(category, saloonDTO);

        return ResponseEntity.ok(savedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable int id) throws Exception {

        SaloonDTO saloonDTO = new SaloonDTO();
        saloonDTO.setId(1);
        categoryService.deleteCategoryById(id, saloonDTO.getId());

        return ResponseEntity.ok("Category Deleted Succesfully");
    }
}
