package com.project.crm.services.impl;


import com.project.crm.dao.CommentDao;
import com.project.crm.model.Comment;
import com.project.crm.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getCommnetByPostId(String id) {
        return commentDao.getCommentsByProductId(id);
    }

    @Override
    public void addComment(Comment comment){
        commentDao.addComment(comment);
    }
}