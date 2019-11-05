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
        double expectedValue = 1.0;

        double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForConstantTwo() {
        Integer[] values = {2};
        Double[] probabilities = {1.0};
        double expectedValue = 2.0;

        double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForConstantMinusOne() {
        Integer[] values = {-1};
        Double[] probabilities = {1.0};
        double expectedValue = -1.0;

        double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForTwoDimValues() {
        Integer[] values = {-1, 3};
        Double[] probabilities = {0.5, 0.5};
        double expectedValue = 1.0;

        double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForThreeDimValues() {
        Integer[] values = {-1, 3, 5};
        Double[] probabilities = {0.2, 0.3, 0.5};
        double expectedValue = 3.2;

        double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForDouble() {
        Double[] values = {-1.0,  3.0};
        Double[] probabilities = {0.2, 0.8};
        double expectedValue = 2.2;

        double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateExpectedValueForDoubleAndInteger() {
        Number[] values = {-1.0,  3, 5.0};
        Double[] probabilities = {0.2, 0.4, 0.4};
        double expectedValue = 3.0;

        double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
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
        double expectedValue = 499.5;

        double realExpectedValue = StatisticsCalculation.calculateExpectedValue(values,
                probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }

    @Test
    public void canCalculateDispersionForConstantOne() {
        Number[] values = {1.0};
        Double[] probabilities = {1.0};
        double dispersion = 0.0;

        double realDispersion = StatisticsCalculation.calculateDispersion(values,
                probabilities);

        assertEquals(dispersion, realDispersion, delta);
    }

    @Test
    public void canCalculateDispersionForConstantMinusOne() {
        Number[] values = {-1.0};
        Double[] probabilities = {1.0};
        double dispersion = 0.0;

        double realDispersion = StatisticsCalculation.calculateDispersion(values,
                probabilities);

        assertEquals(dispersion, realDispersion, delta);
    }

    @Test
    public void canCalculateDispersionForTwoDimValues() {
        Number[] values = {-1.0, 4.0};
        Double[] probabilities = {0.7, 0.3};
        double dispersion = 5.25;

        double realDispersion = StatisticsCalculation.calculateDispersion(values,
                probabilities);

        assertEquals(dispersion, realDispersion, delta);
    }
}
