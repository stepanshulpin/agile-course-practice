package ru.unn.agile.fractioncalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionCalculatorTest {

    @Test
    public void canCreateFractionCalculator() {
        var calculator = new FractionCalculator(new Fraction(1, 1));
        assertNotNull(calculator);
    }

    @Test
    public void canGetFraction() {
        var calculator = new FractionCalculator(new Fraction(10, 2));
        assertEquals(new Fraction(10, 2), calculator.getFraction());
    }

    @Test
    public void canReduceOne2One() {
        var calculator = new FractionCalculator(new Fraction(1, 1));
        assertEquals(new Fraction(1, 1), calculator.reduce());
    }

    @Test
    public void canReduceTen2Ten() {
        var calculator = new FractionCalculator(new Fraction(10, 10));
        assertEquals(new Fraction(1, 1), calculator.reduce());
    }

    @Test
    public void canReduceTwo2Four() {
        var calculator = new FractionCalculator(new Fraction(2, 4));
        assertEquals(new Fraction(1, 2), calculator.reduce());
    }

    @Test
    public void canReduceMinusFour2Two() {
        var calculator = new FractionCalculator(new Fraction(-4, 2));
        assertEquals(new Fraction(-2, 1), calculator.reduce());
    }

    @Test
    public void canReduceFractionWithNegativeNumbers() {
        var calculator = new FractionCalculator(new Fraction(-2, -4));
        assertEquals(new Fraction(1, 2), calculator.reduce());
    }


}
