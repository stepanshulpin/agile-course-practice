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
}
