package com.project.crm.repository;


import com.project.crm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * A function that returns a user by
     * username using the spring data
     */
    User findByUsername(String username);
}
