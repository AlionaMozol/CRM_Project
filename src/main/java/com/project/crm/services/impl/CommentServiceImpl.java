package com.project.crm.services.impl;


import com.project.crm.dao.CommentDao;
import com.project.crm.model.Comment;
import com.project.crm.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Transactional
@Component
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getCommnetByPostId(String id) {
        List<Comment> commentList = new ArrayList<>();
        commentList = commentDao.getCommentsByProductId(id);
        Collections.sort(commentList, new Comparator<Comment>() {
            public int compare(Comment o1, Comment o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });

        return commentList;
    }

    @Override
    public void addComment(Comment comment){
        commentDao.addComment(comment);
    }
}