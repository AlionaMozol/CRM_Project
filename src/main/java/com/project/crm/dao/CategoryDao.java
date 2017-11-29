package com.project.crm.dao;

import com.project.crm.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 1 on 06.11.2017.
 */
@Component
public interface CategoryDao {

    List<Category> getCategoriesByTopCategory(String category);
    List<Category> getAllTopCategories();
}
