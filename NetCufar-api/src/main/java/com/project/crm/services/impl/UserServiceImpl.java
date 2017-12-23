package com.project.crm.services.impl;

import com.project.crm.model.Role;
import com.project.crm.model.User;
import com.project.crm.repository.RoleRepository;
import com.project.crm.repository.UserRepository;
import com.project.crm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of {@link UserService} interface.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        //Encoding password
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = new HashSet<>();
        //Add User role
        roles.add(roleRepository.getOne(1L));
        user.setRoles(roles);
        //Save user
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User eavUserRegistration(int securityId) {
        User user = new User();
        //userForm.getId()
        user.setId(securityId);
        user.setCity("");
        user.setTelephone("");
        user.setDateOfBirth("");
        user.setEmail("");
        user.setSex("");
        user.setFio("");
        user.setStatus("UNBLOCKED");
        user.setRating("0");
        user.setPhoto("-1");
        Date date = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy.MM.dd");
        user.setAccountCreationDate(formatForDateNow.format(date));
        return user;
    }
}
