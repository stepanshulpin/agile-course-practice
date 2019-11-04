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

    private static void checkArraysSize(final Number[] values, final Double[] probabilities){
        if (values.length != probabilities.length) {
            throw new IllegalArgumentException("Values and probabilities arrays should have the same dimension!");
        }
    }

    public static double calculateExpectedValue(final Number[] values, final Double[] probabilities) {
        checkArraysInitialization(values);
        checkArraysInitialization(probabilities);
        checkArraysSize(values, probabilities);
        Double result = 0.0;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == null) throw new IllegalArgumentException("Array should be initialized!");
            if (probabilities[i] == null) throw new IllegalArgumentException("Array should be initialized!");
            result += values[i].doubleValue() * probabilities[i];
        }
        return result;
    }
}
