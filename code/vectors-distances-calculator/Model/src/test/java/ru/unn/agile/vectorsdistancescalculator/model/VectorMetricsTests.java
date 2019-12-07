package ru.unn.agile.vectorsdistancescalculator.model;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class VectorMetricsTests {

    private static final float EPS = 0.01f;

    @Test
    public void canCalculateL1DistanceOneDimensionalVector() {
        Vector<Float> vector = new Vector<>();
        vector.add(1.0f);
        float expectedL1 = 1.0f;
        float actualL1 = VectorMetrics.calculateL1(vector);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test
    public void canCalculateL1DistanceTwoDimensionalVector() {
        Vector<Float> vector = new Vector<>();
        vector.add(1.1f);
        vector.add(2.2f);
        float expectedL1 = 3.3f;
        float actualL1 = VectorMetrics.calculateL1(vector);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test
    public void canCalculateL1DistanceThreeDimensionalVector() {
        Vector<Float> vector = new Vector<>();
        vector.add(1.1f);
        vector.add(2.2f);
        vector.add(3.3f);
        float expectedL1 = 6.6f;
        float actualL1 = VectorMetrics.calculateL1(vector);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test(expected = NoSuchElementException.class)
    public void throwExceptionCalculateL1DistanceEmptyVector() {
        Vector<Float> vector = new Vector<>();
        VectorMetrics.calculateL1(vector);
    }

    @Test(expected = NullPointerException.class)
    public void throwNPECalculateL1DistanceNullVector() {
        Vector<Float> vector = null;
        VectorMetrics.calculateL1(vector);
    }

}
