package ru.unn.agile.StatisticsCalculation.model;

public class DistributionChecker {
    public static void validate(final Number[] values,final Double[] probabilities) {
        checkArraysInitialization(values);
        checkArraysInitialization(probabilities);
        checkArraysSize(values, probabilities);
    }

    private static void checkArraysInitialization(final Number[] array){
        if (array == null) {
            throw new IllegalArgumentException("Array should be initialized!");
        }
        if (array.length == 0) {
            throw new IllegalArgumentException("Array should be initialized!");
        }
        for (int i = 0; i< array.length;i++){
            if (array[i] == null) throw new IllegalArgumentException("Array should be initialized!");
        }
    }

    private static void checkArraysSize(final Number[] values, final Double[] probabilities){
        if (values.length != probabilities.length) {
            throw new IllegalArgumentException("Values and probabilities arrays should have the same dimension!");
        }
    }
}
