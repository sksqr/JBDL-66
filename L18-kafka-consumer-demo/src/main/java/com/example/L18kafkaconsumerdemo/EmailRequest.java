package com.example.L18kafkaconsumerdemo;

public class EmailRequest {

    private String toEmail;

    private String subject;

    private String body;

    private String cc;

    public EmailRequest(String toEmail, String subject, String body, String cc) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.body = body;
        this.cc = cc;
    }

    public EmailRequest() {
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "EmailRequest{" +
                "toEmail='" + toEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", cc='" + cc + '\'' +
                '}';
    }
}

