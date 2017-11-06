package com.project.crm.model;

/**
 * Created by 1 on 06.11.2017.
 */
public class Supercategory {



    private String title;
    public Supercategory() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supercategory that = (Supercategory) o;

        return title != null ? title.equals(that.title) : that.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Supercategory{" +
                "title='" + title + '\'' +
                '}';
    }
}
