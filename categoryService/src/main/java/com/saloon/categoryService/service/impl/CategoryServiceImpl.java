package com.saloon.categoryService.service.impl;

import com.saloon.categoryService.dto.SaloonDTO;
import com.saloon.categoryService.model.Category;
import com.saloon.categoryService.repository.CategoryRepository;
import com.saloon.categoryService.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category saveCategory(Category category, SaloonDTO saloonDTO) {

        Category newCatagory = new Category();
        newCatagory.setName(category.getName());
        newCatagory.setSaloonId(category.getSaloonId());
        newCatagory.setImage(category.getImage());

        return categoryRepository.save(newCatagory);
    }

    @Override
    public Set<Category> getAllCategoriesBySaloon(int id) {
        return categoryRepository.findBySaloonId(id);
    }

    @Override
    public Category getCategoryById(int id) throws Exception {
        Category category = categoryRepository.findById(id).orElse(null);

        if(category == null) {
            throw new Exception("Category not exist with id:" + id);
        }
        return category;
    }

    @Override
    public void deleteCategoryById(int id, int saloonId) throws Exception {
        Category category = getCategoryById(id);

        if(category.getSaloonId() != saloonId) {
            throw new Exception("You don't have permission to delete this category");
        }
        categoryRepository.deleteById(id);
    }
}
