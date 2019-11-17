package ru.unn.agile.calc.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalcTest {

    @Test
    public void canBeBuilt() {
        assertTrue(true);
    }

    @Test
    public void canParseNumber1() {
        StringCalc calc = new StringCalc();
        var number = calc.result("1");
        assertEquals(1, number);
    }
}