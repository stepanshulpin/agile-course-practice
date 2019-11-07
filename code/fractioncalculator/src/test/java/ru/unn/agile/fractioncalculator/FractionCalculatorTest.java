package ru.unn.agile.fractioncalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionCalculatorTest {

    @Test
    public void canReduceOne2One() {
        var reduced = FractionCalculator.reduce(new Fraction(1, 1));
        assertEquals(new Fraction(1, 1), reduced);
    }

    @Test
    public void canReduceTen2Ten() {
        var reduced = FractionCalculator.reduce(new Fraction(10, 10));
        assertEquals(new Fraction(1, 1), reduced);
    }

    @Test
    public void canReduceTwo2Four() {
        var reduced = FractionCalculator.reduce(new Fraction(2, 4));
        assertEquals(new Fraction(1, 2), reduced);
    }

    @Test
    public void canReduceMinusFour2Two() {
        var reduced = FractionCalculator.reduce(new Fraction(-4, 2));
        assertEquals(new Fraction(-2, 1), reduced);
    }

    @Test
    public void canReduceFractionWithNegativeNumbers() {
        var reduced = FractionCalculator.reduce(new Fraction(-2, -4));
        assertEquals(new Fraction(1, 2), reduced);
    }

    @Test
    public void canMultiple() {
        var firstFraction = new Fraction(2, 3);
        var secondFraction = new Fraction(3, 2);
        assertEquals(
                new Fraction(6, 6),
                FractionCalculator.multiple(firstFraction, secondFraction)
        );
    }

    @Test
    public void canMultipleWithReduce() {
        var firstFraction = new Fraction(10, 3);
        var secondFraction = new Fraction(6, 2);
        assertEquals(
                new Fraction(10, 1),
                FractionCalculator.multipleWithReduce(firstFraction, secondFraction)
        );
    }
}
