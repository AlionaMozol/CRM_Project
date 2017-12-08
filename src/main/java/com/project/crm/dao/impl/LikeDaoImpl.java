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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LikeDaoImpl extends DAO implements LikeDao {

    private static ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor = Exception.class)
    public void addProductToFavorites(String productId, String username) {
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
            preparedStatement.setString(3, username);
            preparedStatement.setString(4, UUID.randomUUID().toString());
            preparedStatement.setString(5, likeId);
            preparedStatement.setString(6, productId);
            preparedStatement.execute();

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
    public void removeProductFromFavorites(Product product) {

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
            resultSet.next();
            //while(resultSet.next()) {
            //    if(resultSet.getString(1).equals("PRODUCT")) {
            System.out.println(resultSet.getString(1));
                    product = productDao.getProductById(resultSet.getString(2));
            //    }
            //}
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
    public List<Product> getFavoriteProductsByUsername(String username) {  /////////////  name/id
        Connection connection = poolInst.getConnection();
        List<Product> favouriteProductList = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_LIKES_BY_USERNAME)); //////// name/id
            statement.setString(1, username);  ////////// name/id
            ResultSet likesIds = statement.executeQuery();
            while (likesIds.next()) {
                System.out.println(likesIds.getString(1));
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
/*
        Product p = new Product();
        Map<String, String> att = new HashMap<>();
        p.setCost("10");
        p.setOwner("IvanStariy");
        p.setCategory("MEN_SHOES");
        p.setSuperCategory("Fashion");
        p.setAttributesAndValues(att);
        p.setId("1234567654321");
        p.setProductStatus(ProductStatus.APPROVED);
        p.setTitle("Туфли супер чёрные");
        p.setDescription("dcvbnmnbvcxdcvbnhgfd");
        p.setPhoto("jhn njc");
        p.setPublicationDate("06.12.2017");
        p.setDateOfLastEdit("07.12.2017");

        productDao.addProduct(p);

        System.out.println(p.getTitle());

        User user = new User();
        user.setUsername("USERNAME");
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

        likeDao.addProductToFavorites(p, user);

        System.out.println(p.getTitle());
*/
        List<Product> list = likeDao.getFavoriteProductsByUsername(/*user.getUsername()*/"USERNAME");

      //  System.out.println(p.getTitle());

        for (Product product: list) {
            System.out.println(product);
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