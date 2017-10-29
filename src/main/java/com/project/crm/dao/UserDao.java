package com.project.crm.dao;


import com.project.crm.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public interface  UserDao {

    public void addUser(User user);
    public User getUserById(Long id);
    public User getUserByUsername(String username);
    public List<User> getAllUsers();
    public boolean isExist(User user);


}