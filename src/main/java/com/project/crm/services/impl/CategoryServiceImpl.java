package com.project.crm.services.impl;

import com.project.crm.dao.impl.CategoryDaoImpl;
import com.project.crm.model.Category;
import com.project.crm.model.Supercategory;

import java.util.List;

/**
 * Created by 1 on 07.11.2017.
 */
public class CategoryServiceImpl {
    private CategoryDaoImpl categoryDao = new CategoryDaoImpl();

    public List<Category> getAllCategoriesBySuCategories(Supercategory supercategory){
        return categoryDao.getCategoriesBySupercategory(supercategory);
    }
    public  List<Category> getAllCategories(){
        return categoryDao.getALLCategories();
    }
}
