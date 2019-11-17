package ru.unn.agile.calc.model;

public class StringCalc {
    public StringCalc() {

    }

    public double result(String string) {
        return parseString(string);
    }

    private double parseString(String string) {
        try
        {
            double foo = Double.parseDouble(string);
            return foo;
        } catch (NumberFormatException e) {}
        try {
            String[] parsedNumbers = string.split("\\+");
            double result = 0;
            for (String number : parsedNumbers) {
                result += Double.parseDouble(number);
            }
            return result;
        } catch (NumberFormatException e) {throw new NumberFormatException("String can't contain letters");}
    }
}