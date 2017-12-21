package com.project.crm.repository;


import com.project.crm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by 1 on 28.10.2017.
 */



public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
