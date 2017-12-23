package com.project.crm.dao;

import com.project.crm.model.Comment;

import java.util.List;

/**
 * Basic Data Access Object interface.
 * Provide operations with {@link Comment}.
 */
public interface CommentDao {

    /**
     * Get all comments by current product.
     *
     * @param id
     * @return list of {@link Comment}.
     */
    List<Comment> getCommentsByProductId(String id);

    void addComment(Comment comment);

    Comment getCommentById(String id);


}
