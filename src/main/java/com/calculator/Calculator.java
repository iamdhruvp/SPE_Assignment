package com.calculator;

public class Calculator {
    public static void main(String[] args){
        System.out.println("1 + 2 = " + add(1, 2));
        System.out.println("9 - 2 = " + subtract(9,2));
        System.out.println("6 * 3 = " + multiply(6,3));
        System.out.println("6 / 3 = " + divide(6,3));
    }

    public static int add(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) { return a - b; }
    public static long multiply(int a, int b) {
        return a * b;
    }

    public static double divide(int a, int b) {
        double result;
        if (b == 0) throw new IllegalArgumentException("Divisor cannot divide by zero");
        else result = Double.valueOf(a)/Double.valueOf(b);
        return result;
    }
}
