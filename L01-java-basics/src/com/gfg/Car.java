package com.gfg;

public class Car {

    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start(){
        System.out.println("Starting car with "+engine.getName());
    }
}
