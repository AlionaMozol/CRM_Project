package com.project.crm.model;

/**
 * Created by 1 on 06.11.2017.
 */
public class Category {


    private String title;
    private boolean isTop;
    private Category supercategory;


    public Category() {
        this.isTop=false;
        this.supercategory=null;
    }

    public String getTitle() {
        return title;
    }

    public boolean isTop() {
        return isTop;
    }

    public Category getSupercategory() {
        return supercategory;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTop(boolean top) {
        isTop = top;
    }
    public void setSupercategory(Category supercategory) {
        this.supercategory = supercategory;
    }

}
