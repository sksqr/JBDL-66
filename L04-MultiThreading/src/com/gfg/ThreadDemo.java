package com.gfg;

public class ThreadDemo {
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        myThread2.setName("Thread-02");
        myThread1.setName("MyThread-01");
        myThread1.run(); // Execute in main thread
        myThread1.start();

        //myThread1.start();
        myThread2.start();
        try {
            myThread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        myThread1.run();
        System.out.println("Done");

    }
}
