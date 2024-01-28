package com.gfg;

public class ParentCompany {

    private String name;
    private static ParentCompany INSTANCE;

    private ParentCompany() {
        System.out.println("Creating Instance");
    }

    public static synchronized ParentCompany getInstance(){
        if(INSTANCE  == null){
            INSTANCE = new ParentCompany();

        }
        return INSTANCE;
    }

    public static void simpleMethod(){
        //System.out.println(name);
        System.out.println("Data printing");
    }

    public void nonStatic(){

    }
}
