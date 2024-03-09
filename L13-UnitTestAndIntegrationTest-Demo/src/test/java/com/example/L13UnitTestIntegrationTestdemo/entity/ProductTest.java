package com.example.L13UnitTestIntegrationTestdemo.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductTest {


    @Test
    public void testConstructor(){
        String name = "laptop";
        Double cost = 50000.00;
        Product product = new Product(name,cost);
        assertThat(product.getName()).isEqualTo(name);
        assertThat(product.getCost()).isEqualTo(cost);
    }


    @Test
    public void testSettersAndGetters(){
        Product product = new Product("pen",10.0);
        String name = "laptop";
        Double cost = 50000.00;
        product.setName(name);
        product.setCost(cost);
        assertThat(product.getName()).isEqualTo(name);
        assertThat(product.getCost()).isEqualTo(cost);
    }
}
