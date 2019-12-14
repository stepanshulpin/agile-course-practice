package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AntonVlasovTest {
    @Test(expected = NumberFormatException.class)
    public void cannotCreateNumberWithIncorrectRealPart() {
        var incorrectRealPart = "world";
        var correctImaginaryPart = "1";
        var number = new ComplexNumber(incorrectRealPart, correctImaginaryPart);
    }

    @Test(expected = NumberFormatException.class)
    public void cannotCreateNumberWithIncorrectImaginaryPart() {
        var correctRealPart = "1";
        var incorrectImaginaryPart = "hello";
        var number = new ComplexNumber(correctRealPart, incorrectImaginaryPart);
    }

    @Test
    public void canCompareComplexNumbersDifferentByInitializationType() {
        var number1 = new ComplexNumber("1", "1");
        var number2 = new ComplexNumber(1, 1);
        assertEquals(number1, number2);
    }
}
