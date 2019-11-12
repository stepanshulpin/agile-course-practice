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
    public void createCalculatorComplexNumberByDefaultCheckZeroNumbers() {
        CalculatorComplexNumber a = new CalculatorComplexNumber();
        ComplexNumber z1 = new ComplexNumber();

        assertEquals(z1, a.getZ1());
    }


}
