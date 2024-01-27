package com.gfg;

public class ClassObjectDemo {

    public static void main(String[] args) {

        System.out.println(Lecture.numOfObjects);
        Lecture l1 = new Lecture();
        l1.setMentor("Shashi");
        l1.setTitle("L01");
        l1.setStatus("Live");
        System.out.println(Lecture.numOfObjects);
        Lecture l2 = new Lecture("l02","Shashi","Pending");
        System.out.println(l1.getTitle());
        System.out.println(l2.getTitle());

        System.out.println(l1.numOfObjects);
        System.out.println(l2.numOfObjects);
        System.out.println(Lecture.numOfObjects);




    }
}
