package ru.unn.agile.fractioncalculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class FractionTest {

    @Test
    public void canCreateFraction() {
        var fraction = new Fraction(1, 2);
        assertNotNull(fraction);
    }

    @Test
    public void canGetNumerator() {
        var fraction = new Fraction(2, 1);
        assertEquals(2, fraction.getNumerator());
    }

    @Test
    public void canGetDenominator() {
        var fraction = new Fraction(2, 1);
        assertEquals(1, fraction.getDenominator());
    }

    @Test
    public void canEquals() {
        var fractionOne = new Fraction(2, 4);
        var fractionTwo = new Fraction(2, 4);
        assertEquals(fractionOne, fractionTwo);
    }

    @Test
    public void canEqualsWithDifferentFractions() {
        var fractionOne = new Fraction(2, 4);
        var fractionTwo = new Fraction(1, 3);
        assertNotEquals(fractionOne, fractionTwo);
    }
}
