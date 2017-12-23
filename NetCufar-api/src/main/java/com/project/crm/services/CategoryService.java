package com.project.crm.services;

import com.project.crm.model.Category;

import java.util.List;
import java.util.Map;

/**
 * Service class for {@link Category} of {@link com.project.crm.model.Product}
 */
public interface CategoryService {

    List<Category> getCategoriesByTopCategory(String category);

    List<Category> getAllTopCategories();

    Map<Category, List<Category>> getTopCategoriesWithSubCategory();
}
