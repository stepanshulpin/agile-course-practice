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
    public void convertComplexNumberToTrigonomFormCheckRadius() {
        ComplexNumber a = new ComplexNumber(1.0, -Math.sqrt(3));

        a.convertToTrigonometricForm();

        assertEquals(2, a.getModule(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonomFormCheckAngle() {
        ComplexNumber a = new ComplexNumber(1.0, -Math.sqrt(3));

        a.convertToTrigonometricForm();

        assertEquals(-Math.PI / 3, a.getPhase(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonomForm() {
        ComplexNumber a = new ComplexNumber(-1.0, 0.0);

        a.convertToTrigonometricForm();

        assertEquals(Math.PI, a.getPhase(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonomFormWithoutIm() {
        ComplexNumber a = new ComplexNumber(1.0, 0.0);

        a.convertToTrigonometricForm();

        assertEquals(0.0, a.getPhase(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonomFormWithoutImNegRe() {
        ComplexNumber a = new ComplexNumber(-1.0, 0.0);

        a.convertToTrigonometricForm();

        assertEquals(Math.PI, a.getPhase(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonomFormWithoutRe() {
        ComplexNumber a = new ComplexNumber(0.0, 1.0);

        a.convertToTrigonometricForm();

        assertEquals(Math.PI / 2, a.getPhase(), a.getAccuracy());
    }

    @Test
    public void convertComplexNumberToTrigonomFormWithoutReNegIm() {
        ComplexNumber a = new ComplexNumber(0.0, -1.0);

        a.convertToTrigonometricForm();

        assertEquals(-Math.PI / 2, a.getPhase(), a.getAccuracy());
    }

    @Test
    public void canGetRadiusNot0() {
        ComplexNumber a = new ComplexNumber(1, 1);

        assertEquals(Math.sqrt(2), a.getModule(), a.getAccuracy());
    }


    @Test
    public void canGetAngleNot0() {
        ComplexNumber a = new ComplexNumber(1, 1);

        assertEquals(Math.PI / 4, a.getPhase(), a.getAccuracy());
    }

}
