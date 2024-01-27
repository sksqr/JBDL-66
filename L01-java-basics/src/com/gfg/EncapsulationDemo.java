package com.gfg;

public class EncapsulationDemo {


    public static void main(String[] args) {

        Lecture l1 = new Lecture();
        l1.status = "Walking";

        Lecture l2 = new Lecture("l02","Shashi","Pending");

        System.out.println(l2);

        System.out.println("Trying to change date");

        l2.getCreationDate().setTime(0);

        System.out.println(l2);

        System.out.println(l2.lectureDetails());
    }
}
