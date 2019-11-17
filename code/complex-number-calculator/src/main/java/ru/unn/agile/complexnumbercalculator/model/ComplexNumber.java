package ru.unn.agile.complexnumbercalculator.model;

public class ComplexNumber {
    private double re;
    private double im;
    private final double delta = 0.001;
    private double module;
    private double phase;

    public ComplexNumber getComplexNumberFromTrigonomForm() {
        double rePart = module * Math.cos(phase);
        double imPart = module * Math.sin(phase);
        return new ComplexNumber(rePart, imPart);
    }

    public ComplexNumber() {
        re = 0.0;
        im = 0.0;
        module = 0.0;
        phase = 0.0;
    }

    public ComplexNumber(final double userRe, final double userIm) {
        re = userRe;
        im = userIm;
        module = 0.0;
        phase = 0.0;
    }

    public ComplexNumber(final ComplexNumber a) {
        re = a.getRe();
        im = a.getIm();
        module = 0.0;
        phase = 0.0;
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
        // Boundary value
        if ((re == 0) && (im == 0)) {
            module = 0.0;
            phase = 0.0;
            return;
        }
        if (im == 0) {
            module = Math.abs(re);
            phase = re > 0.0 ? 0.0 : Math.PI;
            return;
        }
        if (re == 0) {
            module = Math.abs(im);
            phase = im > 0.0 ? Math.PI / 2.0 : -Math.PI / 2.0;
            return;
        }

        module = Math.sqrt(re * re + im * im);
        phase = Math.atan(im / re);
    }

    public double getAngle() {
        return phase;
    }

    public double getModule() {
        return module;
    }

    public void setAngle(final double phase) {
        this.phase = phase;
    }
    public void setRadius(final double module) {
        this.module = module;
    }
}
