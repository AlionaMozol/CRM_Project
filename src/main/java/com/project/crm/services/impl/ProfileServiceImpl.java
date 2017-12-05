package com.project.crm.services.impl;


import com.project.crm.dao.UserDao;
import com.project.crm.model.User;
import com.project.crm.services.ProductService;
import com.project.crm.services.ProfileService;
import com.project.crm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 1 on 15.11.2017.
 */

@Component
public class ProfileServiceImpl implements ProfileService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductService productService;



    @Transactional
    @Override
    public User getUserByID(int id) {
        User user = userDao.getUserById(id);
        //user.setUserProductList(productService.getProductsByUsername(user.getUsername()));
        //user.setUsername(userDao.findUserById(user.getId()).getUsername());
        return user;
    }

    @Transactional
    @Override
    public User getUserByUsername(String username) {
        User user = userDao.getUserById(userDao.findUserByUsername(username).getId());
        user.setUserProductList(productService.getProductsByUsername(user.getUsername()));
        user.setUsername(username);
        return user;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDao.deleteUser(user);
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public int getUserIdByEmail(String email) {
        return userDao.getUserIdByEmail(email);
    }
}
