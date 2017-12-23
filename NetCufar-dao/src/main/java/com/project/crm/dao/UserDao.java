package com.project.crm.dao;


import com.project.crm.model.User;

import java.util.List;

/**
 * Basic Data Access Object interface.
 * Provide operations with favorite{@link User}.
 */
public interface UserDao {

    void addUser(User user);

    List<User> getAllUsers();

    User getUserById(int id);

    int getUserIdByEmail(String email);

    int getUserIdByTelephone(String telephone);

    void deleteUser(User user);

    User findUserById(int id);

    User findUserByUsername(String username);

    void updateUser(User user);

    void updateStatus(User user);
}