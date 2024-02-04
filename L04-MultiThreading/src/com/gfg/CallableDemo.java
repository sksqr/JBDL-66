package com.gfg;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CallableTask callableTask = new CallableTask();
        Future<String> future = executorService.submit(callableTask);
        try {
            if (future.isDone()){
                System.out.println(future.get(100, TimeUnit.MILLISECONDS));
            }
            System.out.println(future.get(100, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

        List<CallableTask> callableTaskList = new ArrayList<>();
        for(int i=0; i<10; i++){
            callableTaskList.add(callableTask);
        }
        try {
            List<Future<String>> futureList = executorService.invokeAll(callableTaskList);
            for(Future<String> future1 : futureList){
                System.out.println(future1.get());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Done");

    }
}
