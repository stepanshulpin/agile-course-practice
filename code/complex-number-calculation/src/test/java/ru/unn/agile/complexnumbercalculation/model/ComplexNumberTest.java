package ru.unn.agile.complexnumbercalculation.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumberTest {
    @Test
    public void createComplexNumberByDefaultNotNull() {
        ComplexNumber a = new ComplexNumber();

        assertNotNull(a);
    }

    @Test
    public void emptyCreateComplexNumberCheckRealPart() {
        ComplexNumber a = new ComplexNumber();

        assertEquals(0.0, a.getRe(), 0.0);
    }

    @Test
    public void emptyCreateComplexNumberCheckImaginePart() {
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
    public void equalTwoComplexNumbers() {
        ComplexNumber a = new ComplexNumber(5.0, -6.0);
        ComplexNumber b = new ComplexNumber(5.0, -6.0);

        assertEquals(a, b);
    }

    @Test
    public void notEqualTwoComplexNumbers() {
        ComplexNumber a = new ComplexNumber(5.0, -6.0);
        ComplexNumber b = new ComplexNumber(-5.0, -6.0);

        assertNotEquals(a, b);
    }

    @Test
    public void equalTwoComplexNumbersWithOperand() {
        ComplexNumber a = new ComplexNumber(5.0, -6.0);
        ComplexNumber b = new ComplexNumber(a);

        assertTrue(a.equals(b));
    }

    @Test
    public void equalHashCodeOfTwoComplexNumbers() {
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

        a.convertToTrigonomForm();

        assertEquals(2, a.getRadius(), 0.001);
    }

    @Test
    public void convertComplexNumberToTrigonomFormCheckAngle() {
        ComplexNumber a = new ComplexNumber(1.0, -Math.sqrt(3));

        a.convertToTrigonomForm();

        assertEquals(-Math.PI / 3, a.getAngle(), 0.001);
    }

}
