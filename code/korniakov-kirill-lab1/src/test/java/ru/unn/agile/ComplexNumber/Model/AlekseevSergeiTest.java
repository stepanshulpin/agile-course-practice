package ru.unn.agile.ComplexNumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlekseevSergeiTest {

    @Test
    public void areEuqalNumbersEqual() {
        ComplexNumber z1 = new ComplexNumber(1.1, 2.3);
        ComplexNumber z2 = new ComplexNumber(1.1, 2.3);

        assertTrue(z1.equals(z2));
    }

    @Test
    public void areDifferentNumbersEqual() {
        ComplexNumber z1 = new ComplexNumber(1.1, 2.3);
        ComplexNumber z2 = new ComplexNumber(5.8, 13.21);

        assertFalse(z1.equals(z2));
    }

    private final double delta = 0.00000001;

    @Test
    public void canGetRealPart() {
        ComplexNumber z = new ComplexNumber(1.1, 2.3);

        assertEquals(1.1, z.getReal(), delta);
    }

    @Test
    public void canGetImaginaryPart() {
        ComplexNumber z = new ComplexNumber(1.1, 2.3);

        assertEquals(2.3, z.getImaginary(), delta);
    }

    @Test
    public void canAddNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = new ComplexNumber(2, 3);

        ComplexNumber z = z1.add(z2);

        assertEquals(new ComplexNumber(3, 4), z);
    }

    @Test
    public void canMultiplyNumbers() {
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = new ComplexNumber(2, 3);

        ComplexNumber z = z1.multiply(z2);

        assertEquals(new ComplexNumber(-1, 5), z);
    }
    @Test
    public void canFormatNumbers() {
        ComplexNumber z = new ComplexNumber(1.1, 2.35);

        assertEquals("1.1 + 2.35i", z.toString());
    }
}
