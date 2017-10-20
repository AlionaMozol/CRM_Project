package com.project.crm.model;

import com.project.crm.model.enums.Role;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class User {

    private int id;
    private Role role;
    private String name;
    private String email;
    private String password;
    private List<Product> userProductList;
    private List<Product> adminProductList;
    private List<Product> favoriteProductList;
    private List<Product> blockedUserList;

    /**
     * Default constructor of product
     */
    public User() {}

    /**Information about object
     * @return string value
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", role=" + role +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userProductList=" + userProductList +
                ", adminProductList=" + adminProductList +
                ", favoriteProductList=" + favoriteProductList +
                ", blockedUserList=" + blockedUserList +
                '}';
    }

    /**Equals of objects
     * @param o object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (role != user.role) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (userProductList != null ? !userProductList.equals(user.userProductList) : user.userProductList != null)
            return false;
        if (adminProductList != null ? !adminProductList.equals(user.adminProductList) : user.adminProductList != null)
            return false;
        if (favoriteProductList != null ? !favoriteProductList.equals(user.favoriteProductList) : user.favoriteProductList != null)
            return false;
        return blockedUserList != null ? blockedUserList.equals(user.blockedUserList) : user.blockedUserList == null;
    }

    /**HashCode of object
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + role.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userProductList != null ? userProductList.hashCode() : 0);
        result = 31 * result + (adminProductList != null ? adminProductList.hashCode() : 0);
        result = 31 * result + (favoriteProductList != null ? favoriteProductList.hashCode() : 0);
        result = 31 * result + (blockedUserList != null ? blockedUserList.hashCode() : 0);
        return result;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Role getRole() { return role; }

    public void setRole(Role role) { this.role = role; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<Product> getUserProductList() { return userProductList; }

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