package com.project.crm.controllers;

import com.project.crm.model.User;
import com.project.crm.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller for {@link User} account pages
 */
@Controller
public class AccountController {

    @Autowired
    ProfileService profileService;

    @RequestMapping(value = "/account/{name}", method = RequestMethod.GET)
    public String account(@PathVariable String name, Model model) {
        User currentUserFull = profileService.getUserByUsername(name);
        model.addAttribute("user", currentUserFull);
        return "account";
    }
}
