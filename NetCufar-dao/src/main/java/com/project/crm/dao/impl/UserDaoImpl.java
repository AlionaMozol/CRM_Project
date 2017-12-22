package com.project.crm.dao.impl;

import com.project.crm.dao.DAO;
import com.project.crm.dao.UserDao;
import com.project.crm.model.User;
import com.project.crm.services.SqlService;
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
        attribute_type.add("ACC_DATE_TIME");
        attribute_type.add("RATING");
        attribute_type.add("STATUS");
        attribute_type.add("PHOTO");
        userInformation.add(Integer.toString(user.getId()));
        userInformation.add(user.getFio());
        userInformation.add(user.getSex());
        userInformation.add(user.getTelephone());
        userInformation.add(user.getDateOfBirth());
        userInformation.add(user.getEmail());
        userInformation.add(user.getCity());
        userInformation.add(user.getAccountCreationDate());
        userInformation.add(user.getRating());
        userInformation.add(user.getStatus());
        userInformation.add(user.getPhoto());

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
            for(int i= 0; i<attribute_type.size(); i++){
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
    public List<User> getAllUsers() {
        Connection connection = poolInst.getConnection();
        User user = new User();;
        List<User>userList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM user_roles WHERE role_id=1");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                user=getUserById(rs.getInt(1));
                userList.add(user);
            }
            statement.close();
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        poolInst.footConnection(connection);
        return userList;
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
            statement.setString(2,"SECURITY_ID");
            statement.setInt(3,id);
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
                    case "ACC_DATE_TIME":
                        user.setAccountCreationDate(resultSet.getString("value"));
                        break;
                    case "RATING":
                        user.setRating(resultSet.getString("value"));
                        break;
                    case "STATUS":
                        user.setStatus(resultSet.getString("value"));
                        break;
                    case "PHOTO":
                        user.setPhoto(resultSet.getString("value"));
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
    public int getUserIdByEmail(String email) {
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
            statement.setString(2,"MAIL");
            statement.setString(3,email);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                objectId=resultSet.getString(1);
            }

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_SELECT_USER_ATTRIBUTES));
            statement.setString(1,objectId);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                if (resultSet.getString("attribute").equals("SECURITY_ID")){
                    user.setId(resultSet.getInt("value"));
                    statement.close();
                    resultSet.close();
                    poolInst.footConnection(connection);
                    return user.getId();
                }
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolInst.footConnection(connection);
        return -1;
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
    public int getUserIdByTelephone(String telephone) {
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
            statement.setString(2,"TELEPHONE");
            statement.setString(3,telephone);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                objectId=resultSet.getString(1);
            }

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_SELECT_USER_ATTRIBUTES));
            statement.setString(1,objectId);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                if (resultSet.getString("attribute").equals("SECURITY_ID")){
                    user.setId(resultSet.getInt("value"));
                    statement.close();
                    resultSet.close();
                    poolInst.footConnection(connection);
                    System.out.println(user.getId());
                    return user.getId();
                }
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolInst.footConnection(connection);
        return -1;
    }


    @Transactional(propagation = Propagation.MANDATORY,
            rollbackFor=Exception.class)
    @Override
    public User findUserById(int id) {
        Connection connection = poolInst.getConnection();
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_USER_BY_ID));
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(id);
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

    @Override
    public User findUserByUsername(String username) {
        Connection connection = poolInst.getConnection();
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_GET_USER_BY_USERNAME));
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){

                user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(username);
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

    @Override
    public void updateStatus(User user) {
        User oldUser = getUserById(user.getId());
        Connection connection = poolInst.getConnection();
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
            statement.setString(2,"SECURITY_ID");
            statement.setInt(3,user.getId());
            resultSet = statement.executeQuery();

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_UPDATE_PROFILE));

            if (resultSet.next()){
                objectId=resultSet.getString(1);
            }
            if(!oldUser.getStatus().equals(user.getStatus())){
                statement.setString(1,user.getStatus());
                statement.setString(2,objectId);
                statement.setString(3,"e7fed6d6-d465-11e7-bdec-94de807a9669");
                statement.execute();
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolInst.footConnection(connection);


    }

    @Override
    public void updateUser(User user) {
        User oldUser = getUserById(user.getId());
        Connection connection = poolInst.getConnection();
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
            statement.setString(2,"SECURITY_ID");
            statement.setInt(3,user.getId());
            resultSet = statement.executeQuery();

            statement = connection.prepareStatement(sql.
                    getProperty(SqlService.SQL_UPDATE_PROFILE));

            if (resultSet.next()){
                objectId=resultSet.getString(1);
            }
            if (!oldUser.getFio().equals(user.getFio())){
                statement.setString(1,user.getFio());
                statement.setString(2,objectId);
                statement.setString(3,"fd93b41b-cbcf-11e7-97a3-94de807a9669");
                statement.execute();
            }

            if(!oldUser.getTelephone().equals(user.getTelephone())){
                statement.setString(1,user.getTelephone());
                statement.setString(2,objectId);
                statement.setString(3,"fd9c98fa-cbcf-11e7-97a3-94de807a9669");
                statement.execute();

            }
            if(!oldUser.getDateOfBirth().equals(user.getDateOfBirth())){
                statement.setString(1,user.getDateOfBirth());
                statement.setString(2,objectId);
                statement.setString(3,"fda0bbe9-cbcf-11e7-97a3-94de807a9669");
                statement.execute();
            }
            if(!oldUser.getCity().equals(user.getCity())){
                statement.setString(1,user.getCity());
                statement.setString(2,objectId);
                statement.setString(3,"fdad14d4-cbcf-11e7-97a3-94de807a9669");
                statement.execute();
            }
            if(!oldUser.getEmail().equals(user.getEmail())){
                statement.setString(1,user.getEmail());
                statement.setString(2,objectId);
                statement.setString(3,"fda621dc-cbcf-11e7-97a3-94de807a9669");
                statement.execute();

            }
            if(!oldUser.getSex().equals(user.getSex())){
                statement.setString(1,user.getSex());
                statement.setString(2,objectId);
                statement.setString(3,"fd97346f-cbcf-11e7-97a3-94de807a9669");
                statement.execute();
            }
            statement.setString(1,user.getPhoto());
            statement.setString(2,objectId);
            statement.setString(3,"cff83967-d465-11e7-bdec-94de807a9669");
            statement.execute();
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolInst.footConnection(connection);
    }


    public static void main(String [] args) throws SQLException {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.findUserByUsername("123456789").getId());
        List <User> userList = new ArrayList<>();
        userList=userDao.getAllUsers();
        for(int i=0 ; i<userList.size(); i++){
            System.out.println(userList.get(i).getId());
        }
/*
        User user1 = new User();
        user1.setFio("user1");
        user1.setSex("M");
        user1.setCity("minsk");
        user1.setStatus("2");
        user1.setAccountCreationDate("25.12.2008");
        user1.setRating("1");
        user1.setId(111);
        user1.setTelephone("80298285183");
        user1.setDateOfBirth("11.11.1997");
        user1.setEmail("ankabrest@mail.ru");
        userDao.updateUser(user1);*/
        //System.out.println(userDao.getUserById(11).getUsername());


        //userDao.deleteRegisteredUserDao(registeredUser);
        //user=userDao.getUserById(1452);
        //System.out.println(user.getStatus()+ " "+ user.getAccountCreationDate());
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



    }


//    public static void main(String[] args) throws ClassNotFoundException {
//        long l = 1;
//        UserDaoImpl d = new UserDaoImpl();
//        User user = d.getUserById(1);
//        System.out.println(user.getUsername());
//
//    }
}