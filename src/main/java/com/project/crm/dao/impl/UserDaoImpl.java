package com.project.crm.dao.impl;

import com.project.crm.dao.DAO;
import com.project.crm.dao.UserDao;
import com.project.crm.model.User;
import com.project.crm.services.SqlService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by 1 on 30.10.2017.
 */
@Component
public class UserDaoImpl extends DAO implements UserDao {

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public void addUser(User user) {
        ArrayList<String> attribute_type = new ArrayList<String>();
        ArrayList<String> userInformation = new ArrayList<String>();
        attribute_type.add("SECURITY_ID");
        attribute_type.add("FULL_NAME");
        attribute_type.add("USER_GENDER");
        attribute_type.add("TELEPHONE");
        attribute_type.add("BIRTHDAY");
        attribute_type.add("MAIL");
        attribute_type.add("USER_LOCATION");
        userInformation.add(Integer.toString(user.getId()));
        userInformation.add(user.getFio());
        userInformation.add(user.getSex());
        userInformation.add(user.getTelephone());
        userInformation.add(user.getDateOfBirth());
        userInformation.add(user.getEmail());
        userInformation.add(user.getCity());

        String objectTypeId="";
        Connection connection = poolInst.getConnection();
        try {
            PreparedStatement result_statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_INSERT_VALUE));
            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_SELECT_FROM_OBJECT_TYPE_BY_VALUE));
            statement.setString(1,"USER");
            ResultSet resultSet = statement.executeQuery();
            String objectId= UUID.randomUUID().toString();
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_INSERT_OBJECT));
            if(resultSet.next()){
                objectTypeId=resultSet.getString(1);
                statement.setString(1, objectId);
                statement.setString(2, objectTypeId);
            }
            statement.execute();
            int index=1;
            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR));
            statement.setString(1,objectTypeId);
            statement.setString(2,attribute_type.get(0));
            resultSet = statement.executeQuery();
            if(resultSet.next()){
                result_statement.setString(index, UUID.randomUUID().toString());
                result_statement.setString(index+1, objectId);
                result_statement.setString(index+2, resultSet.getString(1));
                result_statement.setInt(index+3, user.getId());
            }
            index+=4;
            for(int i= 1; i<attribute_type.size(); i++){
                statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_SELECT_BY_OBJECT_TYPE_ID_AND_VALUE_FROM_ATTR));
                statement.setString(1,objectTypeId);
                statement.setString(2,attribute_type.get(i));
                resultSet = statement.executeQuery();
                if(resultSet.next()){
                    result_statement.setString(index, UUID.randomUUID().toString());
                    result_statement.setString(index+1, objectId);
                    result_statement.setString(index+2, resultSet.getString(1));
                    result_statement.setString(index+3, userInformation.get(i));
                }
                index+=4;
            }
            result_statement.execute();
            statement.close();
            result_statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(objectTypeId);
            e.printStackTrace();
        }
        poolInst.footConnection(connection);
    }




    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public User getUserById(int id) {
        Connection connection = poolInst.getConnection();
        User user = new User();
        try {

            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_SELECT_FROM_OBJECT_TYPE_BY_VALUE));
            statement.setString(1,"USER");
            ResultSet resultSet = statement.executeQuery();
            String objectTypeId="";
            String objectId="";
            if(resultSet.next()){
                objectTypeId=resultSet.getString(1);
            }

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_SELECT_OBJECT_ID_FROM_VALUES_AND_ATTR));
            statement.setString(1,objectTypeId);
            statement.setInt(2,id);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                objectId=resultSet.getString(1);
            }

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_SELECT_USER_ATTRIBUTES));
            statement.setString(1,objectId);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                switch (resultSet.getString("attribute")){
                    case "FULL_NAME":
                        user.setFio(resultSet.getString("value"));
                        break;
                    case "USER_GENDER":
                        user.setSex(resultSet.getString("value"));
                        break;
                    case "TELEPHONE":
                        user.setTelephone(resultSet.getString("value"));
                        break;
                    case "MAIL":
                        user.setEmail(resultSet.getString("value"));
                        break;
                    case "BIRTHDAY":
                        user.setDateOfBirth(resultSet.getString("value"));
                        break;
                    case "SECURITY_ID":
                        user.setId(resultSet.getInt("value"));
                        break;
                    case "USER_LOCATION":
                        user.setCity(resultSet.getString("value"));
                        break;
                }
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolInst.footConnection(connection);
        return user;
    }


    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)

    @Override
    public void deleteUser(User user) {
        Connection connection = poolInst.getConnection();
        try {

            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_SELECT_OBJECT_ID_BY_VALUE));
            statement.setInt(1,user.getId());
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                statement = connection.prepareStatement(sql.
                        getProperty(SqlService.SQL_DELETE_VALUES));
                statement.setString(1,resultSet.getString(1));
                statement.execute();
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolInst.footConnection(connection);

    }

    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)

    @Override
    public User findByUsername(String username) {
        Connection connection = poolInst.getConnection();
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_USER_FROM_USERNAME));
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        poolInst.footConnection(connection);
        return user;
    }


   /* public static void main(String [] args) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setId(1452);
        user.setDateOfBirth("11.11.11");
        user.setCity("brest");
        user.setEmail("anna@mail.ru");
        user.setTelephone("8285183");
        user.setSex("women");
        user.setFio("anna tochilo");
        userDao.addUser(user);
        //userDao.deleteRegisteredUserDao(registeredUser);
        user=userDao.getUserById(1452);
        System.out.println(user.getFio()+ " "+ user.getTelephone());
        /*List<Category> topCategotiesList = new ArrayList<Category>();
        topCategotiesList=categoryDao.getAllCategories();
        Category category = new Category();
        category.setTitle("Fashion");
        topCategotiesList=categoryDao.getCategoriesByTopCategory(category);
        for (int i=0; i<topCategotiesList.size(); i++){

            System.out.println(topCategotiesList.get(i).getTitle());

        }

        for (int i=0; i<topCategotiesList.size(); i++){
            if (topCategotiesList.get(i).getSupercategory()!=null)
                System.out.println(topCategotiesList.get(i).getTitle()+" "+topCategotiesList.get(i).getSupercategory().getTitle()+ " "+ topCategotiesList.get(i).isTop());
            else{
                System.out.println(topCategotiesList.get(i).getTitle()+topCategotiesList.get(i).isTop());

            }
        }*/



   // }


//    public static void main(String[] args) throws ClassNotFoundException {
//        long l = 1;
//        UserDaoImpl d = new UserDaoImpl();
//        User user = d.getUserById(1);
//        System.out.println(user.getUsername());
//
//    }
}