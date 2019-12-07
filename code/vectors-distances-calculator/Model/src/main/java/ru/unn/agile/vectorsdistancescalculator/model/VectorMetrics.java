package ru.unn.agile.vectorsdistancescalculator.model;

import java.util.Vector;

public final class VectorMetrics {

    public static float calculateL1(final Vector<Float> vector) {
        return vector.stream().map(Math::abs).reduce((x, y) -> x + y).get();
    }


    private VectorMetrics() { }
}
