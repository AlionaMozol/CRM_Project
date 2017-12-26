package com.project.crm.model;

/**
 * Simple JavaBean object that represents Comment of {@link User}.
 */
public class Comment {

    private String id;
    private String username;
    private String postId;
    private String text;
    private String date;
    private String userPhoto;

    public String getUserPhoto() { return userPhoto; }

    public void setUserPhoto(String userPhoto) { this.userPhoto = userPhoto; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
