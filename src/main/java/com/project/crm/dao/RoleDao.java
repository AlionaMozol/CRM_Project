package com.project.crm.dao;

import com.project.crm.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Long> {
}
