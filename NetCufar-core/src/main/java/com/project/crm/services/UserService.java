package com.project.crm.services;

import com.project.crm.model.User;

/**
 * Service class for {@link User}
 */
public interface UserService {

    /**
     * Function that adds a user to database with the User role and an encrypted password
     *
     * @param user
     */
    void save(User user);

    /**
     * Function that returns a user without fields that are associated with eav
     *
     * @param username
     * @return {@link User}
     */
    User findByUsername(String username);

    /**
     * Function that adds a user to the eav model by its id in the security table
     *
     * @param securityId
     * @return {@link User}
     */
    User eavUserRegistration(int securityId);
}
