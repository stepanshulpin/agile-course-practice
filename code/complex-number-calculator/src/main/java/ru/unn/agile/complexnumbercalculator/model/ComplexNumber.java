package ru.unn.agile.complexnumbercalculator.model;

public class ComplexNumber {
    private double re;
    private double im;
    private final double delta = 0.0001;
    private double module;
    private double argument;

    public ComplexNumber() {
        re = 0.0;
        im = 0.0;
        module = 0.0;
        argument = 0.0;
    }

    public ComplexNumber(final double userRe, final double userIm) {
        re = userRe;
        im = userIm;
        convertToTrigonometricForm();
    }

    public ComplexNumber(final ComplexNumber a) {
        re = a.getRe();
        im = a.getIm();
        module = a.getModule();
        argument = a.getArgument();
    }

   public void setTrigonometricForm(final double userModule, final double userPhase) {
        module = userModule;
       argument = userPhase;
        convertToAlgebraicForm();
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
                && (Math.abs((((ComplexNumber) object).getRe() - re)) < delta)
                && (Math.abs((((ComplexNumber) object).getModule() - module)) < delta)) {
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

    private void convertToTrigonometricForm() {
        // Boundary value
        if ((Math.abs(re) < delta) && (Math.abs(im) < delta)) {
            module = 0.0;
            argument = 0.0;
            return;
        }
        if (Math.abs(im) < delta) {
            module = Math.abs(re);
            argument = re > 0.0 ? 0.0 : Math.PI;
            return;
        }
        if (Math.abs(re) < delta) {
            module = Math.abs(im);
            argument = im > 0.0 ? Math.PI / 2.0 : -Math.PI / 2.0;
            return;
        }

        module = Math.sqrt(re * re + im * im);
        argument = Math.atan(im / re);
    }

    public void convertToAlgebraicForm() {
        re = module * Math.cos(argument);
        im = module * Math.sin(argument);
    }

    public double getArgument() {
        return argument;
    }

    public double getModule() {
        return module;
    }

    public double getAccuracy() {
        return delta;
    }
}
