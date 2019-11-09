package ru.unn.agile.NumbersInWords.model;

public class NumberToWordConverter {
    private final int ten = 10;

    public NumberToWordConverter() { }

    private String getDefaultNumber() {
        return "";
    }

    private String getOnes(final int number) {
        final String[] ones = {"one", "two", "three", "four", "five",
                               "six", "seven", "eight", "nine"};

        if (number % ten != 0) {
            return ones[number % ten - 1];
        } else {
            return getDefaultNumber();
        }
    }

    private String getTens(final int number) {
        final String[] tens = {"ten", "twenty", "thirty", "forty", "fifty",
                               "sixty", "seventy", "eighty", "ninety"};

        if (number >= ten) {
            return tens[number / ten - 1];
        } else {
            return getDefaultNumber();
        }
    }

    public String toWord(final int number) {
        String tens = getTens(number);
        String ones = getOnes(number);

        if ((!tens.equals("")) && (!ones.equals(""))) {
            return tens + " " + ones;
        } else {
            return tens + ones;
        }
    }
}
