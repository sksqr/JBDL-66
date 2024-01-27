package com.gfg;

public class InheritanceDemo {

    public static void main(String[] args) {
        Teacher t1 = new Teacher();
        t1.setName("Ravi");
        t1.setSubject("java");
        t1.walk();

        Person p1 = new Person();
        p1.setName("Rahul");
        p1.walk();

        Person p2 = new Teacher("Maths");
        p2.setName("Vishnu");
        p2.walk();

        System.out.println(p2 instanceof Teacher);
        Teacher t2 = (Teacher) p2;
        t2.setSubject("Physics");
        t2.walk();
        System.out.println(t2 == p2);




        Teacher teacher1 = new Teacher("Chemistry");
        System.out.println(teacher1 instanceof Person);
        Person person1 = (Person)teacher1;
        person1.walk();

//
//        System.out.println(p1 instanceof Teacher);
//        Teacher t3 = (Teacher) p1;
//        t3.setSubject("Physics");
//        t2.walk();
//        System.out.println(t3 == p1);
    }
}
