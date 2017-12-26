package com.project.crm.services;


import com.project.crm.model.User;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Service class for profile of {@link User}
 */
public interface ProfileService {
    User getUserByID(int id);

    User getUserByUsername(String username);

    void addUser(User user);

    void updateUser(User user);

    void updateUserStatus(User user);

    int getUserIdByEmail(String email);

    int getUserIdByTelephone(String telephone);

    User getUserByHttpServletRequestAndPhoto(HttpServletRequest request, MultipartFile photo);

    List<User> getAllUsers();
}
