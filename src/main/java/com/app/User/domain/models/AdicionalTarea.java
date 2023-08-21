package com.app.User.domain.models;



public class AdicionalTarea {

    private final Integer userId;

    private final String userName;

    private final String userEmail;

    public AdicionalTarea(Integer userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
