package ru.unn.agile.fractioncalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionCalculatorTest {

    @Test
    public void canCreateFractionCalculator() {
        var calculator = new FractionCalculator(1, 2);
        assertNotNull(calculator);
    }

    @Test
    public void canGetNumerator() {
        var calculator = new FractionCalculator(2, 1);
        assertEquals(2, calculator.getNumerator());
    }

    @Test
    public void canGetDenominator() {
        var calculator = new FractionCalculator(2, 1);
        assertEquals(1, calculator.getDenominator());
    }
}
