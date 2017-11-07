package com.project.crm.model;

import com.project.crm.model.enums.Status;

import java.awt.*;
import java.util.Date;
import java.util.List;

public class Product {


    private int id;
    private Status status;
    private String supercategory;
    //private String category;
    //private List<Pair<String, String>> attributesAndValues;
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


    /**
     * Information about object
     *
     * @return string value
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", status=" + status +
                ", supercategory='" + supercategory + '\'' +
                //", category='" + category + '\'' +
                //", categoryListAdress'" + attributesAndValues + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", photo=" + photo +
                ", publicationDate=" + publicationDate +
                ", phone='" + phone + '\'' +
                ", commentList=" + commentList +
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

        Product product = (Product) o;

        if (id != product.id) return false;
        if (cost != product.cost) return false;
        if (status != product.status) return false;
        if (supercategory != null ? !supercategory.equals(product.supercategory) : product.supercategory != null) return false;
        if (!title.equals(product.title)) return false;
        if (description != null ? !description.equals(product.description) : product.description != null) return false;
        if (photo != null ? !photo.equals(product.photo) : product.photo != null) return false;
        if (!publicationDate.equals(product.publicationDate)) return false;
        if (!phone.equals(product.phone)) return false;
        if (!supercategory.equals(product.supercategory)) return false;
        //if (!category.equals(product.category)) return false;
        //добавить сравнение списков атрибутов значений
        return commentList != null ? commentList.equals(product.commentList) : product.commentList == null;
    }

    /**HashCode of object
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + status.hashCode();
        result = 31 * result + (supercategory != null ? supercategory.hashCode() : 0);
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + cost;
        result = 31 * result + (photo != null ? photo.hashCode() : 0);
        result = 31 * result + publicationDate.hashCode();
        result = 31 * result + phone.hashCode();
        result = 31 * result + (commentList != null ? commentList.hashCode() : 0);
        //добавить списки атрибутов значений и категорию
        return result;
    }



    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public String getSupercategory() { return supercategory; }

    public void setSupercategory(String supercategory) { this.supercategory = supercategory; }

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

    /*public List<Pair<String, String>> getAttributesAndValues() {
        return attributesAndValues;
    }

    public void setAttributesAndValues(List<Pair<String, String>> attributesAndValues) {
        this.attributesAndValues = attributesAndValues;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }*/

}
