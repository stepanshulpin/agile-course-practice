package ru.unn.agile.StatisticsCalculation.model;

public class MomentOrderChecker {
    public static void checkOrder(final Integer order) {
        if (order == null) {
            throw new IllegalArgumentException("Raw moment order should not be null!");
        }
        if (order <= 0) {
            throw new IllegalArgumentException("Raw moment order should be more than 0");
        }
    }

    private MomentOrderChecker() { }
}
