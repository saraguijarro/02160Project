
package com.project.dto;

import java.io.Serializable;
import java.sql.Time;



public class UserEntity implements Serializable {
    private long id;
    private String email;
    private String password;
    private Time created;
    private UserType userType;


    public UserEntity() {

    }

    public UserEntity(String email, String password, UserType userType) {
        this.userType = userType;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Time getCreated() {
        return created;
    }

    public void setCreated(Time created) {
        this.created = created;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserType getUserType() {
        return userType;
    }
}
