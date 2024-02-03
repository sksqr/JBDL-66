package com.gfg.collection;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {


        Map<String,Student> map = new HashMap();

        Student rahul1 = new Student("Rahul",1, 90);
        Student rahul2 = new Student("Rahul Kumar",1, 90);

        Student shashi = new Student("Shashi",2, 90);

        System.out.println(rahul1.equals(rahul2));

//        map.put("rahul1",rahul1);
//        map.put("rahul2",rahul2);
//        System.out.println(map.size());

//        map.put("rahul",rahul1);
//        map.put("rahul",rahul2);
//        map.put("shashi",shashi);
//        System.out.println(map.size());


//        map.put("rahul",rahul1);
//        map.put("rahul",rahul1);
//        System.out.println(map.size());



        Map<Student,String> stringMap = new HashMap<>();
        stringMap.put(rahul1,"Rahul1");
        stringMap.put(rahul2,"Rahul1");
        System.out.println(stringMap.size());
    }
}
