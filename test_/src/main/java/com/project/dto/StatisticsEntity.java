package com.project.dto;

import java.sql.Time;

public class StatisticsEntity {

    private int id;
    private int user_id;
    private String action;
    private Time started;
    private Time ended;

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setStarted(Time started) {
        this.started = started;
    }

    public void setEnded(Time ended) {
        this.ended = ended;
    }


    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getAction() {
        return action;
    }

    public Time getStarted() {
        return started;
    }

    public Time getEnded() {
        return ended;
    }

}
