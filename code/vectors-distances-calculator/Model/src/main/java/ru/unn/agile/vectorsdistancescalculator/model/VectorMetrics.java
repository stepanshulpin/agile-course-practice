package ru.unn.agile.vectorsdistancescalculator.model;

import java.util.Vector;

public final class VectorMetrics {

    public static double calculateLp(final Vector<Double> vector, final double power) {
        return Math.pow(vector.stream()
                     .map(Math::abs)
                     .map(x -> Math.pow(x, power))
                     .reduce((x, y) -> x + y)
                     .get(), 1./ power);
    }

    private VectorMetrics() { }
}
