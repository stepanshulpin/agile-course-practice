package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class GrechukhinNikitaTest {

    private final double delta = 1e-3;

    @Test
    public void canCreateWithoutParameters() {
        var complexNumber = new ComplexNumber();
        assertNotNull(complexNumber);
    }

    @Test
    public void canCreateWithDoubleParameters() {
        var complexNumber = new ComplexNumber(1.3, 2.9);
        assertNotNull(complexNumber);
    }

    @Test
    public void canCreateWithStringParameters() {
        var complexNumber = new ComplexNumber("2.11", "9.4");
        assertNotNull(complexNumber);
    }

    @Test
    public void canGetRealPart() {
        var complexNumber = new ComplexNumber(10.2, 93.4);
        assertEquals(10.2, complexNumber.getReal(), delta);
    }

    @Test
    public void canGetImaginaryPart() {
        var complexNumber = new ComplexNumber(0.0, 0.1);
        assertEquals(0.1, complexNumber.getImaginary(), delta);
    }

    @Test(expected = NumberFormatException.class)
    public void canThrowWithIncorrectString() {
        new ComplexNumber("Throw", "Exception");
    }
}
