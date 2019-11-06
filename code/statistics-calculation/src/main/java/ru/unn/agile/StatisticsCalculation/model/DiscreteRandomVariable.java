package ru.unn.agile.StatisticsCalculation.model;

public class DiscreteRandomVariable {
    private Number[] values;
    private Double[] probabilities;

    public DiscreteRandomVariable(final Number[] values, final Double[] probabilities) {
        this.values = values;
        this.probabilities = probabilities;
    }
}
