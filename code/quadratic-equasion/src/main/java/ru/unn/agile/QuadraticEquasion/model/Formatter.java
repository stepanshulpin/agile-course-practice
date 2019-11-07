package ru.unn.agile.QuadraticEquasion.model;

public final class Formatter {

    private Formatter() { }

    private static Integer getTwoDigitsAfterPoint(final double value) {
        final int hundred = 100;
        double val = value * hundred;
        return (int) val % hundred;
    }

    public static String formatPositiveDouble(final double value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }

        Integer i = (int) value;
        String buffer = i.toString();

        final int ten = 10;

        i = getTwoDigitsAfterPoint(value);
        buffer += ".";
        if (i == 0) {
            buffer += "0";
        } else if (i < ten) {
            buffer += "0";
            buffer += i.toString();
        } else {
            if (i % ten == 0) {
                i /= ten;
            }
            buffer += i.toString();
        }

        return buffer;
    }

    public static String getFormatted(final QuadraticEquasion qe) {
        StringBuffer buffer = new StringBuffer();
        String a = formatPositiveDouble(Math.abs(qe.getACoeff()));
        String b = formatPositiveDouble(Math.abs(qe.getBCoeff()));
        String c = formatPositiveDouble(Math.abs(qe.getCCoeff()));
        buffer.append((qe.getACoeff() < 0) && (Math.abs(qe.getACoeff()) != 0) ? "- " : "")
            .append((Math.abs(qe.getACoeff()) != 1) && (Math.abs(qe.getACoeff()) != 0) ? a : "")
            .append(Math.abs(qe.getACoeff()) != 0 ? "(x^2)" : "")
            .append(qe.getBCoeff() < 0  ? " - " : (Math.abs(qe.getBCoeff()) != 0)
                    && (buffer.length() > 0) ? " + " : "")
            .append((Math.abs(qe.getBCoeff()) != 1)  && (Math.abs(qe.getBCoeff()) != 0) ? b : "")
            .append(Math.abs(qe.getBCoeff()) != 0 ? "x" : "")
            .append(qe.getCCoeff() < 0 ? " - " : (Math.abs(qe.getCCoeff()) != 0)
                    && (buffer.length() > 0) ? " + " : "")
            .append(Math.abs(qe.getCCoeff()) != 0 ? c : "");
        return buffer.toString();
    }

}
