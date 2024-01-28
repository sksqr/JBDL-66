package com.gfg.collection;

import java.util.ArrayList;
import java.util.List;

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

        List<String> studentsList = new ArrayList<>();
        studentsList.add("Ravi");
        studentsList.add("Neeraj");
        studentsList.add("Dheeraj");
        studentsList.add("Vijay");



    }


    public static void print(String students[]){
        for(String val : students){
            System.out.println(val);
        }
    }
}
