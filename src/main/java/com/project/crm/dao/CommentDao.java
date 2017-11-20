package com.project.crm.dao;

import com.project.crm.model.Comment;
import com.project.crm.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentDao {

    List<Comment> getCommentsByProductId(String id);
    void addComment(Comment comment);
    Comment getCommentById(String id);


}
