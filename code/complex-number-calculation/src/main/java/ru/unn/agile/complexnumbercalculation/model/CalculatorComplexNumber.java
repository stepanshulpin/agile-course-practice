package ru.unn.agile.complexnumbercalculation.model;

public class CalculatorComplexNumber {
    private ComplexNumber z1;
    private ComplexNumber z2;

    public CalculatorComplexNumber() {
        z1 = new ComplexNumber();
        z2 = new ComplexNumber();
    }

    public ComplexNumber getZ1() {
        return z1;
    }

    public ComplexNumber getZ2() {
        return z2;
    }
}
