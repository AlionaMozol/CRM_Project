package com.project.crm.dao;


import com.project.crm.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface  UserDao {

    public void addUser(User user);
    public List <User> getAllUsers();
    public User getUserById(int id);
    public int getUserIdByEmail(String email);
    public int getUserIdByTelephone(String telephone);
    public void deleteUser(User user);
    public User findUserById(int id);
    public User findUserByUsername(String username);
    public void updateUser(User user);
}