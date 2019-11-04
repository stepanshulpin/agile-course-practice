package ru.unn.agile.StatisticsCalculation.model;

public class StatisticsCalculation {
    public static double calculateExpectedValue(final Number[] values, final double[] probabilities) {
        Double result = 0.0;
        for (int i = 0; i < values.length; i++) {
            result += values[i].doubleValue() * probabilities[i];
        }
        return result;
    }
}
