package com.project.crm.services;

import com.project.crm.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> getCategoriesByTopCategory(Category category);
    List<Category> getAllTopCategories();
}
