package ru.unn.agile.complexnumbercalculation.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComplexNumberTest {
    @Test
    public void createComplexNumberByDefaultNotNull() {
        ComplexNumber a = new ComplexNumber();

        assertNotNull(a);
    }

    @Test
    public void emptyCreateComplexNumberCheckRealPart() {
        ComplexNumber a = new ComplexNumber();

        assertEquals(0.0, a.getRe(), 0.0);
    }

    @Test
    public void emptyCreateComplexNumberCheckImaginePart() {
        ComplexNumber a = new ComplexNumber();

        assertEquals(0.0, a.getIm(), 0.0);
    }
    @Test
    public void createComplexNumberWithParametersNotNull() {
        ComplexNumber a = new ComplexNumber(5.0, 6.0);

        assertNotNull(a);
    }

    @Test
    public void createComplexNumberWithParametersCheckRe() {
        ComplexNumber a = new ComplexNumber(5.0, 6.0);

        assertEquals(5.0, a.getRe(), 0.0);
    }

    @Test
    public void createComplexNumberWithParametersCheckIm() {
        ComplexNumber a = new ComplexNumber(5.0, 6.0);

        assertEquals(6.0, a.getIm(), 0.0);
    }

    @Test
    public void createComplexNumberWithNegativeParametersCheckRe() {
        ComplexNumber a = new ComplexNumber(-5.0, 6.0);

        assertEquals(-5.0, a.getRe(), 0.0);
    }

    @Test
    public void createComplexNumberWithNegativeParametersCheckIm() {
        ComplexNumber a = new ComplexNumber(5.0, -6.0);

        assertEquals(-6.0, a.getIm(), 0.0);
    }

}
