package com.sbrf.reboot.calculator;

public class Calculator {
    public static int getAddition(int a, int b){
        return Math.addExact(a, b);
    }

    public static int getSubtraction(int a, int b){
        return Math.subtractExact(a, b);
    }

    public static int getMultiplication(int a, int b){
        return Math.multiplyExact(a, b);
    }

    public static int getDivision(int a, int b){
        if(b == 0) {
            throw new IllegalArgumentException("Error. Divisor (second argument) cannot be zero");
        }
        return Math.floorDiv(a, b);
    }

    public static int getSquare(int a){
        return Math.multiplyExact(a, a);
    }

    public static int getExponentiation(int a, int b){
        int result = 1;
        for (int i = 1; i <= b; i++) {
            result = Math.multiplyExact(result, a);
        }
        return result;
    }

    public static double getPercentage(int a, int b){
        if(b == 0) {
            throw new IllegalArgumentException("Error. Divisor (second argument) cannot be zero");
        }

        double result = ((double) a *100 / b);

        if(result == Double.POSITIVE_INFINITY ) {
            throw new ArithmeticException("Double overflow resulting in POSITIVE_INFINITY");
        } else if(result == Double.NEGATIVE_INFINITY) {
            throw new ArithmeticException("Double overflow resulting in NEGATIVE_INFINITY");
        } else if(Double.compare(-0.0f, result) == 0) {
            throw new ArithmeticException("Double overflow resulting in negative zero");
        } else if(Double.compare(+0.0f, result) == 0) {
            throw new ArithmeticException("Double overflow resulting in positive zero");
        }

        return result;
    }
}
