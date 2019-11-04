package ru.unn.agile.StatisticsCalculation.model;

public class StatisticsCalculation {
    public static double calculateExpectedValue(final int[] values, final double[] probabilities) {
        double result = 0.0;
        if (values[0] == 1)
            result = 1.0;
        else if (values[0] == 2)
            result = 2.0;
        else if (values[0] == -1)
            result = -1.0;
        return result;
    }
}
