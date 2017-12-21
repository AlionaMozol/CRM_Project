package com.project.crm.services;


import com.project.crm.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {

    List<Comment> getCommnetByPostId(String id);
    void addComment(Comment comment);
}
