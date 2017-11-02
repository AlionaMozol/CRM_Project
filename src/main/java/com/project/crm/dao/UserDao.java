package com.project.crm.dao;


import com.project.crm.model.User;
import java.util.List;

public interface  UserDao {

    public void addUser(User user);
    public User getUserById(int id);
    public User findByUsername(String username);
    public List<User> getAllUsers();
    public boolean isExist(User user);
}