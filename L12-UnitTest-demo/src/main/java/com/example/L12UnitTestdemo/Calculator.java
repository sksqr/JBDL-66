package com.example.L12UnitTestdemo;


public class Calculator {

    public Integer add(Integer a, Integer b){
        return a+b;
    }

    public Integer multiply(Integer a, Integer b){
        Integer result=0;
        for(int i=0; i<b;i++){
            result = add(result,a);
        }
        return result;
    }

}
