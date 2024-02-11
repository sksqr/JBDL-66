package com.gfg;

public class Car {

    private String name;

    private Engine engine;

    public Car() {
        System.out.println("Creating Car");
        name ="Tata Tiago";
        engine = new Engine("Revetron",1200);
    }

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public void runCar(){
        System.out.println("Running Car "+name+" with engine "+engine.getName());
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
