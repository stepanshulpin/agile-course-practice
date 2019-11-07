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
    public void canMultiplePositiveAndNegative() {
        var firstFraction = new Fraction(-2, 3);
        var secondFraction = new Fraction(3, 2);
        assertEquals(
                new Fraction(6, -6),
                FractionCalculator.multiple(firstFraction, secondFraction)
        );
    }

    @Test
    public void canMultipleNegatives() {
        var firstFraction = new Fraction(-2, 3);
        var secondFraction = new Fraction(3, -2);
        assertEquals(
                new Fraction(6, 6),
                FractionCalculator.multiple(firstFraction, secondFraction)
        );
    }

    @Test
    public void canDivide() {
        var firstFraction = new Fraction(14, 3);
        var secondFraction = new Fraction(5, 9);

        assertEquals(
                new Fraction(42, 5),
                FractionCalculator.divide(firstFraction, secondFraction)
        );
    }

    @Test
    public void canSum() {
        var firstFraction = new Fraction(5, 3);
        var secondFraction = new Fraction(2, 5);
        assertEquals(
                new Fraction(31, 15),
                FractionCalculator.sum(firstFraction, secondFraction)
        );
    }

    @Test
    public void canMinus() {
        var firstFraction = new Fraction(3, 4);
        var secondFraction = new Fraction(5, 6);
        assertEquals(
                new Fraction(-1, 12),
                FractionCalculator.minus(firstFraction, secondFraction)
        );
    }
}
