package ru.unn.agile.StatisticsCalculation.Model;

import org.junit.Test;
import ru.unn.agile.StatisticsCalculation.model.StatisticsCalculation;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StatisticsCalculationTest {
    private final double delta = 0.001;

    @Test
    public void canCalculateExpectedValueForConstantOne() {
        Integer[] values = {1};
        Double[] probabilities = {1.0};
        Double expectedValue = 1.0;

        Double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForConstantTwo() {
        Integer[] values = {2};
        Double[] probabilities = {1.0};
        Double expectedValue = 2.0;

        Double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForConstantMinusOne() {
        Integer[] values = {-1};
        Double[] probabilities = {1.0};
        Double expectedValue = -1.0;

        Double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForTwoDimValues() {
        Integer[] values = {-1, 3};
        Double[] probabilities = {0.5, 0.5};
        Double expectedValue = 1.0;

        Double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForThreeDimValues() {
        Integer[] values = {-1, 3, 5};
        Double[] probabilities = {0.2, 0.3, 0.5};
        Double expectedValue = 3.2;

        Double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForDouble() {
        Double[] values = {-1.0,  3.0};
        Double[] probabilities = {0.2, 0.8};
        Double expectedValue = 2.2;

        Double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForDoubleAndInteger() {
        Number[] values = {-1.0,  3, 5.0};
        Double[] probabilities = {0.2, 0.4, 0.4};
        Double expectedValue = 3.0;

        Double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    private Number[] createSequentialValues(final int size) {
        Number[] values = new Number[size];
        for (int i = 0; i < size; i++) {
            values[i] = i;
        }
        return values;
    }

    @Test
    public void canCalculateExpectedValueForBigDimValues() {
        Number[] values = createSequentialValues(1000);
        Double[] probabilities = new Double[1000];
        Arrays.fill(probabilities, 0.001);
        Double expectedValue = 499.5;

        Double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateDispersionForConstantOne() {
        Number[] values = {1.0};
        Double[] probabilities = {1.0};
        Double dispersion = 0.0;

        Double realDispersion = StatisticsCalculation.calculateDispersion(values,
                probabilities);

        assertEquals(dispersion, realDispersion, delta);
    }

    @Test
    public void canCalculateDispersionForConstantMinusOne() {
        Number[] values = {-1.0};
        Double[] probabilities = {1.0};
        Double dispersion = 0.0;

        Double realDispersion = StatisticsCalculation.calculateDispersion(values,
                probabilities);

        assertEquals(dispersion, realDispersion, delta);
    }

    @Test
    public void canCalculateDispersionForTwoDimValues1() {
        Number[] values = {-1.0, 4.0};
        Double[] probabilities = {0.7, 0.3};
        Double dispersion = 5.25;

        Double realDispersion = StatisticsCalculation.calculateDispersion(values,
                probabilities);

        assertEquals(dispersion, realDispersion, delta);
    }

    @Test
    public void canCalculateDispersionForTwoDimValues2() {
        Number[] values = {-3.0, 1.0};
        Double[] probabilities = {0.7, 0.3};
        Double dispersion = 3.36;

        Double realDispersion = StatisticsCalculation.calculateDispersion(values,
                probabilities);

        assertEquals(dispersion, realDispersion, delta);
    }

    @Test
    public void canCalculateDispersionForThreeDimValues1() {
        Number[] values = {-3.0, 1.5, 10.0};
        Double[] probabilities = {0.5, 0.2, 0.3};
        Double dispersion = 31.71;

        Double realDispersion = StatisticsCalculation.calculateDispersion(values,
                probabilities);

        assertEquals(dispersion, realDispersion, delta);
    }

    @Test
    public void canCalculateDispersionForThreeDimValues2() {
        Number[] values = {-3.0, -1.5, -1.0};
        Double[] probabilities = {0.1, 0.1, 0.8};
        Double dispersion = 0.3625;

        Double realDispersion = StatisticsCalculation.calculateDispersion(values,
                probabilities);

        assertEquals(dispersion, realDispersion, delta);
    }

    @Test
    public void canCalculateDispersionForFiveDimValues() {
        Number[] values = {-3.0, -1.5, -1.0, 0.0, 1.0};
        Double[] probabilities = {0.1, 0.1, 0.6, 0.1, 0.1};
        Double dispersion = 0.9225;

        Double realDispersion = StatisticsCalculation.calculateDispersion(values,
                probabilities);

        assertEquals(dispersion, realDispersion, delta);
    }

    @Test
    public void canCalculateDispersionForBigDimValues() {
        Number[] values = createSequentialValues(1000);
        Double[] probabilities = new Double[1000];
        Arrays.fill(probabilities, 0.001);
        Double dispersion = 83333.25;

        Double realDispersion = StatisticsCalculation.calculateDispersion(values,
                probabilities);

        assertEquals(dispersion, realDispersion, delta);
    }
}
