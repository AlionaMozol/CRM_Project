package com.project.crm.dao;

import com.project.crm.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 30.10.2017.
 */
public class UserDaoImpl implements UserDao{
    public static final String SELECT_ALL_USERS = "SELECT * FROM spring_security_app.users";
    public static final String SELECT_BY_USERNAME = "SELECT * FROM spring_security_app.users WHERE username = ?";
    public static final String SELECT_BY_ID = "SELECT * FROM spring_security_app.users WHERE id = ?";

    public static final String INSERT_USER = "INSERT INTO spring_security_app.users VALUES (?,?,?);";
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void addUser(User user) {
        Connection connection=null;
        try {
            connection = DriverManager.getConnection("${jdbc.url}", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            try (PreparedStatement stm = connection.prepareStatement(INSERT_USER)) {
                stm.setLong(1, user.getId());
                stm.setString(2, user.getUsername());
                stm.setString(3, bCryptPasswordEncoder.encode(user.getPassword()));
                stm.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public User getUserById(Long userId) {
        Connection connection=null;
        try {
            connection = DriverManager.getConnection("${jdbc.url}", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = new User();
        try {
            try (PreparedStatement stm = connection.prepareStatement(SELECT_BY_ID)) {
                stm.setLong(1, userId);
                ResultSet rs = stm.executeQuery();
                if(rs.next()) {
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        Connection connection=null;
        try {
            connection = DriverManager.getConnection("${jdbc.url}", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        User user = new User();
        try {
            try (PreparedStatement stm = connection.prepareStatement(SELECT_BY_USERNAME)) {
                stm.setString(1, username);
                ResultSet rs = stm.executeQuery();
                if(rs.next()){
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        Connection connection=null;
        try {
            connection = DriverManager.getConnection("${jdbc.url}", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<User> list = new ArrayList<User>();
        try {
            try (PreparedStatement stm = connection.prepareStatement(SELECT_ALL_USERS)) {
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setUsername(rs.getString("username"));
                    list.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean isExist(User userNew) {
        List<User>usersList = this.getAllUsers();
        for(int i=0; i<usersList.size(); i++){
            if(userNew.getUsername().equals(usersList.get(i).getUsername())){
                return true;
            }
        }
        return false;
    }
}
