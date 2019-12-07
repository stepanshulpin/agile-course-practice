package ru.unn.agile.vectorsdistancescalculator.model;

import java.util.Vector;

public final class VectorMetrics {

    public static double calculateLp(final Vector<Double> vector, final double power) {
        return Math.pow(vector.stream()
                     .map(Math::abs)
                     .map(x -> Math.pow(x, power))
                     .reduce((x, y) -> x + y)
                     .get(), 1. / power);
    }

    public static double calculateLInf(final Vector<Double> vector) {
        return vector.stream()
                     .map(Math::abs)
                     .reduce(Double.MIN_VALUE, (x, y) -> x < y ? y : x);
    }

    private VectorMetrics() { }
}
