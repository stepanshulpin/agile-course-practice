package ru.unn.agile.polynomialcalculator.model;

import java.util.Locale;

public class Polynomial {

    private int degree;
    private double[] coefs;

    public Polynomial(final double coef, final int degree) {
        if (degree < 0) {
            throw new IllegalArgumentException("Can not create polynomial with negative degree!");
        }
        this.coefs = new double[degree + 1];
        this.coefs[degree] = coef;
        this.degree = degree;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int degree = this.degree; degree >= 0; degree--) {
            double coef = this.coefs[degree];
            if (coef != 0.) {
                if (coef > 0 && !result.toString().equals("")) {
                    result.append(" + ");
                }
                if (coef < 0) {
                    result.append(" - ");
                }
                result.append(String.format(Locale.US, "%.1f", Math.abs(coef)));
                if (degree > 0) {
                    result.append("x");
                }
                if (degree > 1) {
                    result.append("^").append(degree);
                }
                result.append(" ");
            } else {
                if (degree == 0 && result.toString().equals("")) {
                    result.append("0");
                }
            }

        }
        return result.toString().strip();
    }

    public int getDegree() {
        return degree;
    }

    public double getCoef(final int degree) {
        return coefs[degree];
    }
}
