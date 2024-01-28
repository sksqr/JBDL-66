package com.gfg.exceptions;

import com.gfg.Lecture;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExceptionDemo {

    public void nonStatic(){
        ProductService productService = new ProductService();
        try {
            System.out.println(productService.getProductById(1));
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
//        System.out.println("Enter Name:");
//        Scanner scanner = new Scanner(System.in);
//        String name = scanner.next();
//        System.out.println(name.charAt(9));
        readDataFromFile();
        System.out.println("Done");


        Lecture lecture = new Lecture();

        if(lecture.getStatus() != null){
            System.out.println(lecture.getStatus().name());
        }

        ProductService productService = new ProductService();

        try {
            System.out.println(productService.getProductById(1));
        } catch (ProductNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static  void readDataFromFile()  {
        FileReader  fileReader = null;
        try {
            fileReader = new FileReader("/tmp/testFile.txt");
            int a = fileReader.read();
            System.out.println("Completed");
        } catch (FileNotFoundException e) {
            //
//            throw new RuntimeException(e);
            System.out.println("Got Exception FileNotFoundException");
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Got Exception IOException");

        }
        finally {
            try {
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Executing finally block");
        }
        System.out.println("Completion of method");
    }


    public static  void readDataFromFileTryWithResource()  {

        try (FileReader fileReader = new FileReader("/tmp/testFile.txt")){
            int a = fileReader.read();
            System.out.println("Completed");
        } catch (IOException e) {
            System.out.println("Got Exception IOException");
        }
        finally {
            System.out.println("Executing finally block");
        }
        System.out.println("Completion of method");
    }

}
