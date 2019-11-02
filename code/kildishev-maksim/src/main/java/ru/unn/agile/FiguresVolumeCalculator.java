package ru.unn.agile;

public class FiguresVolumeCalculator {

    public static double pyramidVolumeCalculate(final double baseSquare, final double height) {
        return 1./3 * baseSquare * height;
    }

    public static double sphereVolumeCalculate(final double radius) {
        return 0;
    }
}
