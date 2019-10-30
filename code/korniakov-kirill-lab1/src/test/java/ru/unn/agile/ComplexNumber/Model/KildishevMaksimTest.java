package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;
import static org.junit.Assert.*;

public class KildishevMaksimTest {
    @Test
    public void areComplexNumberAndStringNotEqual() {
        ComplexNumber z1 = new ComplexNumber(1, 1);
        String string = "str";
        assertFalse(z1.equals(string));
    }

    @Test
    public void areReferencesToSameObjectEquals() {
        ComplexNumber z1 = new ComplexNumber(1, 1);
        ComplexNumber z2 = z1;
        assertTrue(z1.equals(z2));
    }

    @Test
    public void canGetReal() {
        ComplexNumber z1 = new ComplexNumber(1.5, -1);
        assertTrue(z1.getReal() == 1.5);
    }

    @Test
    public void canGetImaginary() {
        ComplexNumber z1 = new ComplexNumber(1.5, -1);
        assertTrue(z1.getImaginary() == -1);
    }
}
