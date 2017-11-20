package com.project.crm.dao.impl;

import com.project.crm.dao.CommentDao;
import com.project.crm.dao.DAO;
import com.project.crm.model.Comment;
import com.project.crm.model.Product;
import com.project.crm.services.SqlService;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@Component
public class CommentDaoImpl extends DAO implements CommentDao {

    @Override
    public List<Comment> getCommentsByProductId(String id) {
        Connection connection = poolInst.getConnection();
        List<Comment> commentList = new ArrayList<>();
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_COMMENT_BY_POST_ID));
            statement.setString(1, id);
            ResultSet commentIds = statement.executeQuery();
            while (commentIds.next()) {
                    commentList.add(getCommentById(commentIds.getString(1)));
            }
            commentIds.close();
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tryToRollbackConnection(connection);
        }
        finally {
            tryToSetAutoCommitTrueForConnection(connection);
            poolInst.footConnection(connection);
        }
        return commentList;

    }

    @Override
    public void addComment(Comment comment) {
        Connection connection = poolInst.getConnection();
        String commentId = UUID.randomUUID().toString();
        String commentObjectTypeId = "6bc34fa0-cbce-11e7-97a3-94de807a9669";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            preparedStatement = connection.prepareStatement(sql.getProperty(SqlService.SQL_INSERT_INTO_OBJECT));
            preparedStatement.setString(1, commentId);
            preparedStatement.setString(2, commentObjectTypeId);
            preparedStatement.execute();
            preparedStatement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_COMMENT_ATTR_ID));
            resultSet = preparedStatement.executeQuery();
            preparedStatement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));
            while (resultSet.next()) {
                preparedStatement.setString(1, UUID.randomUUID().toString());
                preparedStatement.setString(2, commentId);
                preparedStatement.setString(3, resultSet.getString(1));
                switch (resultSet.getString(1)) {
                    case "fdbc8ce6-cbcf-11e7-97a3-94de807a9669":
                        preparedStatement.setString(4, comment.getPostId());
                        break;
                    case "fdb4da4b-cbcf-11e7-97a3-94de807a9669":
                        preparedStatement.setString(4, comment.getUsername());
                        break;
                    case "fdb0ebf0-cbcf-11e7-97a3-94de807a9669":
                        preparedStatement.setString(4, comment.getText());
                        break;
                    case "fdb85110-cbcf-11e7-97a3-94de807a9669":
                        preparedStatement.setString(4, "it");
                        break;
                    default:
                        System.out.println("chet ne to");
                }
                preparedStatement.execute();

            }
            preparedStatement.close();
            resultSet.close();
            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
            tryToRollbackConnection(connection);

        } finally {
            tryToSetAutoCommitTrueForConnection(connection);
            poolInst.footConnection(connection);
        }

    }

    @Override
    public Comment getCommentById(String id){

        Connection connection = poolInst.getConnection();
        Comment currentComment = new Comment();
        currentComment.setId(id);
        try {
            connection.setAutoCommit(false);
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
                }
            }

            resultSet.close();
            statement.close();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            tryToRollbackConnection(connection);
        }
        finally {
            tryToSetAutoCommitTrueForConnection(connection);
            poolInst.footConnection(connection);
        }
        return currentComment;

    }



    void tryToRollbackConnection(Connection connection) {
        try {
            connection.rollback();
            System.err.print("Transaction is being rolled back!");
        } catch (SQLException e) {
            System.err.print("Transaction is NOT being rolled back!");
            e.printStackTrace();
        }
    }

    void tryToSetAutoCommitTrueForConnection(Connection connection) {
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
