package com.project.crm.dao;

import com.project.crm.model.Category;

import java.util.List;

/**
 * Basic Data Access Object interface.
 * Provide operations with {@link Category}.
 */
public interface CategoryDao {

    /**
     * Get the list of subcategories by top category.
     *
     * @param topCategory
     * @return list of {@link Category}.
     */
    List<Category> getCategoriesByTopCategory(String topCategory);

    /**
     * Get the list of top categories.
     *
     * @return list of {@link Category}.
     */
    List<Category> getAllTopCategories();
}
