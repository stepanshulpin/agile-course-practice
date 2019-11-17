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
}