package com.project.crm.validator;

import com.project.crm.model.User;
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

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    public static boolean checkEmail(String userNameString){
        Pattern p = Pattern.compile("^([a-z0-9_\\.-])+@[a-z0-9-]+\\.([a-z]{2,4}\\.)?[a-z]{2,4}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
    public static boolean checkTelephone(String userNameString){
        Pattern p = Pattern.compile("^\\+?([0-9]{2})?\\(?[0-9]{3}\\)?[0-9]{3}\\-?[0-9]{2}\\-?[0-9]{2}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
    public static boolean checkCity(String userNameString){
        Pattern p = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]+$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
    public static boolean checkFio(String userNameString){
        Pattern p = Pattern.compile("^[а-яА-ЯёЁa-zA-Z\\s-]{0,15}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        if (!user.getEmail().equals("") && !checkEmail(user.getEmail())) {
            errors.rejectValue("email", "email.error");
        }
        if (!user.getTelephone().equals("") && !checkTelephone(user.getTelephone())) {
            errors.rejectValue("telephone", "telephone.error");
        }
        if (!user.getCity().equals("") && !checkCity(user.getCity())) {
            errors.rejectValue("city", "city.error");
        }
        if (!user.getFio().equals("") && !checkFio(user.getFio())) {
            errors.rejectValue("fio", "fio.error");
        }
    }
}
