package com.calculator;

public class Calculator {
    public static void main(String[] args){
        System.out.println("1 + 2 = " + add(1, 2));
        System.out.println("9 - 2 = " + subtract(9,2));
    }

    public static int add(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) { return a - b; }
}
