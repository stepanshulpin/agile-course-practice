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

    @Test
    public void canCreateComplexNumberFromString(){
        String re = "-10.0";
        String im = "20";
        ComplexNumber a = new ComplexNumber(-10.0, 20);

        ComplexNumber b = new ComplexNumber(re, im);

        assertEquals(a, b);
    }

    @Test
    public void canHashComplexNumber(){
        ComplexNumber a = new ComplexNumber(1.0, 2.0);

        int hash = a.hashCode();

        assertNotNull(hash);
    }

    @Test
    public void canConvertComplexNumberToString(){
        ComplexNumber a = new ComplexNumber(1.0, -2.0);

        String string = a.toString();

        assertEquals("1.0 - 2.0i", string);
    }
}
