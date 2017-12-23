package com.project.crm.controllers;

import com.project.crm.services.CategoryService;
import com.project.crm.services.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller for favorites {@link com.project.crm.model.Product}'s pages
 */
@Controller
public class LikeController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    LikeService likeService;

    @RequestMapping(value = "/add-product-to-favorites", method = RequestMethod.GET)
    public void addProductToFavorites(@RequestParam String productId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        likeService.addProductToFavorites(productId, name);
    }

    @RequestMapping(value = "/remove-product-from-favorites", method = RequestMethod.GET)
    public void removeProductFromFavorites(@RequestParam String productId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        likeService.removeProductFromFavorites(productId, name);
    }

    @RequestMapping(value = "/favorites", method = RequestMethod.GET)
    public String favorites(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("products", likeService.getFavoriteProductsByUsername(name));
        model.addAttribute("favorite_products", likeService.getFavoriteProductsByUsername(name));
        return "/favorites";
    }

}