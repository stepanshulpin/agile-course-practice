package ru.unn.agile.complexnumbercalculation.model;

public class ComplexNumber {
    private double re;
    private double im;

    public ComplexNumber() {
        re = 0.0;
        im = 0.0;
    }

    public ComplexNumber(final double userRe, final double userIm) {
        re = userRe;
        im = userIm;
    }

    public double getRe() {
        return re;
    }
    public double getIm() {
        return im;
    }
}
