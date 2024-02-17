package com.example.L07LoggingMVCdemo;

public class LombokDemo {

    public static void main(String[] args) {
        Product product = new Product();
        product.setId(1l);

        Product product2 = new Product(2l,"Laptop",50000.00);

        System.out.println(product2);
    }
}
