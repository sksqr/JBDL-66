package com.gfg;

public class Engine {
    private String name;

    private Integer cc;

    public Engine(String name, Integer cc) {
        this.name = name;
        this.cc = cc;
    }

    public Engine() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCc() {
        return cc;
    }

    public void setCc(Integer cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "name='" + name + '\'' +
                ", cc=" + cc +
                '}';
    }

    public void engineInit(){
        System.out.println("Executing engineInit for "+this.getName());

    }

    public void engineDestroy(){
        System.out.println("Executing engineDestroy for "+this.getName());
    }
}
