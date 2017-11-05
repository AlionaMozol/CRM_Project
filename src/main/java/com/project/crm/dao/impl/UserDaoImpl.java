package com.project.crm.dao.impl;

import com.project.crm.dao.DAO;
import com.project.crm.dao.UserDao;
import com.project.crm.model.User;
import com.project.crm.services.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 30.10.2017.
 */
public class UserDaoImpl extends DAO implements UserDao {
    public static final String SELECT_ALL_USERS = "SELECT * FROM spring_security_app.users";

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void addUser(User user) {
        Connection connection = poolInst.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_ADD_USER));

            statement.setString(1, user.getUsername());
            statement.setString(2, bCryptPasswordEncoder.encode(user.getPassword()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolInst.footConnection(connection);
    }



    @Override
    public User getUserById(int id) {
        Connection connection = poolInst.getConnection();
        User user = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_GET_USER_FROM_ID));
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs != null) {
                user = new User();
                while (rs.next()) {
                    user.setId(rs.getInt(1));
                    user.setUsername(rs.getString(2));
                    user.setPassword(rs.getString(3));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        poolInst.footConnection(connection);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        Connection connection = poolInst.getConnection();
        User user = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql.getProperty(SqlService.SQL_GET_USER_FROM_USERNAME));
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setPassword(rs.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        poolInst.footConnection(connection);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Connection connection = poolInst.getConnection();

        List<User> list = new ArrayList<User>();

        try  {
            PreparedStatement stm = connection.prepareStatement(sql.getProperty(SqlService.SELECT_ALL_USERS));
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                list.add(user);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean isExist(User user) {
        Connection connection = poolInst.getConnection();
        try {
            PreparedStatement statement = connection.prepareStatement(sql
                    .getProperty(SqlService.SQL_CHECK_USER));
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return true;
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return false;
    }

//    public static void main(String[] args) throws ClassNotFoundException {
//        long l = 1;
//        UserDaoImpl d = new UserDaoImpl();
//        User user = d.getUserById(1);
//        System.out.println(user.getUsername());
//
//    }
}