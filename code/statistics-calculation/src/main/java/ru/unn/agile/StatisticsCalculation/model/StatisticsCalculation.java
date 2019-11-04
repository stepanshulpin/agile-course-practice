package ru.unn.agile.StatisticsCalculation.model;

public class StatisticsCalculation {
    private static void checkArraysInitialization(final Number[] array){
        if (array == null) {
            throw new IllegalArgumentException("Array should be initialized!");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array should be initialized!");
        }
    }

    public static double calculateExpectedValue(final Number[] values, final Double[] probabilities) {
        checkArraysInitialization(values);
        checkArraysInitialization(probabilities);
        Double result = 0.0;
        for (int i = 0; i < values.length; i++) {
            result += values[i].doubleValue() * probabilities[i];
        }
        return result;
    }
}
