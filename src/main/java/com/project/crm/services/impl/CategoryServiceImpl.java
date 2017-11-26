package com.project.crm.services.impl;

import com.project.crm.dao.CategoryDao;
import com.project.crm.model.Category;
import com.project.crm.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getCategoriesByTopCategory(Category category) {
        return categoryDao.getCategoriesByTopCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public List<Category> getAllTopCategories() {
        return categoryDao.getAllTopCategories();
    }
}
