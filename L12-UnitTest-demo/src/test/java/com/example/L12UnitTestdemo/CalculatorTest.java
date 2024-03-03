package com.example.L12UnitTestdemo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    @Test
    public void testAdd(){
        Integer a = 6;
        Integer b = 7;
        Integer expected = 13;
        assertThat(calculator.add(a,b)).isEqualTo(expected);
    }

    @Test
    public void testMultiply(){
        Integer a = 6;
        Integer b = 7;
        Integer expected = 42;
        assertThat(calculator.multiply(a,b)).isEqualTo(expected);
    }

}
