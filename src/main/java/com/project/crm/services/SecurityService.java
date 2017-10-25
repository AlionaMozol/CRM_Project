package com.project.crm.services;

/**
 * Service for Security.
 *
 * @author Ivan Tkachev
 * @version 1.0
 */

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
