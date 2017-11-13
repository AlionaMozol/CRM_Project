package com.project.crm.controllers;

import com.project.crm.model.Supercategory;
import com.project.crm.services.impl.SupercategoryServiceImpl;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class CategoryController {

    private SupercategoryServiceImpl supercategoryService = new SupercategoryServiceImpl();

    @RequestMapping(value = "/leftmenu", method = RequestMethod.GET)
    public String getAllCategories(Model model){
        List<Supercategory> supercategories = supercategoryService.getAllSypercategories();
        JSONArray jsonArray = new JSONArray();
        for (Supercategory item : supercategories) {
            jsonArray.put(item.getTitle());
        }
        //String forResponse = jsonArray.toString();

        model.addAttribute(jsonArray);

        return "LeftMenu_layout";
    }
}
