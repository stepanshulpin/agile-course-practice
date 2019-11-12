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

    @Override
    public int hashCode() {
        final int shift = 32;
        int prime = (int) im;
        int result = 1;

        long longBits = Double.doubleToLongBits(re);
        result = prime * result + (int) (longBits - (longBits >>> shift));
        return result;
    }

    @Override
    public boolean equals(final Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof ComplexNumber)) {
            return false;
        }

        if ((((ComplexNumber) object).getIm() == im) && (((ComplexNumber) object).getRe() == re)) {
            return true;
        }
        return object.hashCode() == hashCode();
    }
}
