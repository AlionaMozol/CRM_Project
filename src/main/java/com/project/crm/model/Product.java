package com.project.crm.model;

import java.awt.*;
import java.util.Date;
import java.util.List;

public class Product {

    private int id;
    private String category;
    private String title;
    private String description;
    private int cost;
    private Image photo;
    private Date publicationDate;
    private String phone;
    private List<String> commentList;


    /**
     * Default constructor of product
     */
    public Product() {}


    /**Equals of objects
     * @param o object
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product that = (Product) o;

        if (id != that.id) return false;
        if (cost != that.cost) return false;
        if (!category.equals(that.category)) return false;
        if (!title.equals(that.title)) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (photo != null ? !photo.equals(that.photo) : that.photo != null) return false;
        if (!publicationDate.equals(that.publicationDate)) return false;
        if (!phone.equals(that.phone)) return false;
        return commentList != null ? commentList.equals(that.commentList) : that.commentList == null;
    }

    /**Information about object
     * @return string value
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", photo=" + photo +
                ", publicationDate=" + publicationDate +
                ", phone='" + phone + '\'' +
                ", commentsList=" + commentList +
                '}';
    }

    /**HashCode of object
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + category.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + cost;
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + publicationDate.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + (commentList != null ? commentList.hashCode() : 0);
        return result;
    }


    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getCategory() { return category; }

    public void setCategory(String category) { this.category = category; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public int getCost() { return cost; }

    public void setCost(int cost) { this.cost = cost; }

    public Image getPhoto() { return photo; }

    public void setPhoto(Image photo) { this.photo = photo; }

    public Date getPublicationDate() { return publicationDate; }

    public void setPublicationDate(Date publicationDate) { this.publicationDate = publicationDate; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public List<String> getCommentsList() { return commentList; }

    public void setCommentsList(List<String> commentsList) { this.commentList = commentsList; }
}
