package com.saloon.categoryService.repository;

import com.saloon.categoryService.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Set<Category> findBySaloonId(int saloonId);
}
