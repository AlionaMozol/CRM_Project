package com.project.crm.controllers;

import com.project.crm.model.Category;
import com.project.crm.model.Supercategory;
import com.project.crm.services.CategoryService;
import com.project.crm.services.impl.CategoryServiceImpl;
import com.project.crm.services.impl.SupercategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class NavigationController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String main(Model model) {

        List<Category> supercategoryList = null;
        supercategoryList = categoryService.getAllTopCategories();
        model.addAttribute("productCategory", supercategoryList);
        return "/welcome";

    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }


    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String catalog(Model model) {
        return "catalog";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about(Model model) {
        return "about";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
        return "profile";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account(Model model) {
        return "account";
    }

}
