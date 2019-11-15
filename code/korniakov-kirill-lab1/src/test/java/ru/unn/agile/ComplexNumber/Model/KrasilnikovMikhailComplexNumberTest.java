package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;
import static org.junit.Assert.*;

public class KrasilnikovMikhailComplexNumberTest {

    private double delta = 0.001;

    @Test
    public void testThatCanGetRealNumber() {
        int realNumber = 2;
        ComplexNumber complexNumber = new ComplexNumber(2, 25);
        assertEquals(realNumber, complexNumber.getReal(), delta);
    }

    @Test
    public void testThatCanSumComplexNumbers() {
        ComplexNumber resultNumber = new ComplexNumber(10, 50);
        ComplexNumber firstTerm = new ComplexNumber(3, 40);
        ComplexNumber secondTerm = new ComplexNumber(7, 10);
        assertEquals(resultNumber, firstTerm.add(secondTerm));
    }

    @Test
    public void testThatSumIsCommutative() {
        ComplexNumber firstTerm = new ComplexNumber(3, 40);
        ComplexNumber secondTerm = new ComplexNumber(7, 10);
        assertEquals(secondTerm.add(firstTerm), firstTerm.add(secondTerm));
    }
}
