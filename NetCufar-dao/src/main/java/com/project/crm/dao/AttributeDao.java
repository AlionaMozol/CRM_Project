package com.project.crm.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AttributeDao {

    List<String> getAttributesByCategory(String category);
}
