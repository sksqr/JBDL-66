package com.gfg;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIoCDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("projectbeans.xml");
        Engine engine1 = applicationContext.getBean("engine1",Engine.class);
        System.out.println(engine1);

        Engine engineA = applicationContext.getBean("engine1",Engine.class);
        System.out.println(engine1 == engineA);
        System.out.println(engine1.equals(engineA));

        Engine engine2 = applicationContext.getBean("engine2",Engine.class);
        System.out.println(engine2);

        Engine engineB = applicationContext.getBean("engine2",Engine.class);
        System.out.println(engine2 ==  engineB);

//        Engine engine3 = applicationContext.getBean("engine3",Engine.class);
//        System.out.println(engine3);

        Car car1 = applicationContext.getBean("car1",Car.class);
        car1.runCar();

        applicationContext.close();
    }
}
