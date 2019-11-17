package ru.unn.agile.complexnumbercalculator.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumberCalculatorTest {
    @Test
    public void operationAdditionalCalculatorComplexNumber() {
        ComplexNumber z1 = new ComplexNumber(5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(9.0, 12.0);
        ComplexNumber result = ComplexNumberCalculator.add(z1, z2);

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationAdditionalCalculatorComplexNumberWithNegative() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(-1.0, 12.0);

        ComplexNumber result = ComplexNumberCalculator.add(z1, z2);

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationAdditionalCalculatorComplexNumberWithOneNull() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber();
        ComplexNumber expectedResult = new ComplexNumber(-5.0, 6.0);

        ComplexNumber result = ComplexNumberCalculator.add(z1, z2);

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationSubtractionCalculatorComplexNumber() {
        ComplexNumber z1 = new ComplexNumber(5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(1.0, -1.0);

        ComplexNumber result = ComplexNumberCalculator.subtract(z1, z2);

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationSubtractionCalculatorComplexNumberWithNegative() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(-9.0, 0.0);

        ComplexNumber result = ComplexNumberCalculator.subtract(z1, z2);

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationSubtractionCalculatorComplexNumberWithOneNull() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber();
        ComplexNumber expectedResult = new ComplexNumber(-5.0, 6.0);

        ComplexNumber result = ComplexNumberCalculator.subtract(z1, z2);

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationMultiplicationCalculatorComplexNumber() {
        ComplexNumber z1 = new ComplexNumber(5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(-10.0, 50.0);

        ComplexNumber result = ComplexNumberCalculator.multiply(z1, z2);

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationMultiplicationCalculatorComplexNumberWithNegative() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(-50.0, -10.0);

        ComplexNumber result = ComplexNumberCalculator.multiply(z1, z2);

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationMultiplicationCalculatorComplexNumberWithOneNull() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber();
        ComplexNumber expectedResult = new ComplexNumber();

        ComplexNumber result = ComplexNumberCalculator.multiply(z1, z2);

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationDivisionCalculatorComplexNumber() {
        ComplexNumber z1 = new ComplexNumber(5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(0.9615384615384616, -0.19230769230769232);

        ComplexNumber result = ComplexNumberCalculator.divide(z1, z2);

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationDivisionCalculatorComplexNumberWithNegative() {
        ComplexNumber z1 = new ComplexNumber(5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber(4.0, -6.0);
        ComplexNumber expectedResult = new ComplexNumber(-0.19230769230769232, 0.9615384615384616);

        ComplexNumber result = ComplexNumberCalculator.divide(z1, z2);

        assertEquals(expectedResult, result);
    }

    @Test(expected = ArithmeticException.class)
    public void operationDivisionCalculatorComplexNumberWithNull() throws ArithmeticException {
        ComplexNumber z1 = new ComplexNumber(5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber();

        ComplexNumber result = ComplexNumberCalculator.divide(z1, z2);
    }

    @Test
    public void operationPowCalculatorComplexNumber() {
        ComplexNumber z = new ComplexNumber(1, -Math.sqrt(3));
        ComplexNumber expectedResult = new ComplexNumber(-8.0, 8.0 * Math.sqrt(3));

        ComplexNumber result = ComplexNumberCalculator.pow(z, 4);

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationExtractCalculatorComplexNumber() {
        ComplexNumber z = new ComplexNumber(-1, 0);
        ComplexNumber[] expectedResult = new ComplexNumber[3];
        expectedResult[0] = new ComplexNumber(0.5, Math.sqrt(3) / 2.0);
        expectedResult[1] = new ComplexNumber(-1.0, 0.0);
        expectedResult[2] = new ComplexNumber(0.5, -Math.sqrt(3) / 2.0);

        ComplexNumber[] result = ComplexNumberCalculator.extractRoot(z, 3);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void operationConjugationCalculatorComplexNumber() {
        ComplexNumber z = new ComplexNumber(1, -Math.sqrt(3));
        ComplexNumber expectedResult = new ComplexNumber(1, Math.sqrt(3));

        ComplexNumber result = ComplexNumberCalculator.conjugation(z);

        assertEquals(expectedResult, result);
    }
}
