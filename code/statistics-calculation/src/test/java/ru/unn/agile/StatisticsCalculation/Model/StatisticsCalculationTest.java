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

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenCalculateExpectedValueForIncorrectDistribution() {
        Integer[] values = {1, 2, 3, 4};
        Double[] probabilities = {0.1, 0.3, 0.1};

        StatisticsCalculation.calculateExpectedValue(values, probabilities);
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

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenCalculateDispersionForIncorrectDistribution() {
        Integer[] values = {1, 2, 3};
        Double[] probabilities = {0.1, 1.3, 0.1};

        StatisticsCalculation.calculateDispersion(values, probabilities);
    }

    @Test
    public void canCalculateFirstOrderRawMoment() {
        Number[] values = {1.0, 5.0};
        Double[] probabilities = {0.5, 0.5};
        Integer order = 1;
        Double rawMoment = 3.0;

        Double realRawMoment = StatisticsCalculation.calculateRawMoment(values,
                probabilities, order);

        assertEquals(rawMoment, realRawMoment, delta);
    }

    @Test
    public void canCalculateSecondOrderRawMoment() {
        Number[] values = {1.0, 5.0};
        Double[] probabilities = {0.5, 0.5};
        Integer order = 2;
        Double rawMoment = 13.0;

        Double realRawMoment = StatisticsCalculation.calculateRawMoment(values,
                probabilities, order);

        assertEquals(rawMoment, realRawMoment, delta);
    }

    @Test
    public void canCalculateThirdOrderRawMoment() {
        Number[] values = {1.0, 5.0};
        Double[] probabilities = {0.5, 0.5};
        Integer order = 3;
        Double rawMoment = 63.0;

        Double realRawMoment = StatisticsCalculation.calculateRawMoment(values,
                probabilities, order);

        assertEquals(rawMoment, realRawMoment, delta);
    }

    @Test
    public void canCalculateBigOrderRawMoment() {
        Number[] values = {1.0, 5.0};
        Double[] probabilities = {0.5, 0.5};
        Integer order = 10;
        Double rawMoment = 4882813.0;

        Double realRawMoment = StatisticsCalculation.calculateRawMoment(values,
                probabilities, order);

        assertEquals(rawMoment, realRawMoment, delta);
    }

    @Test
    public void canCalculateSecondOrderRawMomentForBigDist() {
        Number[] values = createSequentialValues(1000);
        Double[] probabilities = new Double[1000];
        Arrays.fill(probabilities, 0.001);
        Integer order = 2;
        Double rawMoment = 332833.5;

        Double realRawMoment = StatisticsCalculation.calculateRawMoment(values,
                probabilities, order);

        assertEquals(rawMoment, realRawMoment, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenCalculateRawMomentWithIncorrectOrder() {
        Integer[] values = {1, 2, 3};
        Double[] probabilities = {0.1, 0.8, 0.1};
        Integer order = -1;

        StatisticsCalculation.calculateRawMoment(values, probabilities, order);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenCalculateRawMomentForIncorrectDistribution() {
        Integer[] values = {1, 2, 3};
        Double[] probabilities = {-0.1, 1.0, 0.1};
        Integer order = 2;

        StatisticsCalculation.calculateRawMoment(values, probabilities, order);
    }

    @Test
    public void canCalculateFirstOrderCentralMoment() {
        Number[] values = {1.0, 5.0};
        Double[] probabilities = {0.5, 0.5};
        Integer order = 1;
        Double centralMoment = 0.0;

        Double realCentralMoment = StatisticsCalculation.calculateCentralMoment(values,
                probabilities, order);

        assertEquals(centralMoment, realCentralMoment, delta);
    }

    @Test
    public void canCalculateSecondOrderCentralMoment() {
        Number[] values = {1.0, 5.0};
        Double[] probabilities = {0.5, 0.5};
        Integer order = 2;
        Double centralMoment = 4.0;

        Double realCentralMoment = StatisticsCalculation.calculateCentralMoment(values,
                probabilities, order);

        assertEquals(centralMoment, realCentralMoment, delta);
    }

    @Test
    public void canCalculateThirdOrderCentralMoment() {
        Number[] values = {1.0, 5.0};
        Double[] probabilities = {0.4, 0.6};
        Integer order = 3;
        Double centralMoment = -3.072;

        Double realCentralMoment = StatisticsCalculation.calculateCentralMoment(values,
                probabilities, order);

        assertEquals(centralMoment, realCentralMoment, delta);
    }

    @Test
    public void canCalculateBigOrderCentralMoment() {
        Number[] values = {1.0, 5.0};
        Double[] probabilities = {0.4, 0.6};
        Integer order = 16;
        Double centralMoment = 485769.796;

        Double realCentralMoment = StatisticsCalculation.calculateCentralMoment(values,
                probabilities, order);

        assertEquals(centralMoment, realCentralMoment, delta);
    }

    @Test
    public void canCalculateFourthOrderCentralMomentForBigDist() {
        Number[] values = createSequentialValues(1000);
        Double[] probabilities = new Double[1000];
        Arrays.fill(probabilities, 0.001);
        Integer order = 4;
        Double centralMoment = 12499958333.3625;

        Double realCentralMoment = StatisticsCalculation.calculateCentralMoment(values,
                probabilities, order);

        assertEquals(centralMoment, realCentralMoment, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenCalculateCentralMomentWithIncorrectOrder() {
        Integer[] values = {1, 2, 3};
        Double[] probabilities = {0.1, 0.8, 0.1};
        Integer order = 0;

        StatisticsCalculation.calculateCentralMoment(values, probabilities, order);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenCalculateCentralMomentForIncorrectDistribution() {
        Integer[] values = {1, 2, 3};
        Double[] probabilities = {0.1, 0.9};
        Integer order = 2;

        StatisticsCalculation.calculateCentralMoment(values, probabilities, order);
    }
}
