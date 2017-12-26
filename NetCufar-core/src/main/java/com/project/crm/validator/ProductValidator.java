package com.project.crm.validator;

import com.project.crm.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Validator for {@link Product} class,
 * implements {@link Validator} interface.
 */
@Component
public class ProductValidator implements Validator {


    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.equals(aClass);
    }

    private boolean checkField(String field, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(field);
        return m.matches();
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;

        //superCategory
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "superCategory", "superCategory");
        if(product.getSuperCategory().length()>30)
            errors.rejectValue("superCategory", "error.large");

        //category
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "category", "category");
        if(product.getCategory().length()>30)
            errors.rejectValue("category", "error.large");

        //title
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.null");
        if (product.getTitle().length() > 30)
            errors.rejectValue("title", "title.error.large");

        //cost
        if (product.getCost() == null)
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cost", "error.null");
        else {
            String costPattern = "^([1-9]{1}[0-9]{0,7})(\\s)(BYN|\\$|\\€)$";
            if (!checkField(product.getCost(), costPattern))
                errors.rejectValue("cost", "cost.error");
        }
        //attributes
        for (Map.Entry<String, String> entry : product.getAttributesAndValues().entrySet()) {
            if(entry.getValue().length()>30)
                errors.rejectValue("description", "error.large");
        }

        //description
        if(product.getDescription().length()>139)
            errors.rejectValue("description", "error.large");
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "product.description");
    }
}
