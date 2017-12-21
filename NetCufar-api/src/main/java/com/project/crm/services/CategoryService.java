package com.project.crm.services;

import com.project.crm.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface CategoryService {

    List<Category> getCategoriesByTopCategory(String category);
    List<Category> getAllTopCategories();
    Map<Category, List<Category>> getTopCategoriesWithSubCategory();
}
