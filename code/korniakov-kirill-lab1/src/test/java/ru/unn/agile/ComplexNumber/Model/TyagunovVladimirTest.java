package ru.unn.agile.ComplexNumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class TyagunovVladimirTest {
    @Test
    public void canConvertComplexNumberWithInitialValuesToString() {
        ComplexNumber number = new ComplexNumber();
        assertEquals(number.toString(), "0.0 + 0.0i");
    }

    @Test
    public void canConvertComplexNumberToString() {
        ComplexNumber number = new ComplexNumber(7, 10);
        System.out.println(number.toString());
        assertEquals(number.toString(), "7.0 + 10.0i");
    }

    @Test
    public void isNumberEqualsToItself() {
        ComplexNumber number = new ComplexNumber(7, 10);
        assertEquals(number.equals(number), true);
    }

    @Test
    public void canCompareWithEmptyObject() {
        ComplexNumber number = new ComplexNumber(7, 10);
        Object object = new Object();
        assertEquals(number.equals(object), false);
    }
}
