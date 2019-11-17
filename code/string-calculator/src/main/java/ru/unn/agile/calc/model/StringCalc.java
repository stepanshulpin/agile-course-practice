package ru.unn.agile.calc.model;

public class StringCalc {
    public StringCalc() {

    }

    public double result(String string) {
        double foo;
        foo = Double.parseDouble(string);
        return foo;
    }
}