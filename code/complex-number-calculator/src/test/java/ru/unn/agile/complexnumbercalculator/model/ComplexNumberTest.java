package ru.unn.agile.complexnumbercalculator.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumberTest {
    @Test
    public void createComplexNumberByDefaultNotNull() {
        ComplexNumber a = new ComplexNumber();

        assertNotNull(a);
    }

    @Test
    public void canCreateComplexNumberCheckRealPart() {
        ComplexNumber a = new ComplexNumber();

        assertEquals(0.0, a.getRe(), 0.0);
    }

    @Test
    public void createEmptyComplexNumberCheckImaginePart() {
        ComplexNumber a = new ComplexNumber();

        assertEquals(0.0, a.getIm(), 0.0);
    }
    @Test
    public void createComplexNumberWithParametersNotNull() {
        ComplexNumber a = new ComplexNumber(5.0, 6.0);

        assertNotNull(a);
    }

    @Test
    public void createComplexNumberWithParametersCheckRe() {
        ComplexNumber a = new ComplexNumber(5.0, 6.0);

        assertEquals(5.0, a.getRe(), 0.0);
    }

    @Test
    public void createComplexNumberWithParametersCheckIm() {
        ComplexNumber a = new ComplexNumber(5.0, 6.0);

        assertEquals(6.0, a.getIm(), 0.0);
    }

    @Test
    public void createComplexNumberWithNegativeParametersCheckRe() {
        ComplexNumber a = new ComplexNumber(-5.0, 6.0);

        assertEquals(-5.0, a.getRe(), 0.0);
    }

    @Test
    public void createComplexNumberWithNegativeParametersCheckIm() {
        ComplexNumber a = new ComplexNumber(5.0, -6.0);

        assertEquals(-6.0, a.getIm(), 0.0);
    }

    @Test
    public void canEqualTwoComplexNumbers() {
        ComplexNumber a = new ComplexNumber(5.0, -6.0);
        ComplexNumber b = new ComplexNumber(5.0, -6.0);

        assertEquals(a, b);
    }

    @Test
    public void cantEqualTwoComplexNumbers() {
        ComplexNumber a = new ComplexNumber(5.0, -6.0);
        ComplexNumber b = new ComplexNumber(-5.0, -6.0);

        assertNotEquals(a, b);
    }

    @Test
    public void canEqualTwoComplexNumbersWithOperand() {
        ComplexNumber a = new ComplexNumber(5.0, -6.0);
        ComplexNumber b = new ComplexNumber(a);

        assertTrue(a.equals(b));
    }

    @Test
    public void canEqualHashCodeOfTwoComplexNumbers() {
        ComplexNumber a = new ComplexNumber(5.0, -6.0);
        ComplexNumber b = new ComplexNumber(5.0, -6.0);

        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    public void convertComplexNumberToString() {
        ComplexNumber a = new ComplexNumber(5.0, 2.0);

        String string = a.toString();

        assertEquals("5.0 + 2.0i", string);
    }

    @Test
    public void convertComplexNumberToStringWithNegative() {
        ComplexNumber a = new ComplexNumber(5.0, -2.0);

        String string = a.toString();

        assertEquals("5.0 - 2.0i", string);
    }

    @Test
    public void convertComplexNumberToStringWithNull() {
        ComplexNumber a = new ComplexNumber(0.0, -2.0);

        String string = a.toString();

        assertEquals("0.0 - 2.0i", string);
    }

    @Test
    public void convertComplexNumberToTrigonometricFormCheckRadius() {
        ComplexNumber a = new ComplexNumber(1.0, -Math.sqrt(3));

        assertEquals(2, a.getModule(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonometricFormCheckAngle() {
        ComplexNumber a = new ComplexNumber(1.0, -Math.sqrt(3));

        assertEquals(-Math.PI / 3, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonometricForm() {
        ComplexNumber a = new ComplexNumber(-1.0, 0.0);

        assertEquals(Math.PI, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonometricFormWithoutIm() {
        ComplexNumber a = new ComplexNumber(1.0, 0.0);

        assertEquals(0.0, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonometricFormWithoutImNegRe() {
        ComplexNumber a = new ComplexNumber(-1.0, 0.0);

        assertEquals(Math.PI, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonometricFormWithoutRe() {
        ComplexNumber a = new ComplexNumber(0.0, 1.0);

        assertEquals(Math.PI / 2, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonometricFormWithoutReNegIm() {
        ComplexNumber a = new ComplexNumber(0.0, -1.0);

        assertEquals(-Math.PI / 2, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void canGetModuleNot0() {
        ComplexNumber a = new ComplexNumber(1, 1);

        assertEquals(Math.sqrt(2), a.getModule(), a.getAccuracy());
    }


    @Test
    public void canGetArgumentNot0() {
        ComplexNumber a = new ComplexNumber(1, 1);

        assertEquals(Math.PI / 4, a.getArgument(), a.getAccuracy());
    }

    @Test
    public void canSetTrigonometricForm() {
        ComplexNumber a = new ComplexNumber(0.0, -1.0);
        a.setTrigonometricForm(-8.0,  Math.PI / 2);

        assertEquals(0.0, a.getRe(), a.getAccuracy());
    }


}
