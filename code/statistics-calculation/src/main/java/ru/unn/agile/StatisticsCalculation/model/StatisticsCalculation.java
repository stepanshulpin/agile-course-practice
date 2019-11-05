package ru.unn.agile.StatisticsCalculation.model;

public final class StatisticsCalculation {
    public static Double calculateExpectedValue(final Number[] values,
                                                final Double[] probabilities) {
        return calculateRawMoment(values, probabilities, 1);
    }

    public static Double calculateDispersion(final Number[] values,
                                             final Double[] probabilities) {
        Double result = 0.0;
        Double expectedValue = calculateExpectedValue(values, probabilities);
        for (int i = 0; i < values.length; i++) {
            result += probabilities[i] * Math.pow((values[i].doubleValue() - expectedValue), 2);
        }
        return result;
    }

    public static Double calculateRawMoment(final Number[] values,
                                                 final Double[] probabilities, final Integer order) {

        DistributionChecker.validate(values, probabilities);
        MomentOrderChecker.checkOrder(order);
        Double result = 0.0;
        for (int i = 0; i < values.length; i++) {
            result += probabilities[i] * Math.pow((values[i].doubleValue()), order);
        }
        return result;
    }

    public static Double calculateCentralMoment(final Number[] values,
                                            final Double[] probabilities, final Integer order) {
        if (order == 2 )
        {
            return calculateDispersion(values, probabilities);
        }
        else {
            Double expectedValue = calculateExpectedValue(values, probabilities);
            Double result = 0.0;
            for (int i = 0; i < values.length; i++) {
                result += probabilities[i] * (values[i].doubleValue() - expectedValue);
            }
            return result;
        }
    }

    private StatisticsCalculation() { }
}
