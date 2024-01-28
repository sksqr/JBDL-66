package com.gfg;

public class SingletonDemo {

    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        Teacher t2 = new Teacher();
//
//        ParentCompany parentCompany = new ParentCompany();
//        ParentCompany parentCompany2 = new ParentCompany();

//        ParentCompany parentCompany = ParentCompany.getInstance();
//        ParentCompany parentCompany2 = ParentCompany.getInstance();
//
//        System.out.println(parentCompany2 == parentCompany);

        ParentCompany.simpleMethod();

    }
}
