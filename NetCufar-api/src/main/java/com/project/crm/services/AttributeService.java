package com.project.crm.services;

import java.util.List;

/**
 * Service class for attributes of {@link com.project.crm.model.Product}
 */
public interface AttributeService {

    List<String> getAttributesByCategory(String category);
}
