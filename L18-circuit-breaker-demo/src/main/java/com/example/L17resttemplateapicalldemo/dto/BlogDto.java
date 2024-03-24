package com.example.L17resttemplateapicalldemo.dto;

import java.util.Date;

public class BlogDto {

    private Long id;

    private String title;

    private String body;

    private Date serverDateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Date getServerDateTime() {
        return serverDateTime;
    }

    public void setServerDateTime(Date serverDateTime) {
        this.serverDateTime = serverDateTime;
    }

    public BlogDto(Long id, String title, String body, Date serverDateTime) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.serverDateTime = serverDateTime;
    }

    public BlogDto() {
    }
}
