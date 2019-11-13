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




}
