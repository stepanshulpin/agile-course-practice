package ru.unn.agile.polynomialcalculator.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialTest {

    private double delta = 1e-3;

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

    @Test
    public void defaultPolynomialEqualsZero() {
        var polynomial = new Polynomial();
        var degree = polynomial.getDegree();

        assertEquals(0, polynomial.getValue(degree), delta);
    }
}
