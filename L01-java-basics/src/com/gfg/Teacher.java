package com.gfg;

public class Teacher extends Person {

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
}
