package ru.unn.agile.vectorsdistancescalculator.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class VectorsDistancesCalculatorTests {

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



}
