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

    @Column(name = "password")
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
    private List<Product> userProductList;
    @Transient
    private List<Product> adminProductList;
    @Transient
    private List<Product> favoriteProductList;
    @Transient
    private List<Product> blockedUserList;

    @Transient
    private String fio;
    @Transient
    private String telephone;
    @Transient
    private String dateOfBirth;
    @Transient
    private String sex;
    @Transient
    private String city;
    @Transient
    private String email;
    @Transient
    private String status;
    @Transient
    private String AccountCreationDate;
    @Transient
    private String rating;

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Transient
    private String photo;

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAccountCreationDate() {
        return AccountCreationDate;
    }

    public void setAccountCreationDate(String AccountCreationDate) {
        this.AccountCreationDate = AccountCreationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

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