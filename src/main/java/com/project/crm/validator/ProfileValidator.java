package com.project.crm.validator;

import com.project.crm.model.User;
import com.project.crm.services.ProductService;
import com.project.crm.services.ProfileService;
import com.project.crm.services.UserService;
import com.project.crm.services.impl.ProductServiceImpl;
import com.project.crm.services.impl.ProfileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 1 on 22.11.2017.
 */

@Component
public class ProfileValidator implements Validator {

    @Autowired
    ProfileService profileService;

    @Autowired
    UserService userService;

    private String emailPattern="^([a-z0-9_\\.-])+@[a-z0-9-]+\\.([a-z]{2,4}\\.)?[a-z]{2,4}$";
    private String telephonePatten="^((80|\\+375|375))(\\(?\\d{2}\\)?)(\\d{3}\\-?)(\\-?\\d{2}\\-?)(\\-?\\d{2})$";
    private String cityPattern="^[а-яА-ЯёЁa-zA-Z]+$";
    private String fioPattern="^[а-яА-ЯёЁa-zA-Z\\s-]{0,40}$";

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    private boolean checkUniquenessEmail(String email){
        int id = profileService.getUserIdByEmail(email);
        org.springframework.security.core.userdetails.User spring_user =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                        getContext().getAuthentication().getPrincipal();
        String username = spring_user.getUsername();
        int  user_id = userService.findByUsername(username).getId();
        if(id!=-1 && user_id!=id){
            return false;
        }
        return true;
    }

    private boolean checkUniquenessTelephone(String telephone){
        int id = profileService.getUserIdByTelephone(telephone);
        org.springframework.security.core.userdetails.User spring_user =
                (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                        getContext().getAuthentication().getPrincipal();
        String username = spring_user.getUsername();
        int  user_id = userService.findByUsername(username).getId();
        if(id!=-1 && user_id!=id){
            return false;
        }
        return true;
    }

    private boolean checkField(String field, String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(field);
        return m.matches();
    }


    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if(!user.getEmail().equals("")) {
            if (!checkField(user.getEmail(),emailPattern)) {
                errors.rejectValue("email", "emailFormat.error");
            } else {
                if (!checkUniquenessEmail(user.getEmail())) {
                    errors.rejectValue("email", "emailUniq.error");
                }
            }
        }
        if(!user.getTelephone().equals("")) {
            if (!checkField(user.getTelephone(),telephonePatten)) {
                errors.rejectValue("telephone", "telephone.error");
            } else {
                if (!checkUniquenessTelephone(user.getTelephone())) {
                    errors.rejectValue("telephone", "telephone.error");
                }
            }
        }
        if (!user.getTelephone().equals("") && !checkField(user.getTelephone(),telephonePatten)) {
            errors.rejectValue("telephone", "telephone.error");
        }
        if (!user.getCity().equals("") && !checkField(user.getCity(),cityPattern)) {
            errors.rejectValue("city", "city.error");
        }
        if (!user.getFio().equals("") && !checkField(user.getFio(),fioPattern)) {
            errors.rejectValue("fio", "fio.error");
        }
    }
}
