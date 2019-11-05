package ru.unn.agile.ComplexNumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class IuferevKirillTest {

    private final double delta = 0.001;

    @Test
    public void areNumberIsNotEqualComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber(2.4, 4.4);
        assertFalse(complexNumber.equals(24));
    }

    @Test
    public void canFormatToString() {
        ComplexNumber complexNumber = new ComplexNumber(2.4, 4.4);
        assertEquals("2.4 + 4.4i", complexNumber.toString());
    }

    @Test
    public void canGetImaginaryPart() {
        ComplexNumber complexNumber = new ComplexNumber(2.4, 4.4);
        assertTrue(complexNumber.getImaginary() == 4.4);
    }

    @Test
    public void canGetRealPart() {
        ComplexNumber complexNumber = new ComplexNumber(2.4, 4.4);
        assertEquals(2.4, complexNumber.getReal(), delta);
    }
}
