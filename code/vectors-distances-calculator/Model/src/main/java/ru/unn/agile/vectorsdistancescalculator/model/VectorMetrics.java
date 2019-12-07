package ru.unn.agile.vectorsdistancescalculator.model;

import java.util.NoSuchElementException;
import java.util.Vector;

public final class VectorMetrics {

    public static double calculateLp(final Vector<Double> vector, final int power) {
        if (power < 1) {
            throw new IllegalArgumentException("Power can't be lower than one");
        }
        return Math.pow(vector.stream()
                     .map(Math::abs)
                     .map(x -> Math.pow(x, power))
                     .reduce((x, y) -> x + y)
                     .get(), 1. / power);
    }

    public static double calculateLInf(final Vector<Double> vector) {
        if (vector.isEmpty()) {
            throw new NoSuchElementException("Vector can't be empty");
        }
        return vector.stream()
                     .map(Math::abs)
                     .reduce(Double.MIN_VALUE, (x, y) -> x < y ? y : x);
    }

    private VectorMetrics() { }
}
