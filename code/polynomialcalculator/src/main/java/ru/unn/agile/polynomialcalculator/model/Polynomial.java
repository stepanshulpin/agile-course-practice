package ru.unn.agile.polynomialcalculator.model;

public class Polynomial {

    private int degree = 0;
    private double[] coefs;

    public Polynomial(double coef, int degree) {
        this.coefs = new double[degree + 1];
        this.coefs[degree] = coef;
    }

    public int getDegree() {
        return degree;
    }

    public double getCoef(int degree) {
        return coefs[degree];
    }
}
