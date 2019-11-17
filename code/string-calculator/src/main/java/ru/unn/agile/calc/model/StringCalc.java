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
            char firstSymbol = string.charAt(0);
            String[] parsedNumbers = string.split("\\+|\\-");
            String[] parsedOperators = string.split("[1234567890\\.a-z]*");
            int index = 0;
            if (firstSymbol == '-') {
                index++;
                parsedNumbers[index] = "-" + parsedNumbers[index];
            }
            double result = Double.parseDouble(parsedNumbers[index]);
            index++;
            boolean flag = false;
            if (firstSymbol != '-') {
                flag = true;
            }
            for (String operator : parsedOperators) {
                if (operator.equals("+") && flag) {
                    result += Double.parseDouble(parsedNumbers[index]);
                    index++;
                }
                else if (operator.equals("-") && flag) {
                    result -= Double.parseDouble(parsedNumbers[index]);
                    index++;
                }
                flag = true;
            }
            return result;
        } catch (NumberFormatException e) {throw new NumberFormatException("String can't contain letters");}
    }
}