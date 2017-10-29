package com.project.crm.controllers;

import com.project.crm.model.User;
import java.util.List;

/**
 * Created by 1 on 27.10.2017.
 */
public interface  UserControllerInterfase {

    public void addUser(User user);
    public User getUserById(Long id);
    public User getUserByUsername(String username);
    public List<User> getAllUsers();
    public boolean isExist(User user);


}