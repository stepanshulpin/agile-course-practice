package ru.unn.agile.calc.model;

import java.util.ArrayList;
import java.util.List;

public class StringCalc {
    public StringCalc() {

    }

    public double result(final String string) {
        return parseString(string);
    }

    private double parseString(final String string) {
        try {
            char firstSymbol = string.charAt(0);
            String[] parsedNumbers = string.split("\\+|\\-|\\*|\\/");
            String[] parsedOperators = string.split("[1234567890\\.a-z]*");
            int index = 0;
            if (firstSymbol == '-') {
                index++;
                parsedNumbers[index] = "-" + parsedNumbers[index];
                parsedOperators[0] = "";
            }

            List<Integer> priorityList = new ArrayList<Integer>();
            List<String> operationsList = new ArrayList<String>();

            for (String operator : parsedOperators) {
                if (operator.equals("+")){
                    priorityList.add(0);
                    operationsList.add("+");
                }
                else if (operator.equals("-")) {
                    priorityList.add(0);
                    operationsList.add("-");
                }
                else if (operator.equals("*")) {
                    priorityList.add(1);
                    operationsList.add("*");
                }
                else if (operator.equals("/")) {
                    priorityList.add(1);
                    operationsList.add("/");
                }
            }

            double[] numbers = new double[parsedNumbers.length - index];
            for(int i = 0; i < parsedNumbers.length - index; i++) numbers[i] =
                    Double.parseDouble(parsedNumbers[i + index]);

            String[] operationsArray = new String[operationsList.size()];
            operationsList.toArray(operationsArray);

            double result = 0;
            if (operationsArray.length == 0) {
                return numbers[0];
            }

            boolean flag = true;
            double tmp = 0;
            for (int i = 0; i < operationsArray.length; i++) {
                if (operationsArray[i].equals("/")) {
                    tmp = numbers[i] / numbers[i + 1];
                    numbers[i] = tmp;
                    numbers[i + 1] = tmp;
                } else if (operationsArray[i].equals("*")) {
                    tmp = numbers[i] * numbers[i + 1];
                    numbers[i] = tmp;
                    numbers[i + 1] = tmp;
                } else if (operationsArray[i].equals("+") || operationsArray[i].equals("-")) {
                    flag = false;
                }
            }

            if (flag) {
                return tmp;
            }

            for (int i = 0; i < operationsArray.length; i++) {
                if (operationsArray[i].equals("+")) {
                    tmp = numbers[i] + numbers[i + 1];
                    numbers[i + 1] = tmp;
                    result = tmp;
                } else if (operationsArray[i].equals("-")) {
                    tmp = numbers[i] - numbers[i + 1];
                    numbers[i + 1] = tmp;
                    result = tmp;
                }
            }

            return result;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("String can't contain letters");
        }
    }
}
