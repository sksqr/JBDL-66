package com.gfg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemo {

    public static void main(String[] args) {
       // ExecutorService executorService = Executors.newFixedThreadPool(5);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        MyTask task1 = new MyTask();
        executorService.submit(task1);
        executorService.submit(task1);
        executorService.submit(task1);

        long start = System.currentTimeMillis();
        for(int i=0; i<100; i++){
            executorService.submit(() -> {
                System.out.println("Executing in "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }


        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("Time Taken:"+(end-start)+" ms");
        System.out.println("Done");
    }
}
