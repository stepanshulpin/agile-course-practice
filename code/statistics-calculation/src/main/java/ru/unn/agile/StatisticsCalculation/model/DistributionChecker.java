package ru.unn.agile.StatisticsCalculation.model;

public class DistributionChecker {
    public static void validate(final Number[] values,final Double[] probabilities) {
        checkArraysInitialization(values);
        checkArraysInitialization(probabilities);
        checkArraysSize(values, probabilities);
        checkProbability(probabilities);
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

    private static void checkProbability(final Double[] probabilities){
        Double min = 0.0;
        for (int i=0;i<probabilities.length;i++){
            if (probabilities[i]<min)
                throw new IllegalArgumentException("Probability should be more than 0.0!");
        }
    }
}
