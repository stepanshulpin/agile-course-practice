package ru.unn.agile.NumbersInWords.model;

public class NumberToWordConverter {
    private final int ten = 10;
    private final int hundred = 100;
    private final int thousand = 1000;

    public NumberToWordConverter() { }

    private String getSpaser(final String firstWord, final String lastWord,
                             final String middleWord) {
        if ((!firstWord.equals("")) && (!lastWord.equals(""))) {
            return firstWord + middleWord + lastWord;
        } else {
            return firstWord + lastWord;
        }
    }


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

    private String getHighOrder(final int number) {
        String[] highOrder = {"", "thousand", "million", "billion"};

        return highOrder[number];
    }


    private String getFirstPart(final int number) {
        int numberForAnalysis = number / hundred;
        String numberOfHighOrder = getOnes(numberForAnalysis);

        if (!numberOfHighOrder.equals("")) {
            return getOnes(numberForAnalysis) + " hundred";
        } else {
            return "";
        }
    }

    private String getSecondPart(final int number) {
        final int twenty = 20;
        int numberForAnalysis = number % hundred;

        if ((numberForAnalysis >= ten) && (numberForAnalysis < twenty)) {
            return getTeens(numberForAnalysis);
        } else {
            String tens = getTens(numberForAnalysis);
            String ones = getOnes(numberForAnalysis);

            return getSpaser(tens, ones, " ");
        }
    }


    public String toWord(final int number) {

        String words = "";

        int iter = 0;
        int numberForAnalysis = number;
        while (numberForAnalysis > 0) {
            int numberForAnalysisLow = numberForAnalysis % thousand;
            String firstPartLowOrder = getFirstPart(numberForAnalysisLow);
            String secondPartLowOrder = getSecondPart(numberForAnalysisLow);
            String partLowOrder = getSpaser(firstPartLowOrder, secondPartLowOrder, " and ");

            int numOfHighOrder = partLowOrder.equals("") ? 0 : iter;
            String partHighOrder = getSpaser(partLowOrder, getHighOrder(numOfHighOrder), " ");

            words = getSpaser(partHighOrder, words, ", ");

            numberForAnalysis = numberForAnalysis / thousand;
            iter = iter + 1;
        }

        return words;
    }
}
