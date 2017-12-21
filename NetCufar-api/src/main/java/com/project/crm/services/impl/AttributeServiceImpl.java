package com.project.crm.services.impl;

import com.project.crm.dao.AttributeDao;
import com.project.crm.services.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AttributeServiceImpl implements AttributeService{
    @Autowired
    AttributeDao attributeDao;

    @Override
    public List<String> getAttributesByCategory(String category) {
        return attributeDao.getAttributesByCategory(category);
    }
}
