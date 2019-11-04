package ru.unn.agile.StatisticsCalculation.model;

public class StatisticsCalculation {
    public static double calculateExpectedValue(final int[] values, final double[] probabilities) {
        double result = 0.0;
        if(values.length == 1){
           result = (double)values[0];
        }
        else if (values.length == 2){
            result =  values[0] * probabilities[0] + values[1]*probabilities[1];
        }
        return result;
    }
}
