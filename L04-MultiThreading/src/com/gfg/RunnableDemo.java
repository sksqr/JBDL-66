package com.gfg;

public class RunnableDemo {

    public static void main(String[] args) {
        MyTask task1 = new MyTask ();

        Thread t1 = new Thread(task1);
        t1.start();

        task1.run();

        Thread t2 = new Thread(() -> System.out.println("New Task in "+Thread.currentThread().getName()));
        t2.start();


        Thread t3 = new Thread(task1);
        t3.start();


        try {
            t2.join(10);
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Done");
    }
}
