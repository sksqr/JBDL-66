package com.gfg;

public class Person {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void walk(){
        System.out.println(name+" is walking.");
    }

}
