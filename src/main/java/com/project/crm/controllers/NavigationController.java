package com.project.crm.controllers;

import com.project.crm.model.Category;
import com.project.crm.model.Product;
import com.project.crm.services.CategoryService;
import com.project.crm.services.LikeService;
import com.project.crm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class NavigationController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    LikeService likeService;

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String main(Model model) {

        List<Category> supercategoryList = null;
        supercategoryList = categoryService.getAllTopCategories();
        model.addAttribute("productCategory", supercategoryList);
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("product_cost", productService.getAllProducts());
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
        System.out.println(supercategory);
        List<Product> productList = null;
        //category = "WOMEN_CLOTHING";
        //productList = productService.getProductsByCategory(category);
        productList = productService.getProductsBySupercategory(supercategory);
        System.out.println(productList);
        if (productList != null) {
            System.out.println("Super!");
        } else {
            System.out.println("Nothing to show.\n");
        }

        return productList;
    }

    @Secured(value={"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/add-product-to-favorites", method = RequestMethod.POST)
    public void addProductToFavorites(@RequestParam String productId){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        System.out.println("Almost");
        likeService.addProductToFavorites(productId, name);
        System.out.println("Added");
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "admin";
    }

    @RequestMapping(value = "/favorites", method = RequestMethod.GET)
    public String favorites(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("products", likeService.getFavoriteProductsByUsername(name));
        return "/favorites";
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
