package com.project.crm.controllers;

import com.project.crm.model.Category;
import com.project.crm.model.Product;
import com.project.crm.services.CategoryService;
import com.project.crm.services.LikeService;
import com.project.crm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Category> supercategoryList = null;
        supercategoryList = categoryService.getAllTopCategories();
        model.addAttribute("productCategory", supercategoryList);
        model.addAttribute("products", productService.getAllProducts());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("favorite_products", likeService.getFavoriteProductsByUsername(name));
        Locale locale = RequestContextUtils.getLocale(request);
        ResourceBundle bundle = ResourceBundle.getBundle("locales.messages", locale);
        model.addAttribute("keys", bundle.getKeys());
        return "/welcome";
    }

    @RequestMapping(value = "/update-products", method = RequestMethod.GET)
    public @ResponseBody List updateProducts(){
        List<Product> productList = null;
        productList = productService.getAllProducts();
        return productList;
    }

    @RequestMapping(value = "/get-products-by-supercategory", method = RequestMethod.GET)
    public @ResponseBody List getProductsBySupercategory(@RequestParam String supercategory, Model model){
        List<Product> productList = null;
        productList = productService.getProductsBySupercategory(supercategory);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("favorite_products", likeService.getFavoriteProductsByUsername(name));
        return productList;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
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
