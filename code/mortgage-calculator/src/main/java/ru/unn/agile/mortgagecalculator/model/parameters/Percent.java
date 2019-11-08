package ru.unn.agile.mortgagecalculator.model.parameters;

public class Percent {

    private final double FRACTION_OF_HUNDRED = 0.01;

    private double percent;
    private double fractionPercent;

    public Percent(double percent) {
        this.percent = percent;
        this.fractionPercent = convertToFractionPercent(percent);
    }

    public double getPercent() {
        return fractionPercent;
    }

    private double convertToFractionPercent(double percent) {
        return percent * FRACTION_OF_HUNDRED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Percent percent1 = (Percent) o;

        if (Double.compare(percent1.percent, percent) != 0) return false;
        return Double.compare(percent1.fractionPercent, fractionPercent) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(percent);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(fractionPercent);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
