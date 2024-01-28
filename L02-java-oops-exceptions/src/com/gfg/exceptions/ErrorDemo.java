package com.gfg.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ErrorDemo {

    public static void main(String[] args) {
        //printData("Data");
        System.out.println("Enter:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        //heapOutOfMemoryDemo();
    }

    //Exception in thread "main" java.lang.StackOverflowError
    public static void printData(String msg){
        System.out.println(msg);
        printData(msg);
    }

    //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    public static void heapOutOfMemoryDemo(){
        List<Date> list = new ArrayList<>();
        while (true){
            list.add(new Date());
        }
    }
}
