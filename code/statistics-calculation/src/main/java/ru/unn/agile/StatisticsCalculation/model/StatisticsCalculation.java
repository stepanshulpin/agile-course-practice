package ru.unn.agile.StatisticsCalculation.model;

public class StatisticsCalculation {
    public static double calculateExpectedValue(final int[] values, final double[] probabilities) {
        double result = 0.0;
        for (int i = 0; i < values.length; i++) {
            result += values[i] * probabilities[i];
        }
        return result;
    }
}
