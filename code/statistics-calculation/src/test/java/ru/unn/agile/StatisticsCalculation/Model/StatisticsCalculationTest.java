package ru.unn.agile.StatisticsCalculation.Model;

import org.junit.Test;
import ru.unn.agile.StatisticsCalculation.model.StatisticsCalculation;

import static org.junit.Assert.*;

public class StatisticsCalculationTest {
    private final double delta = 0.001;

    @Test
    public void canCalculateExpectedValueForConstantOne() {
        int[] values = {1};
        double[] probabilities = {1.0};
        StatisticsCalculation calculator = new StatisticsCalculation();
        double expectedValue = 1.0;

        double realExpectedValue = calculator.calculateExpectedValue (values, probabilities);

        assertEquals(expectedValue, realExpectedValue, delta);
    }
}
