package com.gfg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        int corePoolSize = 5;
        int maxPoolSize = 10;
        long keepAliveTime = 5000;
        ExecutorService executorService = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(40)
        );


        long start = System.currentTimeMillis();
        for(int i=0; i<50; i++){
            executorService.submit(() -> {
                System.out.println("Executing in "+Thread.currentThread().getName());
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for(int i=0; i<10; i++){
            executorService.submit(() -> {
                System.out.println("Executing another task in "+Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
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
