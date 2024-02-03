package com.gfg.collection;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(4);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(8);

        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue.peek());
        System.out.println(queue.peek());



    }
}
