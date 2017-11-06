package com.project.crm.dao;

import com.project.crm.model.Category;
import com.project.crm.model.Supercategory;

import java.util.List;

/**
 * Created by 1 on 06.11.2017.
 */
public interface CategoryDao {

    public List<Category> getCategoriesBySupercategory(Supercategory supercategory);
    public List<Category> getALLCategories();
}
