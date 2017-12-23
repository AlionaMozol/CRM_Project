package com.project.crm.model;

/**
 * Simple JavaBean object that represents Email of {@link User}.
 */
public class Email {
    private String from;
    private String title;
    private String message;

    public Email() {

    }

    public Email(String from, String title, String message) {
        this.from = from;
        this.title = title;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Email{" +
                "form='" + from + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        if (from != null ? !from.equals(email.from) : email.from != null) return false;
        if (title != null ? !title.equals(email.title) : email.title != null) return false;
        return message != null ? message.equals(email.message) : email.message == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String form) {
        this.from = form;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}