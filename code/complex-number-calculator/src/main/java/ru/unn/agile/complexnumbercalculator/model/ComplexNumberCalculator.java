package ru.unn.agile.complexnumbercalculator.model;

public class ComplexNumberCalculator {
    public ComplexNumberCalculator() {
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
      //  z.convertToTrigonometricForm();
        double tempRadius = Math.pow(z.getModule(), degree);
        double tempAngle = degree * z.getPhase();
        z.setTrigonometricForm(tempRadius, tempAngle);
        return z;
    }

    public ComplexNumber[] extractRoot(final ComplexNumber z, final int degree) {
       // z.convertToTrigonometricForm();
        double phi0 = z.getPhase();
        ComplexNumber[] result = new ComplexNumber[degree];
        double tempRadius = Math.pow(z.getModule(), 1 / degree);
        for (int k = 0; k < degree; k++) {
            ComplexNumber zTmp = new ComplexNumber();
            zTmp.setTrigonometricForm(tempRadius, (phi0 + 2 * Math.PI * k) / degree);
            result[k] = zTmp;
        }
        return result;
    }
}
