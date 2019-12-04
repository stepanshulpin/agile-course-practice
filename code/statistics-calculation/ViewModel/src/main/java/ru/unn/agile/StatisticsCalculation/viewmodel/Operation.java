package ru.unn.agile.StatisticsCalculation.viewmodel;

import ru.unn.agile.StatisticsCalculation.model.DiscreteRandomVariable;
import ru.unn.agile.StatisticsCalculation.model.StatisticsCalculation;

public enum Operation {
    EXPECTED_VALUE("Calculate expected value") {
        public Double apply(final DiscreteRandomVariable drv, Integer ... params) {
            return StatisticsCalculation.calculateExpectedValue(drv);
        }
    },
    DISPERSION("Calculate dispersion") {
        public Double apply(final DiscreteRandomVariable drv, Integer ... params) {
            return StatisticsCalculation.calculateDispersion(drv);
        }
    },
    RAW_MOMENT("Calculate raw moment") {
        public Double apply(final DiscreteRandomVariable drv, Integer ... params) {
            return StatisticsCalculation.calculateRawMoment(drv, params[0]);
        }
    },
    CENTRAL_MOMENT("Calculate central moment") {
        public Double apply(final DiscreteRandomVariable drv, Integer ... params) {
            return StatisticsCalculation.calculateCentralMoment(drv, params[0]);
        }
    };

    private final String name;
    Operation(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public abstract Double apply(DiscreteRandomVariable drv, Integer ... params);
}
