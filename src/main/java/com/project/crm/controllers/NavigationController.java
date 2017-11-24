package com.project.crm.controllers;

import com.project.crm.dao.UserDao;
import com.project.crm.dao.impl.UserDaoImpl;
import com.project.crm.model.Category;
import com.project.crm.model.User;
import com.project.crm.repository.UserRepository;
import com.project.crm.services.CategoryService;
import com.project.crm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.plugin.liveconnect.SecurityContextHelper;

import java.util.List;
import java.util.Map;


@Controller
public class NavigationController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @RequestMapping(value = {"/", "/welcome", "/catalog"}, method = RequestMethod.GET)
    public String main(Model model) {

        List<Category> supercategoryList = null;
        supercategoryList = categoryService.getAllTopCategories();
        model.addAttribute("productCategory", supercategoryList);
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product_cost", productService.getAllProducts());
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
        return "/about";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
        return "profile";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account(Model model) {
        return "redirect:/account/" + SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
