package com.project.crm.controllers;



import com.project.crm.model.Comment;
import com.project.crm.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CommentController {


    @Autowired
    CommentService commentService;



    @RequestMapping(value = "/getcomments")
    public @ResponseBody List showComments(@RequestParam String id){
        List<Comment> commentList = null;
        commentList = commentService.getCommnetByPostId(id);

       return commentList;
    }

    @Secured(value={"ROLE_ADMIN", "ROLE_USER"})
    @RequestMapping(value = "/addComment")
    public void addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
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
