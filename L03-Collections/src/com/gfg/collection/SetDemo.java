package com.gfg.collection;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {

        Set<Student> studentSet = new HashSet<>();
        Student rahul1 = new Student("Rahul",1, 90);
        Student rahul2 = new Student("Rahul Kumar",1, 90);

        System.out.println(rahul1.equals(rahul2));

        System.out.println(rahul1.hashCode());
        System.out.println(rahul2.hashCode());

        studentSet.add(rahul1);
        studentSet.add(new Student("Vijay",3, 95));
        studentSet.add(new Student("Ajay",6, 85));
        studentSet.add(rahul2);

        System.out.println(studentSet.size());

        System.out.println(studentSet);
    }
}
