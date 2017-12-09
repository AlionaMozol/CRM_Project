package com.project.crm.controllers;

import com.project.crm.model.User;
import com.project.crm.services.ProfileService;
import com.project.crm.services.UserService;
import com.project.crm.validator.ProfileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @Autowired
    UserService userService;

    @Autowired
    ProfileValidator profileValidator;

    @RequestMapping(value = "/profiles", method = RequestMethod.GET)
    public String allUsers (Model model){
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


    @RequestMapping(value = "/checkEmail")
    public @ResponseBody int checkEmail(@RequestParam String email){
        int id=0;
        id = profileService.getUserIdByEmail(email);
        org.springframework.security.core.userdetails.User spring_user =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                        getContext().getAuthentication().getPrincipal();
        String username = spring_user.getUsername();
        int  user_id = userService.findByUsername(username).getId();
        if(id!=-1 && user_id!=id){
            return -1;
        }
        return 1;
    }

    @RequestMapping(value = "/checkTelephone")
    public @ResponseBody int checkTelephone(@RequestParam String telephone){
        int id=0;
        id = profileService.getUserIdByTelephone(telephone);
        org.springframework.security.core.userdetails.User spring_user =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                        getContext().getAuthentication().getPrincipal();
        String username = spring_user.getUsername();
        int  user_id = userService.findByUsername(username).getId();
        if(id!=-1 && user_id!=id){
            return -1;
        }
        return 1;
    }

    @RequestMapping(value="/profiles", method=RequestMethod.POST)
    public String profileSubmit(@ModelAttribute("User") User user,
                                BindingResult bindingResult, Model model) {
        profileValidator.validate(user,bindingResult);
        if (bindingResult.hasErrors()) {
            return "redirect: /profiles";
        }
        model.addAttribute("profiles", user);
        profileService.updateUser(user);
        return "redirect: /account";
    }

    @RequestMapping(value = "/all_profiles", method = RequestMethod.GET)
    public String allProducts (Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        model.addAttribute("profiles", profileService.getAllUsers());
        return "/all_profiles";
    }

    @RequestMapping(value="/all_profiles", method=RequestMethod.POST)
    public String changeStatus(@ModelAttribute("User") User user,
                                BindingResult bindingResult, Model model) {
        if(user.getStatus().equals("UNBLOCKED")){
            user.setStatus("BLOCKED");
        }
        else{
            user.setStatus("UNBLOCKED");
        }
        System.out.println(user.getStatus());
        profileService.updateUser(user);

        return "redirect: /all_profiles";
    }

}