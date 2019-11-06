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

    @Test(expected = IllegalArgumentException.class)
    public void cannotCreatePolynomialWithNegativeDegree() {
        new Polynomial(0, -1);
    }

    @Test
    public void nonZeroDegreePolynomialWithZeroCoefHasCorrectStringRepr() {
        var polynomial = new Polynomial(0, 3);

        assertEquals("0", polynomial.toString());
    }

    @Test
    public void canCreatePolynomialWithNonZeroCoefAndDegree() {
        var polynomial = new Polynomial(1., 1);

        assertNotNull(polynomial);
    }

}
