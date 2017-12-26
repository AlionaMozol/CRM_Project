package com.project.crm.services.impl;


import com.project.crm.dao.CommentDao;
import com.project.crm.dao.UserDao;
import com.project.crm.model.Comment;
import com.project.crm.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Implementation of {@link CommentService} interface.
 */
@Transactional
@Component
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<Comment> getCommnetByPostId(String id) {
        List<Comment> commentList = new ArrayList<>();

        commentList = commentDao.getCommentsByProductId(id);
        Collections.sort(commentList, new Comparator<Comment>() {
            public int compare(Comment o1, Comment o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        for (Comment comment: commentList) {
            comment.setUserPhoto(userDao.getUserPhotoByUsername(comment.getUsername()));

        }

        return commentList;
    }

    @Override
    public void addComment(Comment comment) {
        commentDao.addComment(comment);
    }
}