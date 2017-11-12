package com.project.crm.dao;

import com.project.crm.model.RegisteredUser;

/**
 * Created by 1 on 09.11.2017.
 */
public interface RegisteredUserDao {

    public void addRegisteredUserDao(RegisteredUser registeredUser);
    public RegisteredUser getRegisteredUserById(int id);
}
