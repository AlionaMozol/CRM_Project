package com.project.crm.model;

import java.util.List;

/**
 * Simple JavaBean object that represents Category of {@link Product}.
 */
public class Category {

    private String title;
    private boolean isTop;
    private Category supercategory;
    private List<Category> subcategories;

    public Category() {
        this.isTop = false;
        this.supercategory = null;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public Category getSupercategory() {
        return supercategory;
    }

    public void setSupercategory(Category supercategory) {
        this.supercategory = supercategory;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Category> subcatigories) {
        this.subcategories = subcategories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (isTop != category.isTop) return false;
        if (title != null ? !title.equals(category.title) : category.title != null) return false;
        return supercategory != null ? supercategory.equals(category.supercategory) : category.supercategory == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (isTop ? 1 : 0);
        result = 31 * result + (supercategory != null ? supercategory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return title;
    }
}
