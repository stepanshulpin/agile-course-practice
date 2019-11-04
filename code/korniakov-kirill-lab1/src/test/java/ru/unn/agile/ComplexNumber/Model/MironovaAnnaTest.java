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
}
