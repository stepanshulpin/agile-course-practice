package ru.unn.agile.complexnumbercalculator.viewmodel;

public class ViewModel {
    private Operations operations;
    private String result;
    private String firstRe;
    private String firstIm;
    private String secondRe;
    private String secondIm;
    private String degree;
    private String errorText;

    private boolean isCalculateBottonEnabled;

    public enum Operations {
        ADD ("Сложить"),
        SUBTRACT ("Вычесть"),
        MULTIPLY ("Умножить"),
        DIVIDE ("Разделить"),
        POW ("Возвести в степень"),
        ROOT ("Извлечь корень"),
        CONJUGATION("Найти сопряженное");
        private final String name;

        Operations(final String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    public ViewModel(){
        result = "";
        firstRe = "";
        firstIm = "";
        secondRe = "";
        secondIm = "";
        degree = "";
        operations = operations.ADD;
        errorText = "";
        isCalculateBottonEnabled = false;
    }

    public String getResult(){
        return result;
    }

    public String getFirstRe(){
        return firstRe;
    }

    public String getFirstIm(){
        return firstIm;
    }

    public String getSecondRe(){
        return secondRe;
    }

    public String getSecondIm(){
        return secondIm;
    }

    public String getDegree(){
        return degree;
    }

    public Operations getOperations() {
        return operations;
    }

    public String getError(){
        return errorText;
    }

    public boolean isCalculateBottonEnabled() {
        return isCalculateBottonEnabled;
    }
}
