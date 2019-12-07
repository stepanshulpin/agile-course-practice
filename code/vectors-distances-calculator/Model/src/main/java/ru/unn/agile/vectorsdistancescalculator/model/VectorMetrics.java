package ru.unn.agile.vectorsdistancescalculator.model;

import java.util.Vector;

public final class VectorMetrics {

    public static double calculateL1(final Vector<Double> vector) {
        return vector.stream()
                     .map(Math::abs)
                     .reduce((x, y) -> x + y)
                     .get();
    }

    public static double calculateL2(final Vector<Double> vector) {
        return Math.sqrt(vector.stream()
                               .map(Math::abs)
                               .map(x -> x * x)
                               .reduce((x, y) -> x + y)
                               .get());
    }

    private VectorMetrics() { }
}
