package ru.unn.agile.complexnumbercalculation.model;

public class ComplexNumber {
    private double re;
    private double im;
    private final double delta = 0.001;
    private double radius;
    private double angle;

    public ComplexNumber getComplexNumberFromTrigonomForm() {
        double rePart = radius * Math.cos(angle);
        double imPart = radius * Math.sin(angle);
        return new ComplexNumber(rePart, imPart);
    }

    public ComplexNumber() {
        re = 0.0;
        im = 0.0;
        radius = 0.0;
        angle = 0.0;
    }

    public ComplexNumber(final double userRe, final double userIm) {
        re = userRe;
        im = userIm;
        radius = 0.0;
        angle = 0.0;
    }

    public ComplexNumber(final ComplexNumber a) {
        re = a.getRe();
        im = a.getIm();
        radius = 0.0;
        angle = 0.0;
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

        if ((Math.abs((((ComplexNumber) object).getIm() - im)) < delta)
                && (Math.abs((((ComplexNumber) object).getRe() - re)) < delta)) {
            return true;
        }
        return object.hashCode() == hashCode();
    }

    @Override
    public String toString() {

        StringBuffer buffer = new StringBuffer();
        buffer.append(getRe() < 0 ? "-" : "");
        buffer.append(Math.abs(re))
                .append(getIm() < 0 ? " - " : " + ")
                .append(Math.abs(im))
                .append("i");
        return buffer.toString();
    }

    public void convertToTrigonomForm() {
        radius = Math.sqrt(re * re + im * im);
        angle = Math.atan(im / re);
    }

    public double getAngle() {
        return angle;
    }

    public double getRadius() {
        return radius;
    }

    public void setAngle(final double angle) {
        this.angle = angle;
    }
    public void setRadius(final double radius) {
        this.radius = radius;
    }
}
