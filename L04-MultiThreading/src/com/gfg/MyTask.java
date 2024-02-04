package com.gfg;

public class MyTask implements Runnable{
    private String data;


    @Override
    public void run() {
        System.out.println("Running in Runnable by thread: "+Thread.currentThread().getName());
        data = "Data";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
