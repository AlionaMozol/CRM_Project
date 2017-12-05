package com.project.crm.services;

import com.project.crm.model.User;

/**
 * Service class for {@link com.project.crm.model.User}
 *
 * @author Ivan Tkachev
 * @version 1.0
 */

public interface UserService {

    void save(User user);

    User findByUsername(String username);

    User eavUserRegistration(int securityId);
}
