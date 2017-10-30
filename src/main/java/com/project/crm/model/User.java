package com.project.crm.model;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Simple JavaBean domain object that represents a User.
 *
 * @author Ivan Tkachev
 * @version 1.0
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "username")
    private String username;

    @Column (name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    //В данной таблице (для меппинга) лежат user_id и role_id
    //Т.о. получаем быстрый доступ к ролям данного пользователя
    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    @Transient
    private String email;
    @Transient
    private List<Product> userProductList;
    @Transient
    private List<Product> adminProductList;
    @Transient
    private List<Product> favoriteProductList;
    @Transient
    private List<Product> blockedUserList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Product> getUserProductList() {
        return userProductList;
    }

    public void setUserProductList(List<Product> userProductList) {
        this.userProductList = userProductList;
    }

    public List<Product> getAdminProductList() {
        return adminProductList;
    }

    public void setAdminProductList(List<Product> adminProductList) {
        this.adminProductList = adminProductList;
    }

    public List<Product> getFavoriteProductList() {
        return favoriteProductList;
    }

    public void setFavoriteProductList(List<Product> favoriteProductList) {
        this.favoriteProductList = favoriteProductList;
    }



    public List<Product> getBlockedUserList() {
        return blockedUserList;
    }

    public void setBlockedUserList(List<Product> blockedUserList) {
        this.blockedUserList = blockedUserList;
    }
}