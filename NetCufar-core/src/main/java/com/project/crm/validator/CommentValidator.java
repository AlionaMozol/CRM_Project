package com.project.crm.validator;


import com.project.crm.model.Comment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Validator for {@link Comment} of {@link com.project.crm.model.User} class,
 * implements {@link Validator} interface.
 */
@Component
public class CommentValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Comment.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Comment comment = (Comment) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "comment.empty");


        if (comment.getText().length() > 140) {
            errors.rejectValue("text", "comment.length");
        }

    }
}
