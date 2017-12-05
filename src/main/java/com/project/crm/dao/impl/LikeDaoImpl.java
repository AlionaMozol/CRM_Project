package com.project.crm.dao.impl;

import com.project.crm.dao.DAO;
import com.project.crm.dao.LikeDao;
import com.project.crm.model.Product;
import com.project.crm.model.User;
import com.project.crm.services.SqlService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LikeDaoImpl extends DAO implements LikeDao {

    private static ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor = Exception.class)
    public void addProductToFavourites(Product product, User currentUser) {
        Connection connection = poolInst.getConnection();
        String likeId = UUID.randomUUID().toString();
        String likeObjectTypeId;
        try {
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            preparedStatement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_LIKE_OBJECT_TYPE_ID));
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            likeObjectTypeId = resultSet.getString(1);

            preparedStatement = connection.prepareStatement(sql.getProperty(SqlService.SQL_INSERT_INTO_OBJECT));
            preparedStatement.setString(1, likeId);
            preparedStatement.setString(2, likeObjectTypeId);
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement(sql.getProperty(SqlService.SQL_INSERT_LIKE_INTO_VALUES));
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, likeId);
            preparedStatement.setString(3, Integer.toString(currentUser.getId()));
            preparedStatement.setString(4, UUID.randomUUID().toString());
            preparedStatement.setString(5, likeId);
            preparedStatement.setString(6, product.getId());
            preparedStatement.execute();




            /*
            preparedStatement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_LIKE_ATTR_ID));
            resultSet = preparedStatement.executeQuery();
            preparedStatement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_ADD_OBJECT));


            while (resultSet.next()) {
                preparedStatement.setString(1, UUID.randomUUID().toString());
                preparedStatement.setString(2, likeId);
                preparedStatement.setString(3, resultSet.getString(1));
                switch (resultSet.getString(1)) {
                    case "fdc02d2a-cbcf-11e7-97a3-94de807a9669": // user
                        preparedStatement.setString(4, currentUser.getUsername());
                        break;
                    case "fdc55704-cbcf-11e7-97a3-94de807a9669": // product
                        preparedStatement.setString(4, product.getId());
                        break;
                    default:
                        System.out.println("chet ne to");
                }
                preparedStatement.execute();

            }*/

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    public void removeProductFromFavourites(Product product) {

    }

    @Override
    public Product getProductByLikeId(String likeId) {
        Connection connection = poolInst.getConnection();
        Product product = new Product();

        try {
            PreparedStatement statement;
            ResultSet resultSet;
            statement = connection.prepareStatement(sql.getProperty(SqlService.SQL_GET_LIKE_ATTR_VALS_AND_ATTR_IDS));
            statement.setString(1, likeId);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                if(resultSet.getString(1).equals("PRODUCT")) {
                    product = productDao.getProductById(resultSet.getString(2));
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

        return product;
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    public List<Product> getFavouriteProductsByUsername(String userName) {  /////////////  name/id
        Connection connection = poolInst.getConnection();
        List<Product> favouriteProductList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_LIKES_BY_USER_ID)); //////// name/id
            statement.setString(1, userName);  ////////// name/id
            ResultSet likesIds = statement.executeQuery();
            while (likesIds.next()) {
                favouriteProductList.add(getProductByLikeId(likesIds.getString(1)));
            }
            likesIds.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }

        return favouriteProductList;
    }


    public static void main(String[] args) {
        LikeDaoImpl likeDao = new LikeDaoImpl();
        UserDaoImpl userDao = new UserDaoImpl();

        Product product = new Product();

        Product p = new Product();
        Map<String, String> att = new HashMap<>();
        p.setCost("10");
        p.setOwner("IvanStariy");
        p.setCategory("MEN_SHOES");
        p.setSuperCategory("Fashion");
        p.setAttributesAndValues(att);

        productDao.addProduct(p);

        User user = new User();
        user.setId(1452);
        user.setDateOfBirth("11.11.11");
        user.setCity("brest");
        user.setEmail("anna@mail.ru");
        user.setTelephone("8285183");
        user.setSex("women");
        user.setFio("anna tochilo");
        user.setRating("1");
        user.setStatus("1");
        user.setAccountCreationDate("1");

        userDao.addUser(user);

        likeDao.addProductToFavourites(p, user);

        List<Product> list = likeDao.getFavouriteProductsByUsername(user.getUsername());

        for (Product prod: list) {
            System.out.println(product.getCategory());
        }

    }

/*
    public String getUserId(String username) {
        Connection connection = poolInst.getConnection();
        String userId = null;
        try {
            PreparedStatement preparedStatement;
            ResultSet resultSet;

            preparedStatement = connection.prepareStatement(sql.getProperty(SqlService.SQL_GET_USER_ID_BY_USERNAME));
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            userId = resultSet.getString(1);

            preparedStatement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            poolInst.footConnection(connection);
        }
        return userId;
    } */

}