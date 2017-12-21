package com.project.crm.services.impl;


import com.project.crm.dao.UserDao;
import com.project.crm.model.User;
import com.project.crm.services.ProductService;
import com.project.crm.services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.project.crm.services.GoogleDriveAPI.addPohotoToDrive;

/**
 * Created by 1 on 15.11.2017.
 */

@Transactional
@Component
public class ProfileServiceImpl implements ProfileService {


    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductService productService;



    @Override
    public User getUserByID(int id) {
        User user = userDao.getUserById(id);
        user.setUsername(userDao.findUserById(user.getId()).getUsername());
        //user.setUserProductList(productService.getProductsByUsername(user.getUsername()));
        return user;
    }

    @Override
    public User getUserByUsername(String username) {
        int id = userDao.findUserByUsername(username).getId();
        User user = userDao.getUserById(id);
        user.setUsername(username);
        user.setUserProductList(productService.getProductsByUsername(user.getUsername()));
        return user;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) {
        //userDao.deleteUser(user);
        //userDao.addUser(user);

        userDao.updateUser(user);
    }

    @Override
    public User getUserByHttpServletRequestAndPhoto(HttpServletRequest request, MultipartFile photo){
        User user = new User();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        Map<String, String[]> parameterMap = request.getParameterMap();

        user.setUsername(name);
        user=(userDao.findUserByUsername(user.getUsername()));
        System.out.println(name);
        System.out.println(parameterMap.get("fio")[0]);
        System.out.println(parameterMap.get("email")[0]);
        System.out.println(parameterMap.get("city")[0]);
        System.out.println(parameterMap.get("dateOfBirth")[0]);

        user.setFio(parameterMap.get("fio")[0]);
        user.setEmail(parameterMap.get("email")[0]);
        user.setCity(parameterMap.get("city")[0]);
        user.setTelephone(parameterMap.get("telephone")[0]);
        user.setDateOfBirth(parameterMap.get("dateOfBirth")[0]);
        user.setSex(parameterMap.get("sex")[0]);

        if(photo.isEmpty())
            user.setPhoto("-1");
        else
            try {
                user.setPhoto(addPohotoToDrive(photo));
                System.out.println(user.getPhoto());
            } catch (IOException e) {
                e.printStackTrace();
            }

        return user;
    }

    @Override
    public int getUserIdByEmail(String email) {
        return userDao.getUserIdByEmail(email);
    }

    @Override
    public int getUserIdByTelephone(String telephone) {
        return userDao.getUserIdByTelephone(telephone);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}
