package com.gfg;

import java.util.Scanner;

public class PolymorphismDemo {

    public static void main(String[] args) {
        AreaCalculator areaCalculator = new AreaCalculator();

        System.out.println(areaCalculator.area(5,6));

        Person person = null;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        if(input.equals("T")){
            person = new Teacher("MAth");
        }
        else{
            person = new Person();
        }
        person.setName("Rahul");
        person.walk();


//        final Person person1 = new Person();
//        person1 = new Teacher();
//
    }
}
