package com.gamesofnumbers.wallpaper;

public class Wallpaper {

    private String id;

    private String name;

    private String userId;

    private String userName;

    private String imageUrl;

    private String uploadedTime;

    private String contentType;

    private String description;

    private String thumbUrl;

    public Wallpaper(String id, String name, String userId, String userName, String imageUrl, String uploadedTime, String contentType, String description, String thumbUrl) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.userName = userName;
        this.imageUrl = imageUrl;
        this.uploadedTime = uploadedTime;
        this.contentType = contentType;
        this.description = description;
        this.thumbUrl = thumbUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUploadedTime() {
        return uploadedTime;
    }

    public void setUploadedTime(String uploadedTime) {
        this.uploadedTime = uploadedTime;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }
}
