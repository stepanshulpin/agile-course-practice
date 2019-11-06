package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class SizovaKsenyaTest {
    private final double delta = 0.001;

    @Test
    public void canCreateDefaultComplexNumber() {
        ComplexNumber complexNumber = new ComplexNumber();

        // Assert
        assertEquals(complexNumber.getReal(), 0, delta);
        assertEquals(complexNumber.getImaginary(), 0, delta);
    }

    @Test
    public void canCreateComplexNumberWithValues() {
        ComplexNumber complexNumber = new ComplexNumber(1, 2);

        // Assert
        assertEquals(complexNumber.getReal(), 1, delta);
        assertEquals(complexNumber.getImaginary(), 2, delta);
    }

    @Test
    public void canCreateComplexNumberWithString() {
        ComplexNumber complexNumber = new ComplexNumber("1", "2");

        // Assert
        assertEquals(complexNumber.getReal(), 1, delta);
        assertEquals(complexNumber.getImaginary(), 2, delta);
    }

    @Test
    public void canAddComplexNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(1.5, 2.5);
        ComplexNumber complexNumber2 = new ComplexNumber(2.5, 1.5);

        ComplexNumber complexNumber3 = complexNumber1.add(complexNumber2);

        // Assert
        assertEquals(complexNumber3.getReal(), 4, delta);
        assertEquals(complexNumber3.getImaginary(), 4, delta);
    }

    @Test
    public void areEqualNumbersEqual() {
        ComplexNumber complexNumber1 = new ComplexNumber(2.71, 0.2);
        ComplexNumber complexNumber2 = new ComplexNumber(2.71, 0.2);

        // Assert
        assertTrue(complexNumber1.equals(complexNumber2));
    }

    @Test
    public void canFormatSumOfNumbersWithNegativePart() {
        ComplexNumber complexNumber1 = new ComplexNumber(2, 10);
        ComplexNumber complexNumber2 = new ComplexNumber(-5, 2);
        ComplexNumber complexNumber3 = complexNumber1.add(complexNumber2);

        // Assert
        assertEquals("-3.0 + 12.0i", complexNumber3.toString());
    }

    @Test
    public void canMultiplyNumbers() {
        ComplexNumber complexNumber1 = new ComplexNumber(2, 1);
        ComplexNumber complexNumber2 = new ComplexNumber(1, 2);
        ComplexNumber complexNumber3 = complexNumber1.multiply(complexNumber2);

        // Assert
        assertEquals(new ComplexNumber(0, 5), complexNumber3);
    }
}
