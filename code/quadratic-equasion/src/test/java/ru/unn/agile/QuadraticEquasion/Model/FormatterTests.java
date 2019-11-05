package ru.unn.agile.QuadraticEquasion.Model;

import org.junit.Test;
import ru.unn.agile.QuadraticEquasion.model.Formatter;
import ru.unn.agile.QuadraticEquasion.model.QuadraticEquasion;

import static org.junit.Assert.assertEquals;

public class FormatterTests {

    @Test(expected = IllegalArgumentException.class)
    public void throwsOnNegativeDouble() {
        double x = -1.0;
        Formatter.formatPositiveDouble(x);
    }

    @Test
    public void canFormatToIntegerWith6Digits() {
        double x = 123456.123;
        assertEquals("123456.12", Formatter.formatPositiveDouble(x));
    }

    @Test
    public void canConvertToString() {
        QuadraticEquasion qe = new QuadraticEquasion(2.0, 2.0, 3.0);
        assertEquals("2.0(x^2) + 2.0x + 3.0", qe.toString());
    }

    @Test
    public void canConvertFloatingCoeffsToString() {
        QuadraticEquasion qe = new QuadraticEquasion(1.11, 2.22, 3.33);
       assertEquals("1.11(x^2) + 2.22x + 3.33", qe.toString());
    }

    @Test
    public void canConvertNegativeCoeffsToString() {
        QuadraticEquasion qe = new QuadraticEquasion(-1.0, -2.0, -3.0);
        assertEquals("- (x^2) - 2.0x - 3.0", qe.toString());
    }

    @Test
    public void canConvertCoeffsEqualsToOneToString() {
        QuadraticEquasion qe = new QuadraticEquasion(1.0, -1.0, 1.0);
        assertEquals("(x^2) - x + 1.0", qe.toString());
    }

    @Test
    public void canConvertWithZeroACoeffToString() {
        QuadraticEquasion qe = new QuadraticEquasion(0.0, -1.0, 1.0);
        assertEquals(" - x + 1.0", qe.toString());
    }

    @Test
    public void canConvertWithZeroBCoeffToString() {
        QuadraticEquasion qe = new QuadraticEquasion(1.0, 0.0, 1.0);
        assertEquals("(x^2) + 1.0", qe.toString());
    }

    @Test
    public void canConvertWithZeroCCoeffToString() {
        QuadraticEquasion qe = new QuadraticEquasion(1.0, -1.0, 0.0);
        assertEquals("(x^2) - x", qe.toString());
    }

    @Test
    public void canConvertWithTwoZeroCoeffsToString() {
        QuadraticEquasion qe = new QuadraticEquasion(0.0, 1.0, 0.0);
        assertEquals("x", qe.toString());
    }
}
