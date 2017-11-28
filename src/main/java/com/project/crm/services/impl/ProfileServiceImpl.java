package com.project.crm.services.impl;


import com.project.crm.dao.UserDao;
import com.project.crm.model.User;
import com.project.crm.services.ProfileService;
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

    @Transactional
    @Override
    public User getUserByID(int id) {
        return userDao.getUserById(id);
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
}
