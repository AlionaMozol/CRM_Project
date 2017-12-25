package com.project.crm.dao.impl;

import com.project.crm.dao.CommentDao;
import com.project.crm.dao.DAO;
import com.project.crm.model.Comment;
import com.project.crm.services.SqlService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class CommentDaoImpl extends DAO implements CommentDao {

    @Override
    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    public List<Comment> getCommentsByProductId(String id) {
        Connection connection = poolInst.getConnection();
        List<Comment> commentList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_OBJECT_ID_BY_ATTR_ID_AND_VALUE));
            statement.setString(1, commentAttrID.getProperty("PRODUCT_REC"));
            statement.setString(2,id);
            ResultSet commentIds = statement.executeQuery();
            while (commentIds.next()) {
                    commentList.add(getCommentById(commentIds.getString(1)));
            }
            commentIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }
        return commentList;

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    public void addComment(Comment comment) {
        Date date = new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat();
        Connection connection = poolInst.getConnection();
        String commentId = UUID.randomUUID().toString();
        try {
            PreparedStatement preparedStatement;
//            ResultSet resultSet;
            preparedStatement = connection.prepareStatement(sql.getProperty(SqlService.SQL_INSERT_INTO_OBJECT));
            preparedStatement.setString(1, commentId);
            preparedStatement.setString(2, commentAttrID.getProperty("OBJECT_TYPE_ID"));
            preparedStatement.execute();
//            preparedStatement = connection.prepareStatement(sql.
//                    getProperty(SqlService.SQL_GET_OBJECT_ATTR_ID));
//            preparedStatement.setString(1,commentAttrID.getProperty("OBJECT_TYPE_ID"));
//            resultSet = preparedStatement.executeQuery();
            preparedStatement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_INSERT_COMMENT_INTO_VALUES));

            preparedStatement.setString(1,  UUID.randomUUID().toString());
            preparedStatement.setString(2,  commentId);
            preparedStatement.setString(3,  commentAttrID.getProperty("PRODUCT_REC"));
            preparedStatement.setString(4,  comment.getPostId());
            preparedStatement.setString(5,  UUID.randomUUID().toString());
            preparedStatement.setString(6,  commentId);
            preparedStatement.setString(7,  commentAttrID.getProperty("USER_MAKER"));
            preparedStatement.setString(8,  comment.getUsername());
            preparedStatement.setString(9,  UUID.randomUUID().toString());
            preparedStatement.setString(10, commentId);
            preparedStatement.setString(11, commentAttrID.getProperty("TEXT_"));
            preparedStatement.setString(12, comment.getText());
            preparedStatement.setString(13, UUID.randomUUID().toString());
            preparedStatement.setString(14, commentId);
            preparedStatement.setString(15, commentAttrID.getProperty("COMMENT_DATE_TIME"));
            preparedStatement.setString(16, dateFormat.format(date));
            preparedStatement.execute();
//            while (resultSet.next()) {
//                preparedStatement.setString(1, UUID.randomUUID().toString());
//                preparedStatement.setString(2, commentId);
//                preparedStatement.setString(3, resultSet.getString(1));
//                switch (resultSet.getString(1)) {
//                    case "fdbc8ce6-cbcf-11e7-97a3-94de807a9669":
//                        preparedStatement.setString(4, comment.getPostId());
//                        break;
//                    case "fdb4da4b-cbcf-11e7-97a3-94de807a9669":
//                        preparedStatement.setString(4, comment.getUsername());
//                        break;
//                    case "fdb0ebf0-cbcf-11e7-97a3-94de807a9669":
//                        preparedStatement.setString(4, comment.getText());
//                        break;
//                    case "fdb85110-cbcf-11e7-97a3-94de807a9669":
//                        preparedStatement.setString(4, "it");
//                        break;
//                    case "2c29c2e5-d466-11e7-bdec-94de807a9669":
//                        preparedStatement.setString(4, dateFormat.format(date));
//                        break;
//                    default:
//                        System.out.println("chet ne to");
//                }
//                preparedStatement.execute();
//
//            }
            preparedStatement.close();
//            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            poolInst.footConnection(connection);
        }

    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    public Comment getCommentById(String id){

        Connection connection = poolInst.getConnection();
        Comment currentComment = new Comment();
        currentComment.setId(id);
        try {
            PreparedStatement statement;
            ResultSet resultSet;
            Map<String, String> attributesAndValues = new HashMap<>();

            statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_PRODUCT_ATTR_VALS_AND_ATTR_IDS));
            statement.setString(1, id);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                if(resultSet.getString(1).equals("PRODUCT_REC")) {
                    currentComment.setPostId(resultSet.getString(2));
                } else if(resultSet.getString(1).equals("USER_MAKER")) {
                    currentComment.setUsername(resultSet.getString(2));
                } else if (resultSet.getString(1).equals("TEXT_")){
                    currentComment.setText(resultSet.getString(2));
                }else if (resultSet.getString(1).equals("COMMENT_DATE_TIME")){
                    currentComment.setDate(resultSet.getString(2));
                }
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }
        return currentComment;
    }}




