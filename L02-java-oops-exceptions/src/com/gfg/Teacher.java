package com.gfg;

import java.io.Serializable;

public class Teacher extends Person implements Serializable {


    transient private Integer teacherId;

    private String subject;


    public String getSubject() {
        return subject;
    }

    public Teacher() {
    }

    public Teacher(String subject) {
        super();
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void walk(){
//        System.out.println(getName()+", teacher of "+subject+" is walking");
        System.out.println("teacher of "+subject);
        super.walk();
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
