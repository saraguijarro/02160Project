package com.project.dto;

public enum UserType {
    CLIENT("CLIENT"),
    LOGISTIC_COMPANY("LOGISTIC_COMPANY");

    private String userType;

    UserType(String userType) {
        this.userType = userType;
    }

    public String getUrl() {
        return userType;
    }
}
