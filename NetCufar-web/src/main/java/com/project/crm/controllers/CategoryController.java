package com.project.crm.controllers;

import com.project.crm.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller for category of {@link com.project.crm.model.Product}
 */
@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    public List getSubcategories(@RequestParam String topCategory) {
        return categoryService.getCategoriesByTopCategory(topCategory);
    }

}
