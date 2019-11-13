package ru.unn.agile.complexnumbercalculation.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorComplexNumberTest {
    @Test
    public void createCalculatorComplexNumberByDefaultNotNull() {
        CalculatorComplexNumber a = new CalculatorComplexNumber();

        assertNotNull(a);
    }

    @Test
    public void createCalculatorComplexNumberByDefaultCheckZeroNumbers1() {
        CalculatorComplexNumber a = new CalculatorComplexNumber();
        ComplexNumber z1 = new ComplexNumber();

        assertEquals(z1, a.getZ1());
    }

    @Test
    public void createCalculatorComplexNumberByDefaultCheckZeroNumbers2() {
        CalculatorComplexNumber a = new CalculatorComplexNumber();
        ComplexNumber z1 = new ComplexNumber();

        assertEquals(z1, a.getZ2());
    }

    @Test
    public void createCalculatorComplexNumberByComplexNumbersNotNull() {
        ComplexNumber z1 = new ComplexNumber(5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        assertNotNull(a);
    }

    @Test
    public void createCalculatorComplexNumberByComplexNumbersCheck1() {
        ComplexNumber z1 = new ComplexNumber(5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        assertEquals(z1, a.getZ1());
    }

    @Test
    public void createCalculatorComplexNumberByComplexNumbersCheck2() {
        ComplexNumber z1 = new ComplexNumber(5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        assertEquals(z2, a.getZ2());
    }

    @Test
    public void operationAdditionalCalculatorComplexNumber() {
        ComplexNumber z1 = new ComplexNumber(5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(9.0, 12.0);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.addition();

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationAdditionalCalculatorComplexNumberWithNegative() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(-1.0, 12.0);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.addition();

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationAdditionalCalculatorComplexNumberWithOneNull() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber();
        ComplexNumber expectedResult = new ComplexNumber(-5.0, 6.0);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.addition();

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationSubtractionCalculatorComplexNumber() {
        ComplexNumber z1 = new ComplexNumber(5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(1.0, -1.0);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.subtraction();

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationSubtractionCalculatorComplexNumberWithNegative() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(-9.0, 0.0);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.subtraction();

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationSubtractionCalculatorComplexNumberWithOneNull() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber();
        ComplexNumber expectedResult = new ComplexNumber(-5.0, 6.0);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.subtraction();

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationMultiplicationCalculatorComplexNumber() {
        ComplexNumber z1 = new ComplexNumber(5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(-10.0, 50.0);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.multiplication();

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationMultiplicationCalculatorComplexNumberWithNegative() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(-50.0, -10.0);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.multiplication();

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationMultiplicationCalculatorComplexNumberWithOneNull() {
        ComplexNumber z1 = new ComplexNumber(-5.0, 6.0);
        ComplexNumber z2 = new ComplexNumber();
        ComplexNumber expectedResult = new ComplexNumber();
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.multiplication();

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationDivisionCalculatorComplexNumber() {
        ComplexNumber z1 = new ComplexNumber(5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber(4.0, 6.0);
        ComplexNumber expectedResult = new ComplexNumber(0.9615384615384616, -0.19230769230769232);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.division();

        assertEquals(expectedResult, result);
    }

    @Test
    public void operationDivisionCalculatorComplexNumberWithNegative() {
        ComplexNumber z1 = new ComplexNumber(5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber(4.0, -6.0);
        ComplexNumber expectedResult = new ComplexNumber(-0.19230769230769232, 0.9615384615384616);
        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.division();

        assertEquals(expectedResult, result);
    }

    @Test(expected = ArithmeticException.class)
    public void operationDivisionCalculatorComplexNumberWithNull() throws ArithmeticException {
        ComplexNumber z1 = new ComplexNumber(5.0, 5.0);
        ComplexNumber z2 = new ComplexNumber();

        CalculatorComplexNumber a = new CalculatorComplexNumber(z1, z2);

        ComplexNumber result = a.division();
    }
}
