package ru.unn.agile.complexnumbercalculation.model;

public class CalculatorComplexNumber {
    public CalculatorComplexNumber() {
    }

    public ComplexNumber add(final ComplexNumber z1, final ComplexNumber z2) {
        return new ComplexNumber(z1.getRe() + z2.getRe(), z1.getIm() + z2.getIm());
    }

    public ComplexNumber subtract(final ComplexNumber z1, final ComplexNumber z2) {
        return new ComplexNumber(z1.getRe() - z2.getRe(), z1.getIm() - z2.getIm());
    }

    public ComplexNumber multiply(final ComplexNumber z1, final ComplexNumber z2) {
        return new ComplexNumber(z2.getRe() * z1.getRe() - z2.getIm() * z1.getIm(),
                z2.getRe() * z1.getIm() + z2.getIm() * z1.getRe());
    }

    public ComplexNumber divide(final ComplexNumber z1, final ComplexNumber z2)
            throws ArithmeticException {
        if ((z2.getIm() == 0) && (z2.getRe() == 0)) {
            throw new ArithmeticException("Can`t to be divided on zero");
        }

        double norma = z2.getIm() * z2.getIm() + z2.getRe() * z2.getRe();
        double rePart = z1.getRe() * z2.getRe() + z1.getIm() * z2.getIm();
        double imPart = z2.getRe() * z1.getIm() - z1.getRe() * z2.getIm();
        return new ComplexNumber(rePart / norma, imPart / norma);
    }

    public ComplexNumber pow(final ComplexNumber z, final int degree) {
        z.convertToTrigonomForm();
        double tempRadius = Math.pow(z.getRadius(), degree);
        double tempAngle = degree * z.getAngle();
        z.setAngle(tempAngle);
        z.setRadius(tempRadius);
        return z.getComplexNumberFromTrigonomForm();
    }

    public ComplexNumber[] extractRoot(final ComplexNumber z, final int degree) {
        z.convertToTrigonomForm();
        double phi0 = z.getAngle();
        ComplexNumber[] result = new ComplexNumber[degree];
        double tempRadius = Math.pow(z.getRadius(), 1 / degree);
        for (int k = 0; k < degree; k++) {
            ComplexNumber zTmp = new ComplexNumber();
            zTmp.setRadius(tempRadius);
            zTmp.setAngle((phi0 + 2 * Math.PI * k) / degree);
            result[k] = zTmp.getComplexNumberFromTrigonomForm();
        }
        return result;
    }
}
