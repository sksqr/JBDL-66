package com.gfg.annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAnnotationDemo {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.gfg.annotations");

        NotificationService notificationService = applicationContext.getBean("notificationService",NotificationService.class);

        notificationService.sendNotification("Transaction Done");


        //Not bean
        NotificationService notificationService1 = new NotificationService();
    }
}
