package ru.unn.agile.NumbersInWords.model;

public class NumberToWordConverter {
    private final int ten = 10;
    private final int hundred = 100;

    public NumberToWordConverter() { }

    private String getDefaultNumber() {
        return "";
    }

    private String getOnes(final int number) {
        final String[] ones = {"", "one", "two", "three", "four", "five",
                               "six", "seven", "eight", "nine"};

        return ones[number % ten];
    }

    private String getTens(final int number) {
        final String[] tens = {"", "", "twenty", "thirty", "forty", "fifty",
                               "sixty", "seventy", "eighty", "ninety"};

        return tens[number / ten];
    }

    private String getTeens(final int number) {
        final String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen",
                                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

        return teens[number % ten];
    }


    private String getSecondPart(final int number) {
        final int twenty = 20;
        int numberForAnalysis = number % hundred;

        if ((number >= ten) && (number < twenty)) {
            return getTeens(numberForAnalysis);
        } else {
            String tens = getTens(numberForAnalysis);
            String ones = getOnes(numberForAnalysis);

            if ((!tens.equals("")) && (!ones.equals(""))) {
                return tens + " " + ones;
            } else {
                return tens + ones;
            }
        }
    }

    public String toWord(final int number) {
        return getSecondPart(number);
    }
}
