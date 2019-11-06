package ru.unn.agile.polynomialcalculator.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PolynomialTest {

    private double delta = 1e-3;

    @Test
    public void canInitZeroPolynomial() {
        var polynomial = new Polynomial(0, 0);
        assertNotNull(polynomial);
    }

    @Test
    public void zeroPolynomialHasZeroDegree() {
        var polynomial = new Polynomial(0,0);
        assertEquals(0, polynomial.getDegree());
    }

    @Test
    public void zeroPolynomialHasZeroCoef() {
        var polynomial = new Polynomial(0,0);
        var degree = polynomial.getDegree();

        assertEquals(0, polynomial.getCoef(degree), delta);
    }

    @Test
    public void zeroPolynomialHasCorrectStringRepr() {
        var polynomial = new Polynomial(0,0);

        assertEquals("0", polynomial.toString());
    }
}
