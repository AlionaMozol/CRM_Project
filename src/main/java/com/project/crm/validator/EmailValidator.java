package com.project.crm.validator;

import com.project.crm.model.Email;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class EmailValidator implements Validator{
    private boolean checkEmail(String email){
        Pattern p = Pattern.compile("^([a-z0-9_\\.-])+@[a-z0-9-]+\\.([a-z]{2,4}\\.)?[a-z]{2,4}$");
        Matcher m = p.matcher(email);
        return m.matches();
    }

    private boolean checkTitle(String userNameString){
        Pattern p = Pattern.compile("^[0-9а-яА-ЯёЁa-zA-Z]{0,70}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }
    private boolean checkMessage(String userNameString){
        Pattern p = Pattern.compile("^[0-9а-яА-ЯёЁa-zA-Z]{0,500}$");
        Matcher m = p.matcher(userNameString);
        return m.matches();
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Email.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Email email = (Email) o;
        if(email.getFrom().length() == 0 || !checkEmail(email.getFrom())) {
            errors.rejectValue("from", "emailFormat.error");
        }
        if (email.getTitle().length() == 0 || !checkTitle(email.getTitle())) {
            errors.rejectValue("title", "title.error");
        }
        if (email.getMessage().length() == 0 || !checkMessage(email.getMessage())) {
            errors.rejectValue("message", "message.error");
        }
    }
}

