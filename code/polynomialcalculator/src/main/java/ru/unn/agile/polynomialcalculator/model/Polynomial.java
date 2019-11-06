package ru.unn.agile.polynomialcalculator.model;

public class Polynomial {

    private int degree;
    private double[] coefs;

    public Polynomial(double coef, int degree) {
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
        for (int degree = this.degree; degree>=0; degree--) {
            if (degree == 0 && result.toString().equals("")) {
                return "0";
            }
            double coef = this.coefs[degree];
            if(coef != 0.) {
                result.append(coef).append("x^").append(degree).append(" ");
            }
        }
        return result.toString().strip();
    }

    public int getDegree() {
        return degree;
    }

    public double getCoef(int degree) {
        return coefs[degree];
    }
}
