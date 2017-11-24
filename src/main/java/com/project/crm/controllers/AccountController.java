package com.project.crm.controllers;

import com.project.crm.dao.UserDao;
import com.project.crm.dao.impl.UserDaoImpl;
import com.project.crm.model.Product;
import com.project.crm.model.User;
import com.project.crm.services.ProductService;
import com.project.crm.services.ProfileService;
import com.project.crm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @Autowired
    ProfileService profileService; //im use it for account!

    @Autowired
    ProductService productService; //Only for illustration of work :)

    @RequestMapping(value = "/account/{name}", method = RequestMethod.GET)
    public String account(@PathVariable String name, Model model) {
        int idOfCurrentUser = userService.findByUsername(name).getId();
        User currentUser = profileService.getUserByID(idOfCurrentUser);
        currentUser.setUserProductList(productService.getProductsByUser(currentUser)); // Only for illustration of work :)
        model.addAttribute("user", currentUser);
        return "account";
    }
}
