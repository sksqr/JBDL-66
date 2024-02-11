package com.gfg;

public class DiDemo {

    public static void main(String[] args) {

        Car c1 = new Car();
        c1.runCar();

        Car c2 = new Car();
        c2.runCar();

        Engine engine = new Engine("Power Engine",1400);
        //developer, application
        Car c3 = new Car("Nexo", engine);

        Car c4 = new Car("Hexa", engine);


        /*
          JsonUtil

          PaymentService{
           JsonUtil util;
           PaymentService(JsonUtil util){
           }
          }

          OrderService{
           JsonUtil util;

           OrderService(JsonUtil util){
           }
          }
         */
    }
}
