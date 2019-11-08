package ru.unn.agile.mortgagecalculator.model.parameters;

import static ru.unn.agile.mortgagecalculator.model.Constants.HASH_CODE_CONST_31;
import static ru.unn.agile.mortgagecalculator.model.Constants.HASH_CODE_CONST_32;

public class Percent {

    private static final double FRACTION_OF_HUNDRED = 0.01;

    private double percent;
    private double fractionPercent;

    public Percent(final double percent) {
        this.percent = percent;
        this.fractionPercent = convertToFractionPercent(percent);
    }

    public double getValue() {
        return fractionPercent;
    }

    private double convertToFractionPercent(final double percent) {
        return percent * FRACTION_OF_HUNDRED;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Percent percent1 = (Percent) o;

        if (Double.compare(percent1.percent, percent) != 0) {
            return false;
        }
        return Double.compare(percent1.fractionPercent, fractionPercent) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(percent);
        result = (int) (temp ^ (temp >>> HASH_CODE_CONST_32));
        temp = Double.doubleToLongBits(fractionPercent);
        result = HASH_CODE_CONST_31 * result + (int) (temp ^ (temp >>> HASH_CODE_CONST_32));
        return result;
    }
}
