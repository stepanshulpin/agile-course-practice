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

    @Test
    public void canReduceOne2One() {
        var calculator = new FractionCalculator(1, 1);
        assertEquals(new FractionCalculator(1, 1), calculator.reduce());
    }

    @Test
    public void canReduceTen2Ten() {
        var calculator = new FractionCalculator(10, 10);
        assertEquals(new FractionCalculator(1, 1), calculator.reduce());
    }

    @Test
    public void canReduceTwo2Four() {
        var calculator = new FractionCalculator(2, 4);
        assertEquals(new FractionCalculator(1, 2), calculator.reduce());
    }
}
