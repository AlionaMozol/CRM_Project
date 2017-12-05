package com.project.crm.model;

import com.project.crm.model.enums.Status;

import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Product {

    private String id;
    private Status status;
    private String superCategory;
    private String category;
    private String cost;
    private String owner;
    private Map<String, String> attributesAndValues;
    private String title;
    private String description;
    private String photo;
    private Date publicationDate;
    private String phone;
    private List<String> commentList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (status != product.status) return false;
        if (superCategory != null ? !superCategory.equals(product.superCategory) : product.superCategory != null)
            return false;
        if (category != null ? !category.equals(product.category) : product.category != null) return false;
        if (cost != null ? !cost.equals(product.cost) : product.cost != null) return false;
        if (owner != null ? !owner.equals(product.owner) : product.owner != null) return false;
        if (attributesAndValues != null ? !attributesAndValues.equals(product.attributesAndValues) : product.attributesAndValues != null)
            return false;
        if (title != null ? !title.equals(product.title) : product.title != null) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (photo != null ? !photo.equals(product.photo) : product.photo != null) return false;
        if (publicationDate != null ? !publicationDate.equals(product.publicationDate) : product.publicationDate != null)
            return false;
        if (phone != null ? !phone.equals(product.phone) : product.phone != null) return false;
        return commentList != null ? commentList.equals(product.commentList) : product.commentList == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (superCategory != null ? superCategory.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (attributesAndValues != null ? attributesAndValues.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + (publicationDate != null ? publicationDate.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (commentList != null ? commentList.hashCode() : 0);
        return result;
    }


    /**
     * Default constructor of product
     */
    public Product() {}

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public String getSuperCategory() { return superCategory; }

    public void setSuperCategory(String superCategory) { this.superCategory = superCategory; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public Date getPublicationDate() { return publicationDate; }

    public void setPublicationDate(Date publicationDate) { this.publicationDate = publicationDate; }

    public String getPhone() { return phone; }

    public void setPhone(String phone) { this.phone = phone; }

    public List<String> getCommentsList() { return commentList; }

    public void setCommentsList(List<String> commentsList) { this.commentList = commentsList; }

    public Map<String, String> getAttributesAndValues() {
        return attributesAndValues;
    }

    public void setAttributesAndValues(Map<String, String> attributesAndValues) {
        this.attributesAndValues = attributesAndValues;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<String> commentList) {
        this.commentList = commentList;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Information about object
     *
     * @return string value
     */
    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", status=" + status +
                ", superCategory='" + superCategory + '\'' +
                ", category='" + category + '\'' +
                ", cost='" + cost + '\'' +
                ", owner='" + owner + '\'' +
                ", attributesAndValues=" + attributesAndValues +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", photo=" + photo +
                ", publicationDate=" + publicationDate +
                ", phone='" + phone + '\'' +
                ", commentList=" + commentList +
                '}';
    }
}
