package com.project.crm.controllers;



import com.project.crm.model.Comment;
import com.project.crm.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
