package com.saloon.categoryService.service;

import com.saloon.categoryService.dto.SaloonDTO;
import com.saloon.categoryService.model.Category;

import java.util.Set;

public interface CategoryService {

    Category saveCategory(Category category, SaloonDTO saloonDTO);

    Set<Category> getAllCategoriesBySaloon(int id);

    Category getCategoryById(int id) throws Exception;

    void deleteCategoryById(int id, int saloonId) throws Exception;
}
