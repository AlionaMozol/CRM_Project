package com.project.crm.model;

/**
 * Created by 1 on 06.11.2017.
 */
public class Category {


    private String title;
    private Supercategory supercategory;

    public Category() {}

    public String getTitle() {
        return title;
    }
    public Supercategory getSupercategory() {
        return supercategory;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setSupercategory(Supercategory supercategory) {
        this.supercategory = supercategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (title != null ? !title.equals(category.title) : category.title != null) return false;
        return supercategory != null ? supercategory.equals(category.supercategory) : category.supercategory == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (supercategory != null ? supercategory.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                ", supercategory=" + supercategory +
                '}';
    }


}
