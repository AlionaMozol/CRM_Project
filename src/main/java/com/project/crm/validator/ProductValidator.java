package com.project.crm.validator;

import com.project.crm.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator{

    private String emailPattern="^([a-z0-9_\\.-])+@[a-z0-9-]+\\.([a-z]{2,4}\\.)?[a-z]{2,4}$";
    private String telephonePatten="^((80|\\+375|375))(\\(?\\d{2}\\)?)(\\d{3}\\-?)(\\-?\\d{2}\\-?)(\\-?\\d{2})$";
    private String cityPattern="^[а-яА-ЯёЁa-zA-Z]+$";
    private String fioPattern="^[а-яА-ЯёЁa-zA-Z\\s-]{0,40}$";

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        //superCategory
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "superCategory", "superCategory");

        //category
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "category");

        //title
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.error.null");
        if(product.getTitle().length() > 100)
            errors.rejectValue("title", "title.error.large");

        //cost
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cost", "product.cost");

        //description
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "product.description");
    }
}
