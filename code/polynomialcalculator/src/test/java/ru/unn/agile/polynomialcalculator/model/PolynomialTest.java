package ru.unn.agile.polynomialcalculator.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialTest {
    @Test
    public void canInitDefaultPolynomial() {
        var polynomial = new Polynomial();
        assertNotNull(polynomial);
    }

    @Test
    public void defaultPolynomialHasZeroDegree() {
        var polynomial = new Polynomial();
        assertEquals(0, polynomial.getDegree());
    }
}
