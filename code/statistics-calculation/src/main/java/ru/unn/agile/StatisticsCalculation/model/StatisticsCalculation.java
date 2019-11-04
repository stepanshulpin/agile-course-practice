package ru.unn.agile.StatisticsCalculation.model;

public class StatisticsCalculation {
    public static double calculateExpectedValue(final Number[] values, final double[] probabilities) {
        if (values == null) {
            throw new IllegalArgumentException("Values array should be initialized!");
        }
        if (probabilities == null) {
            throw new IllegalArgumentException("Probabilities array should be initialized!");
        }
        if (values.length ==0 ) {
            throw new IllegalArgumentException("Values array should be initialized!");
        }
        if (probabilities.length ==0 ) {
            throw new IllegalArgumentException("Values array should be initialized!");
        }
        Double result = 0.0;
        for (int i = 0; i < values.length; i++) {
            result += values[i].doubleValue() * probabilities[i];
        }
        return result;
    }
}
