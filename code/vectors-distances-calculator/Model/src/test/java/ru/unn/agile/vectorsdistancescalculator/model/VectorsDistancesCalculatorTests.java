package ru.unn.agile.vectorsdistancescalculator.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;


public class VectorsDistancesCalculatorTests {

    private static final double EPS = 0.01f;

    @Test(expected = IllegalArgumentException.class)
    public void throwExceptionIfVectorsHaveDifferentDimensions() {
        List<Double> x = new ArrayList<>(List.of(1.0, 2.0));
        List<Double> y = new ArrayList<>(List.of(1.0));
        int power = 1;
        VectorsDistancesCalculator.calculateLp(x, y, power);
    }

    @Test(expected = NoSuchElementException.class)
    public void throwExceptionIfVectorsEmpty() {
        List<Double> x = new ArrayList<>(List.of(1.0));
        List<Double> y = new ArrayList<>();
        int power = 1;
        VectorsDistancesCalculator.calculateLp(x, y, power);
    }

    @Test(expected = NullPointerException.class)
    public void throwExceptionIfVectorNull() {
        List<Double> x = null;
        List<Double> y = new ArrayList<>();
        int power = 1;
        VectorsDistancesCalculator.calculateLp(x, y, power);
    }

    @Test
    public void canCalculateL1DistancePositiveElems() {
        List<Double> x = new ArrayList<>(List.of(3.0, 2.0));
        List<Double> y = new ArrayList<>(List.of(2.0, 1.0));
        int power = 1;
        double expectedL1 = 2.0;
        double actualL1 = VectorsDistancesCalculator.calculateLp(x, y, power);
        assertEquals(expectedL1, actualL1, EPS);

    }

    @Test
    public void canCalculateL1DistanceMixedElems() {
        List<Double> x = new ArrayList<>(List.of(3.0, -2.0));
        List<Double> y = new ArrayList<>(List.of(-2.0, 1.0));
        int power = 1;
        double expectedL1 = 8.0;
        double actualL1 = VectorsDistancesCalculator.calculateLp(x, y, power);
        assertEquals(expectedL1, actualL1, EPS);
    }

    @Test
    public void canCalculateL2DistancePositiveElems() {
        List<Double> x = new ArrayList<>(List.of(3.0, 2.0));
        List<Double> y = new ArrayList<>(List.of(2.0, 1.0));
        int power = 2;
        double expectedL2 = Math.sqrt(2.0);
        double actualL2 = VectorsDistancesCalculator.calculateLp(x, y, power);
        assertEquals(expectedL2, actualL2, EPS);

    }

    @Test
    public void canCalculateL2DistanceMixedElems() {
        List<Double> x = new ArrayList<>(List.of(3.0, -2.0));
        List<Double> y = new ArrayList<>(List.of(-2.0, 1.0));
        int power = 2;
        double expectedL2 = Math.sqrt(34);
        double actualL2 = VectorsDistancesCalculator.calculateLp(x, y, power);
        assertEquals(expectedL2, actualL2, EPS);
    }



}
