package com.project.crm.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AttributeService {

    List<String> getAttributesByCategory(String category);
}
