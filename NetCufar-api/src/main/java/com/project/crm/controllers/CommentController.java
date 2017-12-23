package com.project.crm.controllers;


import com.project.crm.model.Comment;
import com.project.crm.services.CommentService;
import com.project.crm.validator.CommentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Rest Controller for comment of {@link com.project.crm.model.User}
 */
@RestController
public class CommentController {


    @Autowired
    CommentService commentService;

    @Autowired
    CommentValidator commentValidator;

    @RequestMapping(value = "/getcomments")
    public @ResponseBody
    List showComments(@RequestParam String id) {
        List<Comment> commentList = null;
        commentList = commentService.getCommnetByPostId(id);

        return commentList;
    }

    @Secured(value = {"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/addComment")
    public void addComment(@RequestBody Comment comment, BindingResult bindingResult) {
        commentValidator.validate(comment, bindingResult);
        if (!bindingResult.hasErrors()) {
            commentService.addComment(comment);
        }

    }

    /*@ModelAttribute("comment")
    public Comment newComment(){
        Comment comment = new Comment();
        comment.setText("TEST");
        comment.setId(UUID.randomUUID().toString());
        comment.setUsername("");

        return comment;
    }*/

}
