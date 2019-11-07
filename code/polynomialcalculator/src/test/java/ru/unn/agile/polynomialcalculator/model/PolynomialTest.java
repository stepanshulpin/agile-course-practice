package ru.unn.agile.polynomialcalculator.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PolynomialTest {

    private double delta = 1e-3;

    @Test
    public void canInitZeroPolynomial() {
        var polynomial = new Polynomial(0, 0);
        assertNotNull(polynomial);
    }

    @Test
    public void zeroPolynomialHasZeroDegree() {
        var polynomial = new Polynomial(0, 0);
        assertEquals(0, polynomial.getDegree());
    }

    @Test
    public void zeroPolynomialHasZeroCoef() {
        var polynomial = new Polynomial(0, 0);
        var degree = polynomial.getDegree();

        assertEquals(0, polynomial.getCoef(degree), delta);
    }

    @Test
    public void zeroPolynomialHasCorrectStringRepr() {
        var polynomial = new Polynomial(0, 0);

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
    public void zeroDegreePolynomialWithNonZeroCoefHasCorrectStringRepr() {
        var polynomial = new Polynomial(3, 0);

        assertEquals("3.0", polynomial.toString());
    }

    @Test
    public void canCreatePolynomialWithNonZeroCoefAndDegree() {
        var polynomial = new Polynomial(1., 1);

        assertNotNull(polynomial);
    }

    @Test
    public void nonZeroPolynomialHasCorrectDegree() {
        var polynomial = new Polynomial(1., 1);

        assertEquals(1, polynomial.getDegree());
    }

    @Test
    public void nonZeroPolynomialHasCorrectCoef() {
        var polynomial = new Polynomial(1., 1);
        var degree = polynomial.getDegree();

        assertEquals(1., polynomial.getCoef(degree), delta);
    }

    @Test
    public void nonZeroPolynomialHasCorrectStringRepr() {
        var polynomial = new Polynomial(2.3, 2);

        assertEquals("2.3x^2", polynomial.toString());
    }

    @Test
    public void stringReprOfFirstDegreePolynomialOmitsDegreeSign() {
        var polynomial = new Polynomial(1.5, 1);

        assertEquals("1.5x", polynomial.toString());
    }

    @Test
    public void stringReprOfContainMinusSignWithNegativeCoef() {
        var polynomial = new Polynomial(-2.3, 2);

        assertEquals("- 2.3x^2", polynomial.toString());
    }

    @Test
    public void sumOfPolynomialsIsNotNull() {
        var p1 = new Polynomial(1.1, 2);
        var p2 = new Polynomial(1.4, 3);

        var p3 = p1.plus(p2);

        assertNotNull(p3);
    }

    @Test
    public void sumProducesCorrectCoefs() {
        var p1 = new Polynomial(1.1, 1);
        var p2 = new Polynomial(1.4, 1);

        var p3 = p1.plus(p2);

        assertEquals(2.5, p3.getCoef(1), delta);
    }

}
