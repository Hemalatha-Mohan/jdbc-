package com.springboot.training.jdbcproject.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import java.io.Serializable;

//@JsonIncludeProperties(JsonInclude.Include.NON_NULL)

@JsonIgnoreProperties(ignoreUnknown = true)

public class PostModel implements Serializable {

    private long userId;
    private long id;



    private String title;
    private String body;

    public PostModel()
    {

    }

    public PostModel(Long userId,String title,String body)
    {
        this.userId = userId;
        this.title = title;
        this.body = body;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


}
