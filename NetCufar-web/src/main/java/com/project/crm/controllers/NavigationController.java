package com.project.crm.controllers;


import com.project.crm.model.Category;
import com.project.crm.model.Product;
import com.project.crm.model.enums.ProductStatus;
import com.project.crm.services.CategoryService;
import com.project.crm.services.LikeService;
import com.project.crm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Controller for navigation containing simple methods get
 */
@Controller
public class NavigationController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    LikeService likeService;

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String main(Model model, HttpServletRequest request) {
        List<Category> supercategoryList;
        supercategoryList = categoryService.getAllTopCategories();
        model.addAttribute("productCategory", supercategoryList);
        if (request.getParameter("q") != null && !request.getParameter("q").replaceAll("\\s", "").equals("")) {
            model.addAttribute("products", productService.getProductsByKeyWords(request.getParameter("q")));
        } else {
            model.addAttribute("products", productService.getProductsByStatus(ProductStatus.APPROVED));
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("favorite_products", likeService.getFavoriteProductsByUsername(name));
        Locale locale = RequestContextUtils.getLocale(request);
        ResourceBundle bundle = ResourceBundle.getBundle("locales.messages", locale);
        model.addAttribute("keys", bundle.getKeys());
        return "/welcome";
    }

    @RequestMapping(value = "/update-products", method = RequestMethod.GET)
    public @ResponseBody
    List updateProducts() {
        List<Product> productList;
        productList = productService.getAllProducts();
        return productList;
    }

    @RequestMapping(value = "/get-products-by-supercategory", method = RequestMethod.GET)
    public @ResponseBody
    List getProductsBySuperCategory(@RequestParam String supercategory, Model model) {
        List<Product> productList;
        productList = productService.getProductsBySuperCategory(supercategory);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("favorite_products", likeService.getFavoriteProductsByUsername(name));
        return productList;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
        return "/about";
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile() {
        return "/profile";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String account() {
        return "redirect:/account/" + SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
