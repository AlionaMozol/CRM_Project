package com.project.crm.services;


import com.project.crm.model.Comment;

import java.util.List;

/**
 * Service class for {@link Comment} of {@link com.project.crm.model.User}
 */
public interface CommentService {

    List<Comment> getCommnetByPostId(String id);

    void addComment(Comment comment);
}
