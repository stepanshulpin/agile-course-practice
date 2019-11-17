package ru.unn.agile.numbersinwords.model;

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

    @Test
    public void canConvertOneHundred() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(100);

        assertEquals("one hundred", word);
    }

    @Test
    public void canConvertTwoHundred() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(200);

        assertEquals("two hundred", word);
    }

    @Test
    public void canConvertFiveHundred() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(500);

        assertEquals("five hundred", word);
    }

    @Test
    public void canConvertFiveHundredAndFour() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(504);

        assertEquals("five hundred and four", word);
    }

    @Test
    public void canConvertFiveHundredAndFourteen() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(514);

        assertEquals("five hundred and fourteen", word);
    }

    @Test
    public void canConvertFiveHundredAndFortyOne() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(541);

        assertEquals("five hundred and forty one", word);
    }

    @Test
    public void canConvertOneThousand() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(1000);

        assertEquals("one thousand", word);
    }

    @Test
    public void canConvertTwoThousand() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(2000);

        assertEquals("two thousand", word);
    }

    @Test
    public void canConvertElevenThousand() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(11000);

        assertEquals("eleven thousand", word);
    }

    @Test
    public void canConvertOneHundredAndElevenThousand() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(111000);

        assertEquals("one hundred and eleven thousand", word);
    }

    @Test
    public void canConvertThousandsWithHundreds() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(123456);

        assertEquals("one hundred and twenty three thousand, four hundred and fifty six", word);
    }

    @Test
    public void canConvertOneMillion() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(1000000);

        assertEquals("one million", word);
    }

    @Test
    public void canConvertMillions() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(123000000);

        assertEquals("one hundred and twenty three million", word);
    }

    @Test
    public void canConvertMillionsWithThousands() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(123456000);

        assertEquals("one hundred and twenty three million, "
                + "four hundred and fifty six thousand", word);
    }

    @Test
    public void canConvertMillionsWithThousandsAndHundreds() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(123456789);

        assertEquals("one hundred and twenty three million, "
                + "four hundred and fifty six thousand, seven hundred and eighty nine", word);
    }

    @Test
    public void canConvertOneBillion() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(1000000000);

        assertEquals("one billion", word);
    }

    @Test
    public void canConvertCombinationsWithBillion() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(2123456789);

        assertEquals("two billion, one hundred and twenty three million, "
                + "four hundred and fifty six thousand, seven hundred and eighty nine", word);
    }

    @Test
    public void canConvertZero() {
        NumberToWordConverter converter = new NumberToWordConverter();

        String word = converter.toWord(0);

        assertEquals("", word);
    }
}
