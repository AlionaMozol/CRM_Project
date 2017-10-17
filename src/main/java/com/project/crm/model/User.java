package com.project.crm.model;

import org.springframework.stereotype.Component;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Component
public class User {

    @NotNull
    private String email;

    @NotNull
    private String password;

    public String getName() {
        return email;
    }

    public void setName(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}