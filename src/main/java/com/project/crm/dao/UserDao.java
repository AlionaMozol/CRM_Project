package com.project.crm.dao;


import com.project.crm.model.User;
import org.springframework.stereotype.Component;

@Component
public interface  UserDao {

    public void addUser(User user);
    public User getUserById(int id);
    public int getUserIdByEmail(String email);
    public void deleteUser(User user);
    public User findUserById(int id);
    public User findUserByUsername(String username);
}