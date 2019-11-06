package ru.unn.agile.polynomialcalculator.model;

import java.util.ArrayList;

public class Polynomial {

    private int degree = 0;
    private ArrayList<Double> coefs;

    public Polynomial() {
        this.coefs = new ArrayList<>();
        this.coefs.add(0.);
    }

    public int getDegree() {
        return degree;
    }

    public double getValue(int degree) {
        return 0;
    }
}
