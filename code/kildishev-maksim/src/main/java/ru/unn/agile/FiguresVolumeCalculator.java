package ru.unn.agile;

public class FiguresVolumeCalculator {

    public static double pyramidVolumeCalculate(final double baseSquare, final double height) {
        if (baseSquare < 0) {
            throw new IllegalArgumentException("Square can't be negative");
        }
        return 1./3 * baseSquare * Math.abs(height);
    }

    public static double sphereVolumeCalculate(final double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius can't be negative");
        }
        return 4./3 * Math.PI * Math.pow(radius, 3);
    }
}
