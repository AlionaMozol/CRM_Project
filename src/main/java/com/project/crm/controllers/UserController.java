package com.project.crm.controllers;

import com.project.crm.model.User;
import com.project.crm.services.ProfileService;
import com.project.crm.services.security.SecurityService;
import com.project.crm.services.UserService;
import com.project.crm.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Controller for {@link com.project.crm.model.User}'s pages.
 *
 * @author Ivan Tkachev
 * @version 1.0
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        User user = new User();
        user.setId(userForm.getId());
        user.setCity("");
        user.setTelephone("");
        user.setDateOfBirth("");
        user.setEmail("");
        user.setSex("");
        user.setFio("");
        user.setStatus("0");
        user.setRating("0");
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        user.setAccountCreationDate(formatForDateNow.format(date));
        profileService.addUser(user);
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            System.out.print(error);
            model.addAttribute("error", "Username or password is incorrect.");
        }

        if (logout != null) {
            model.addAttribute("message", "Logged out successfully.");
        }

        return "login";
    }
}
