package com.gfg;

import java.util.concurrent.atomic.AtomicInteger;

public class VisitorCounterTask implements Runnable{
    private int totalCount;

    private AtomicInteger atomicIntegerTotalCount = new AtomicInteger(0);


    @Override
    public void run() {
        increment();
        atomicIntegerTotalCount.incrementAndGet();
    }


    private synchronized   void increment(){
        totalCount++;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public AtomicInteger getAtomicIntegerTotalCount() {
        return atomicIntegerTotalCount;
    }
}
