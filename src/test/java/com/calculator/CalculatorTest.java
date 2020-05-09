package com.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int a = 15;
        int b = 20;
        int expectedResult = 35;
        long result = calculator.add(a, b);
        Assert.assertEquals(expectedResult, result);;
    }

    @Test
    public void testSubtract() {
        int a = 25;
        int b = 20;
        int expectedResult = 5;
        long result = calculator.subtract(a, b);
        Assert.assertEquals(expectedResult, result);;
    }

    @Test
    public void testMultiply() {
        int a = 2;
        int b = 8;
        long expectedResult = 16;
        long result = calculator.multiply(a, b);
        Assert.assertEquals(expectedResult, result);;
    }

    @Test
    public void testDivide() {
        int a = 3;
        int b = 2;
        double expectedResult = 1.5;
        double result = calculator.divide(a, b);
        Assert.assertEquals(expectedResult, result,0.00005);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        int a = 1;
        int b = 0;
        calculator.divide(a, b);
    }
}
