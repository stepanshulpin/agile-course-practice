package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class BevzukSemenTest {
    private final double delta = 0.001;

    @Test
    public void canCreateComplexNumberByDefault(){
        ComplexNumber a = new ComplexNumber();

        assertNotNull(a);
    }

    @Test
    public void canCreateComplexNumberWithParameters(){
        ComplexNumber a = new ComplexNumber(1.0, 2.0);

        assertNotNull(a);
    }

    @Test
    public void canSetInitialReal(){
        ComplexNumber a = new ComplexNumber(1.0, 2.0);

        assertEquals(1.0, a.getReal(), delta);
    }

    @Test
    public void canSetInitialImaginary(){
        ComplexNumber a = new ComplexNumber(1.0, 2.0);

        assertEquals(2.0, a.getImaginary(), delta);
    }
}
