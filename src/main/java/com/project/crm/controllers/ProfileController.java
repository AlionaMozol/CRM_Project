package com.project.crm.controllers;

import com.project.crm.model.User;
import com.project.crm.services.ProfileService;
import com.project.crm.services.UserService;
import com.project.crm.validator.ProfileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @Autowired
    UserService userService;

    @Autowired
    ProfileValidator profileValidator;

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public String allUsers (Model model, String error){
       if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        org.springframework.security.core.userdetails.User spring_user =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                        getContext().getAuthentication().getPrincipal();
        String username = spring_user.getUsername();
        int  id = userService.findByUsername(username).getId();
        model.addAttribute("profiles", profileService.getUserByID(id));
        return "/profiles";
    }

    @ModelAttribute("User")
    public User user() {
        org.springframework.security.core.userdetails.User spring_user =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                        getContext().getAuthentication().getPrincipal();
        String username = spring_user.getUsername();
        int  id = userService.findByUsername(username).getId();
        return profileService.getUserByID(id);
    }

   @RequestMapping(value="/profiles", method=RequestMethod.POST)
    public String profileSubmit(@ModelAttribute("User") User user,
                                BindingResult bindingResult, Model model) {
       profileValidator.validate(user,bindingResult);
       if (bindingResult.hasErrors()) {
           return "profiles";
       }
       model.addAttribute("profiles", user);
       profileService.updateUser(user);
       return "redirect: /profiles";
    }

}