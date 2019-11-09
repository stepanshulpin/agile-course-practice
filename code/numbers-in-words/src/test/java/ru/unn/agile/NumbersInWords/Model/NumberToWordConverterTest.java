package ru.unn.agile.NumbersInWords.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class NumberToWordConverterTest {
    @Test
    public void canCresteConverter() {
        NumberToWordConverter converter = new NumberToWordConverter();
        assertNotNull(converter);
    }

    @Test
    public void canConvertOne() {
        NumberToWordConverter converter = new NumberToWordConverter();
        String word = converter.toWord(1);
        assertEquals("one", word);
    }

    @Test
    public void canConvertTwo() {
        NumberToWordConverter converter = new NumberToWordConverter();
        String word = converter.toWord(2);
        assertEquals("two", word);
    }

    @Test
    public void canConvertThree() {
        NumberToWordConverter converter = new NumberToWordConverter();
        String word = converter.toWord(3);
        assertEquals("three", word);
    }

    @Test
    public void canConvertTen() {
        NumberToWordConverter converter = new NumberToWordConverter();
        String word = converter.toWord(10);
        assertEquals("ten", word);
    }

    @Test
    public void canConvertTwenty() {
        NumberToWordConverter converter = new NumberToWordConverter();
        String word = converter.toWord(20);
        assertEquals("twenty", word);
    }

    @Test
    public void canConvertThirty() {
        NumberToWordConverter converter = new NumberToWordConverter();
        String word = converter.toWord(30);
        assertEquals("thirty", word);
    }

    @Test
    public void canConvertTwentyFive() {
        NumberToWordConverter converter = new NumberToWordConverter();
        String word = converter.toWord(25);
        assertEquals("twenty five", word);
    }

    @Test
    public void canConvertThirtySix() {
        NumberToWordConverter converter = new NumberToWordConverter();
        String word = converter.toWord(36);
        assertEquals("thirty six", word);
    }

    @Test
    public void canConvertTwelve() {
        NumberToWordConverter converter = new NumberToWordConverter();
        String word = converter.toWord(12);
        assertEquals("twelve", word);
    }

    @Test
    public void canConvertFifteen() {
        NumberToWordConverter converter = new NumberToWordConverter();
        String word = converter.toWord(15);
        assertEquals("fifteen", word);
    }
}
