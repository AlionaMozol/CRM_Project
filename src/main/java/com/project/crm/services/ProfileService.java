package com.project.crm.services;


import com.project.crm.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 1 on 15.11.2017.
 */

@Service
public interface ProfileService {


    User getUserByID(int id);
    void addUser(User user);
    void updateUser(User user);
}
