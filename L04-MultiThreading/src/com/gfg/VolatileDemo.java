package com.gfg;

public class VolatileDemo {

    public static void main(String[] args) {


        VolatileThread volatileThread = new VolatileThread();

        volatileThread.start();


        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        volatileThread.stopRunning();

        System.out.println("Done");

    }
}
