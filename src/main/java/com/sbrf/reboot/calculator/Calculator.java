package com.sbrf.reboot.calculator;

public class Calculator {
    public static int getAddition(int a, int b){
        return (a + b);
    }

    public static int getSubtraction(int a, int b){
        return (a - b);
    }

    public static int getMultiplication(int a, int b){
        return (a * b);
    }

    public static int getDivision(int a, int b){
        return (a / b);
    }

    public static int getSquare(int a){
        return (a * a);
    }

    public static int getExponentiation(int a, int b){
        int result = 1;
        for (int i = 1; i <= b; i++) {
            result = result * a;
        }
        return result;
    }

    public static double getPercentage(int a, int b){
        return ((double) a / b) * 100.00;
    }
}
