package com.project.crm.controllers;

import com.project.crm.model.Category;
import com.project.crm.model.Product;
import com.project.crm.services.CategoryService;
import com.project.crm.services.LikeService;
import com.project.crm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class NavigationController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    LikeService likeService;

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String main(Model model) {
        List<Category> supercategoryList = null;
        supercategoryList = categoryService.getAllTopCategories();
        model.addAttribute("productCategory", supercategoryList);
        model.addAttribute("products", productService.getAllProducts());
        return "/welcome";
    }

   /*
    @RequestMapping(value = "/getCharNum", method = RequestMethod.GET)
    public @ResponseBody String getCharNum(@RequestParam String text) {

        String result = null;

        if (text != null) {
            result = text + "   " + text.length();
        }
        System.out.println(result);
        return result;
    }*/

    @RequestMapping(value = "/get-products-by-supercategory", method = RequestMethod.GET)
    public @ResponseBody
    List showProducts(@RequestParam String supercategory){
        List<Product> productList = null;
        productList = productService.getProductsBySupercategory(supercategory);
        return productList;
    }

/*
    @RequestMapping(value = "/add-product-to-favorites", method = RequestMethod.GET)
    public void addProductToFavorites(@RequestParam String productId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        likeService.addProductToFavorites(productId, name);
    }*/

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }
/*
    @RequestMapping(value = "/favorites", method = RequestMethod.GET)
    public String favorites(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("products", likeService.getFavoriteProductsByUsername(name));
        return "/favorites";
    }*/

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
