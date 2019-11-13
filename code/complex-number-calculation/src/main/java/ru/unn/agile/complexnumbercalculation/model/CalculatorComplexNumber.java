package ru.unn.agile.complexnumbercalculation.model;

public class CalculatorComplexNumber {
    public CalculatorComplexNumber() {
    }

    public ComplexNumber addition(final ComplexNumber z1, final ComplexNumber z2) {
        return new ComplexNumber(z1.getRe() + z2.getRe(), z1.getIm() + z2.getIm());
    }

    public ComplexNumber subtraction(final ComplexNumber z1, final ComplexNumber z2) {
        return new ComplexNumber(z1.getRe() - z2.getRe(), z1.getIm() - z2.getIm());
    }

    public ComplexNumber multiplication(final ComplexNumber z1, final ComplexNumber z2) {
        return new ComplexNumber(z2.getRe() * z1.getRe() - z2.getIm() * z1.getIm(),
                z2.getRe() * z1.getIm() + z2.getIm() * z1.getRe());
    }

    public ComplexNumber division(final ComplexNumber z1, final ComplexNumber z2) {
        if (z2.equals(new ComplexNumber())) {
            throw new ArithmeticException("Can`t to be divided on zero");
        }

        double norma = z2.getIm() * z2.getIm() + z2.getRe() * z2.getRe();
        double rePart = z1.getRe() * z2.getRe() + z1.getIm() * z2.getIm();
        double imPart = z2.getRe() * z1.getIm() - z1.getRe() * z2.getIm();
        return new ComplexNumber(rePart / norma, imPart / norma);
    }
}
