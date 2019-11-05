package ru.unn.agile.StatisticsCalculation.model;

public final class StatisticsCalculation {
    public static Double calculateExpectedValue(final Number[] values,
                                                final Double[] probabilities) {
        return calculateRawMoment(values, probabilities, 1);
    }

    public static Double calculateDispersion(final Number[] values,
                                             final Double[] probabilities) {
        return calculateCentralMoment(values, probabilities, 2);
    }

    public static Double calculateRawMoment(final Number[] values,
                                                 final Double[] probabilities, final Integer order) {

        return calculateMoment(values, probabilities, order, 0.0);
    }

    public static Double calculateCentralMoment(final Number[] values,
                                            final Double[] probabilities, final Integer order) {
        MomentOrderChecker.checkOrder(order);
        Double expectedValue = calculateExpectedValue(values, probabilities);
        Double result = 0.0;
        for (int i = 0; i < values.length; i++) {
            result += probabilities[i] * Math.pow((values[i].doubleValue() - expectedValue), order);
        }
        return result;
    }

    private static Double calculateMoment(final Number[] values,
                                          final Double[] probabilities,
                                          final Integer order, final Double offset) {
        DistributionChecker.validate(values, probabilities);
        MomentOrderChecker.checkOrder(order);
        Double result = 0.0;
        for (int i = 0; i < values.length; i++) {
            result += probabilities[i] * Math.pow((values[i].doubleValue() - offset.doubleValue()), order);
        }
        return result;
    }

    private StatisticsCalculation() { }
}
