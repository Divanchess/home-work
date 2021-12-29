package com.sbrf.reboot.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void getAddition() {
        assertEquals(9, Calculator.getAddition(4, 5));
    }

    @Test
    void getSubtraction() {
        assertEquals(-1, Calculator.getSubtraction(4, 5));
    }

    @Test
    void getMultiplication() {
        assertEquals(20, Calculator.getMultiplication(4, 5));
    }

    @Test
    void getDivision() {
        assertEquals(3, Calculator.getDivision(9, 3));
    }

    @Test
    void getDivisionZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            int result = Calculator.getDivision(12, 0);
        });
    }

    @Test
    void getSquare() {
        assertEquals(256, Calculator.getSquare(16));
    }

    @Test
    void getExponentiation() {
        assertEquals(15625, Calculator.getExponentiation(5, 6));
    }

    @Test
    void getPercentage() {
        assertEquals(11.25, Calculator.getPercentage(9, 80));
    }

    @Test
    void getPercentageZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            double result = Calculator.getPercentage(71, 0);
        });
    }

    @Test
    void classHasSevenMethods(){
        assertEquals(7,Calculator.class.getMethods().length-Object.class.getMethods().length);
    }
}