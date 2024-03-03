package com.example.L12UnitTestdemo;

public class NormalTest {
    public static void main(String[] args) {
        Integer a = 8;
        Integer b = 2;

        Calculator calculator = new Calculator();
        if(calculator.multiply(a,b) != (a*b) ){
            System.out.println("Test Failed");
        }
        else {
            System.out.println("Test Passed");
        }

//        Calculator calculator = new Calculator();
//        if(calculator.add(a,b) != (a+b) ){
//            System.out.println("Test Failed");
//        }
//        else {
//            System.out.println("Test Passed");
//        }

    }
}
