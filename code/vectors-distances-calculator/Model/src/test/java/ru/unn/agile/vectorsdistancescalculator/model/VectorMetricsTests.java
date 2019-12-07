package ru.unn.agile.vectorsdistancescalculator.model;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class VectorMetricsTests {

    private static final double EPS = 0.01f;

    @Test
    public void canCalculateL1DistanceOneDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(1.0);
        double expectedL1 = 1.0;
        int power = 1;
        double actualL1 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test
    public void canCalculateL1DistanceTwoDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(1.1);
        vector.add(2.2);
        double expectedL1 = 3.3f;
        int power = 1;
        double actualL1 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test
    public void canCalculateL1DistanceThreeDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(1.1);
        vector.add(2.2);
        vector.add(3.3);
        double expectedL1 = 6.6;
        int power = 1;
        double actualL1 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test
    public void canCalculateL1DistanceWithNegativeValues() {
        Vector<Double> vector = new Vector<>();
        vector.add(-1.1);
        vector.add(2.2);
        vector.add(-3.3);
        double expectedL1 = 6.6;
        int power = 1;
        double actualL1 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test(expected = NoSuchElementException.class)
    public void throwExceptionCalculateLpDistanceEmptyVector() {
        Vector<Double> vector = new Vector<>();
        int power = 1;
        VectorMetrics.calculateLp(vector, power);
    }

    @Test(expected = NullPointerException.class)
    public void throwNPECalculateLpDistanceNullVector() {
        Vector<Double> vector = null;
        int power = 1;
        VectorMetrics.calculateLp(vector, power);
    }

    @Test
    public void canCalculateL2DistanceOneDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(2.0);
        double expectedL2 = 2.0;
        int power = 2;
        double actualL2 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL2, actualL2, EPS);
    }

    @Test
    public void canCalculateL2DistanceTwoDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(2.0);
        vector.add(3.0);
        double sumSquared = 13.0;
        int power = 2;
        double expectedL2 = Math.sqrt(sumSquared);
        double actualL2 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL2, actualL2, EPS);
    }

    @Test
    public void canCalculateL2DistanceThreeDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(2.0);
        vector.add(3.0);
        vector.add(4.0);
        double sumSquared = 29;
        int power = 2;
        double expectedL2 = Math.sqrt(sumSquared);
        double actualL2 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL2, actualL2, EPS);
    }

    @Test
    public void canCalculateL2DistanceWithNegativeValues() {
        Vector<Double> vector = new Vector<>();
        vector.add(-1.0);
        vector.add(3.0);
        vector.add(-4.0);
        double sumSquared = 26;
        int power = 2;
        double expectedL2 = Math.sqrt(sumSquared);
        double actualL2 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL2, actualL2, EPS);
    }


    @Test
    public void canCalculateL3DistanceOneDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(2.0);
        double expectedL3 = 2.0;
        int power = 3;
        double actualL3 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL3, actualL3, EPS);
    }

    @Test
    public void canCalculateL3DistanceTwoDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(2.0);
        vector.add(3.0);
        double sum = 35.0;
        int power = 3;
        double expectedL3 = Math.pow(sum, 1. / 3);
        double actualL3 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL3, actualL3, EPS);
    }

    @Test
    public void canCalculateL3DistanceThreeDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(2.0);
        vector.add(3.0);
        vector.add(4.0);
        double sum = 99;
        int power = 3;
        double expectedL3 = Math.pow(sum, 1. / 3);
        double actualL3 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL3, actualL3, EPS);
    }

    @Test
    public void canCalculateL3DistanceWithNegativeValues() {
        Vector<Double> vector = new Vector<>();
        vector.add(-1.0);
        vector.add(3.0);
        vector.add(-4.0);
        double sum = 92;
        int power = 3;
        double expectedL3 = Math.pow(sum, 1. / 3);
        double actualL3 = VectorMetrics.calculateLp(vector, power);
        assertEquals(expectedL3, actualL3, EPS);
    }

    @Test
    public void canCalculateLInfDistanceOneDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(2.0);
        double expectedLInf = 2.0;
        double actualLInf = VectorMetrics.calculateLInf(vector);
        assertEquals(expectedLInf, actualLInf, EPS);
    }

    @Test
    public void canCalculateLInfDistanceTwoDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(2.0);
        vector.add(3.0);
        double expectedLInf = 3.0;
        double actualLInf = VectorMetrics.calculateLInf(vector);
        assertEquals(expectedLInf, actualLInf, EPS);
    }

    @Test
    public void canCalculateLInfDistanceThreeDimensionalVector() {
        Vector<Double> vector = new Vector<>();
        vector.add(2.0);
        vector.add(3.0);
        vector.add(4.0);
        double expectedLInf = 4.0;
        double actualLInf = VectorMetrics.calculateLInf(vector);
        assertEquals(expectedLInf, actualLInf, EPS);
    }

    @Test
    public void canCalculateLInfDistanceWithNegativeValues() {
        Vector<Double> vector = new Vector<>();
        vector.add(-1.0);
        vector.add(3.0);
        vector.add(-4.0);
        double expectedLInf = 4.0;
        double actualLInf = VectorMetrics.calculateLInf(vector);
        assertEquals(expectedLInf, actualLInf, EPS);
    }

    @Test(expected = NoSuchElementException.class)
    public void throwExceptionCalculateLInfDistanceEmptyVector() {
        Vector<Double> vector = new Vector<>();
        VectorMetrics.calculateLInf(vector);
    }

    @Test(expected = NullPointerException.class)
    public void throwNPECalculateLInfDistanceNullVector() {
        Vector<Double> vector = null;
        VectorMetrics.calculateLInf(vector);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwIAECalculateLpPowerZero() {
        Vector<Double> vector = new Vector<>();
        vector.add(2.0);
        vector.add(3.0);
        vector.add(4.0);
        int power = 0;
        VectorMetrics.calculateLp(vector, power);
    }
}
