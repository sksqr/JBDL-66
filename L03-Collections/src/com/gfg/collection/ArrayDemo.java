package com.gfg.collection;

import java.util.*;

public class ArrayDemo {

    public static void main(String[] args) {
        String students[] = new String[2];
        students[0]= "Ravi";
        students[1]= "Neeraj";

        print(students);
        //students[2] = "Dheeraj";

        String temp[] = new String[3];
        for(int i=0; i<students.length; i++){
            temp[i] = students[i];
        }
        temp[2] = "Dheeraj;";
        students = temp;
        print(students);

        List<String> studentsList = new LinkedList<>();
        studentsList.add("Ravi");
        studentsList.add("Neeraj");
        studentsList.add("Dheeraj");
        studentsList.add("Vijay");

        Collections.sort(studentsList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //return o1.compareTo(o2);
                return o2.compareTo(o1);
            }
        });
        System.out.println("Sorted:");
        print(studentsList);



    }


    public static void print(String students[]){
        for(String val : students){
            System.out.println(val);
        }
    }

    public static void print(List<String> students){
        for(String val : students){
            System.out.println(val);
        }
    }
}
/*
3,5,1,8,10,-10
 */