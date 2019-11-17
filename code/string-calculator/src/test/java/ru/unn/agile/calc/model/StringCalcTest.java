package ru.unn.agile.calc.model;

import java.util.concurrent.ThreadLocalRandom;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalcTest {
    final double delta = 0.00000001;
    @Test
    public void canBeBuilt() {
        assertTrue(true);
    }

    @Test
    public void canParseNumber1() {
        StringCalc calc = new StringCalc();
        var number = calc.result("1");
        assertEquals(1, number, delta);
    }

    @Test
    public void canParseNumber143() {
        StringCalc calc = new StringCalc();
        var number = calc.result("143");
        assertEquals(143, number, delta);
    }

    @Test
    public void canParseRandomNumber() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 100000);
        StringCalc calc = new StringCalc();
        var number = calc.result(Integer.toString(randomNum));
        assertEquals(randomNum, number, delta);
    }

    @Test
    public void canParseNotInt() {
        StringCalc calc = new StringCalc();
        var number = calc.result("143.26");
        assertEquals(143.26, number, delta);
    }

    @Test
    public void canParseSumOfTwoNumbers() {
        StringCalc calc = new StringCalc();
        var number = calc.result("143.26+2352.549");
        assertEquals(143.26 + 2352.549, number, delta);
    }

    @Test
    public void canParseSumOfThreeNumbers() {
        StringCalc calc = new StringCalc();
        var number = calc.result("143.26+2352.549+25436.25");
        assertEquals(143.26 + 2352.549 + 25436.25, number, delta);
    }

    @Test
    public void cantParseSumOfNumbersAndStrings() {
        StringCalc calc = new StringCalc();
        String message = "";
        try {
            var number = calc.result("143.26+2352.549+ewffwfe");
        } catch (NumberFormatException e) {
            message = e.getMessage();
        }
        assertEquals("String can't contain letters", message);
    }
}