package ru.unn.agile.vectorsdistancescalculator.model;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public final class VectorsDistancesCalculator {

    public static double calculateLp(final List<Double> x,
                                     final List<Double> y, final int power) {
        if (x == null || y == null) {
            throw new NullPointerException("Vector(s) can't be null");
        }
        if (x.isEmpty() || y.isEmpty()) {
            throw new NoSuchElementException("Vector(s) can't be empty");
        }
        if (x.size() != y.size()) {
            throw new IllegalArgumentException("Vectors must have same dimension");
        }
        List<Double> dif = calculateVectorsDifference(x, y);
        return VectorMetrics.calculateLp(dif, power);
    }

    private static List<Double> calculateVectorsDifference(final List<Double> x, final List<Double> y) {
        List<Double> dif = new ArrayList<>();
        for (int i = 0; i < x.size(); ++i) {
            dif.add(y.get(i) - x.get(i));
        }
        return dif;
    }

    private VectorsDistancesCalculator() { }

}
