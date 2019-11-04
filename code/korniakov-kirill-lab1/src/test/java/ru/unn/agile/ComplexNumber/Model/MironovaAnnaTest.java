package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class MironovaAnnaTest {
    @Test
    public void canCreateComplexNumberWithoutArguments() {
        ComplexNumber z = new ComplexNumber();

        assertNotNull(z);
    }

    @Test
    public void canCreateComplexNumberWithStringArguments() {
        final String re = "1.0";
        final String im = "1.0";

        ComplexNumber z = new ComplexNumber(re, im);

        assertNotNull(z);
    }

    @Test
    public void canCompareEqualComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1.0, 0.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 0.0);

        boolean flag = z1.equals(z2);

        assertTrue(flag);
    }

    @Test
    public void canCompareNotEqualComplexNumbers() {
        ComplexNumber z1 = new ComplexNumber(1.0, 0.0);
        ComplexNumber z2 = new ComplexNumber(1.0, 1.0);

        boolean flag = z1.equals(z2);

        assertFalse(flag);
    }
}
