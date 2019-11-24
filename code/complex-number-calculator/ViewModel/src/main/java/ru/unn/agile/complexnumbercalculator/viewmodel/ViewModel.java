package ru.unn.agile.complexnumbercalculator.viewmodel;

import ru.unn.agile.complexnumbercalculator.model.ComplexNumber;
import ru.unn.agile.complexnumbercalculator.model.ComplexNumberCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ViewModel {
    private Operations operations;
    private String result;
    private String firstRe;
    private String firstIm;
    private String secondRe;
    private String secondIm;
    private String degree;
    private String errorText;

    private boolean isCalculateButtonEnabled;
    private boolean isDegreeVisible;
    private boolean isErrorMessageDisplayed;

    private int ENTER = 10;
    private int ANY = 1111;

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
        isCalculateButtonEnabled = false;
        isDegreeVisible = false;
        isErrorMessageDisplayed = false;
    }

    public String getResult(){
        return result;
    }

    public String getFirstRe(){
        return firstRe;
    }

    public void setFirstRe(String firstRe){
        this.firstRe = firstRe;
    }

    public String getFirstIm(){
        return firstIm;
    }

    public void setFirstIm(String firstIm){

        this.firstIm = firstIm;
    }

    public String getSecondRe(){
        return secondRe;
    }

    public void setSecondRe(String secondRe){
        this.secondRe = secondRe;
    }

    public String getSecondIm(){
        return secondIm;
    }

    public void setSecondIm(String secondIm){
        this.secondIm = secondIm;
    }

    public String getDegree(){
        return degree;
    }

    public Operations getOperations() {
        return operations;
    }

    public void setOperations(Operations operation){
        this.operations = operation;
    }

    public String getError(){
        return errorText;
    }

    private void setError(){
        if(isErrorMessageDisplayed) {
            errorText = "Ошибка: нужно ввести корректные значения!";
        }
        else{
            errorText ="";
        }
    }

    public boolean isCalculateButtonEnabled() {
        return isCalculateButtonEnabled;
    }

    public boolean isDegreeVisible() {
        return isDegreeVisible;
    }

    public boolean isErrorMessageDisplayed() {
        return isErrorMessageDisplayed;
    }

    private boolean isAllDataFilled (){
        return (!getFirstRe().isEmpty() && !getFirstIm().isEmpty() && !getSecondRe().isEmpty() && !getSecondIm().isEmpty());
    }

    public void processFields(final int keyCode) {
        hideDegree();
        if (isAllDataFilled()){
            isCalculateButtonEnabled = true;
        }
        if (keyCode == ENTER) {
            calculate();
        }
    }

    public void calculate(){
        processFields(ANY);
        if (isCalculateButtonEnabled()){
            if(getOperations().equals(Operations.ADD)) {
                ComplexNumber z1 = ComplexNumber.createAlgebraicForm(Double.parseDouble(getFirstRe()), Double.parseDouble(getFirstIm()));
                ComplexNumber z2 = ComplexNumber.createAlgebraicForm(Double.parseDouble(getSecondRe()), Double.parseDouble(getSecondIm()));
                result = ComplexNumberCalculator.add(z1, z2).toString();
            }
            else if (getOperations().equals(Operations.SUBTRACT)){
                ComplexNumber z1 = ComplexNumber.createAlgebraicForm(Double.parseDouble(getFirstRe()), Double.parseDouble(getFirstIm()));
                ComplexNumber z2 = ComplexNumber.createAlgebraicForm(Double.parseDouble(getSecondRe()), Double.parseDouble(getSecondIm()));
                result = ComplexNumberCalculator.subtract(z1, z2).toString();
            }
            else if (getOperations().equals(Operations.MULTIPLY)){
                ComplexNumber z1 = ComplexNumber.createAlgebraicForm(Double.parseDouble(getFirstRe()), Double.parseDouble(getFirstIm()));
                ComplexNumber z2 = ComplexNumber.createAlgebraicForm(Double.parseDouble(getSecondRe()), Double.parseDouble(getSecondIm()));
                result = ComplexNumberCalculator.multiply(z1, z2).toString();
            }
        }
    }

    private void hideDegree(){
        if(getOperations().equals(Operations.ADD)|| getOperations().equals(Operations.SUBTRACT)||getOperations().equals(Operations.MULTIPLY)){
            isDegreeVisible = false;
        }
        if(getOperations().equals(Operations.POW)){
            isDegreeVisible = true;
        }
    }

    private boolean matchNumberInput(String line){
        boolean result = false;
        String pattern = "-?(\\d+)(\\.(\\d+))?";
        Pattern p  = Pattern.compile(pattern);
        if (!line.isEmpty()) {
            Matcher m = p.matcher(line);
            result = m.matches();
        }
        return result;
    }

    private boolean matchDegreeInput(String line){
        boolean result = false;
        String pattern = "-?(\\d+)";
        Pattern p  = Pattern.compile(pattern);
        if (!line.isEmpty()) {
            Matcher m = p.matcher(line);
            result = m.matches();
        }
        return result;
    }

    public void processInput(){
        boolean matchRe1 = matchNumberInput(getFirstRe());
        boolean matchIm1 = matchNumberInput(getFirstIm());
        boolean matchRe2 = matchNumberInput(getSecondRe());
        boolean matchIm2 = matchNumberInput(getSecondIm());
        if (matchRe1 && matchIm1 && matchRe2 && matchIm2) {
            isCalculateButtonEnabled = true;
            isErrorMessageDisplayed = false;
        }
        else {
            isCalculateButtonEnabled = false;
            isErrorMessageDisplayed = true;
        }
        setError();
    }
}
