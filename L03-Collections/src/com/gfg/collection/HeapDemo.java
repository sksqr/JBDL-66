package com.gfg.collection;

import java.util.*;

public class HeapDemo {

    public static void main(String[] args) {
       // Queue<Integer> queue = new PriorityQueue<>();// MinHeap

        List<List<Integer>> listOfList = new ArrayList<>();

        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());// MaxHeap

        queue.add(6);
        queue.add(8);
        queue.add(4);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());


        Queue<Student> studentQueue = new PriorityQueue<>();
        studentQueue.add(new Student("Rahul",1, 90));
        studentQueue.add(new Student("Vijay",3, 95));
        studentQueue.add(new Student("Ajay",6, 85));
        System.out.println(studentQueue.poll());
        System.out.println(studentQueue.poll());
        System.out.println(studentQueue.poll());

//
//        Queue<Student> studentMarksQueue = new PriorityQueue<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getTotalMarks() - o2.getTotalMarks();
//            }
//        });

        Queue<Student> studentMarksQueue = new PriorityQueue<>((o1, o2) -> o1.getTotalMarks() - o2.getTotalMarks());

        studentMarksQueue.add(new Student("Rahul",1, 90));
        studentMarksQueue.add(new Student("Vijay",3, 95));
        studentMarksQueue.add(new Student("Ajay",6, 85));
        System.out.println(studentMarksQueue.poll());
        System.out.println(studentMarksQueue.poll());
        System.out.println(studentMarksQueue.poll());


    }
}
