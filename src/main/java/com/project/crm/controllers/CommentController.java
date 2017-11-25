package com.project.crm.controllers;


import com.fasterxml.jackson.annotation.JsonView;
import com.project.crm.model.Comment;
import com.project.crm.services.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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
