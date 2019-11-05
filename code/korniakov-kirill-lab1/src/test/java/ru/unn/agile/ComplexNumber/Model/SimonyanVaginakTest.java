package ru.unn.agile.ComplexNumber.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimonyanVaginakTest {

    private final double compareDelta = 0.001;

    @Test
    public void canInitializeWithoutParameters() {
        ComplexNumber complexNumber = new ComplexNumber();
        assertNotNull(complexNumber);
    }

    @Test
    public void canInitializeWithDoubleParameters() {
        ComplexNumber complexNumber = new ComplexNumber(3.1, 4.5);
        assertNotNull(complexNumber);
    }

    @Test
    public void canInitializeWithStringParameters() {
        ComplexNumber complexNumber = new ComplexNumber("3.1", "4.5");
        assertNotNull(complexNumber);
    }

    @Test
    public void canAddTwoNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber("3.1", "4.5");
        ComplexNumber complexNumber2 = new ComplexNumber("4.5", "3.1");

        ComplexNumber sum = complexNumber1.add(complexNumber2);
        assertEquals(sum, new ComplexNumber("7.6", "7.6"));
    }

    @Test
    public void canGetRealPart() {
        ComplexNumber complexNumber1 = new ComplexNumber("3.1", "4.5");
        assertEquals(complexNumber1.getReal(), 3.1, compareDelta);
    }

    @Test
    public void canGetImaginaryPart() {
        ComplexNumber complexNumber1 = new ComplexNumber("3.1", "4.5");
        assertEquals(complexNumber1.getImaginary(), 4.5, compareDelta);
    }
}
