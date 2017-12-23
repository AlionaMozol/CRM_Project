package com.project.crm.dao;

import java.util.List;

/**
 * Basic Data Access Object interface.
 * Provide operation with attributes of {@link com.project.crm.model.Product} object.
 */
public interface AttributeDao {

    /**
     * Get the list of attributes by category.
     *
     * @param category
     * @return list of attributes.
     */
    List<String> getAttributesByCategory(String category);
}
