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
    private boolean isSecondNumberVisible;

    private int ENTER = 10;

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
        isSecondNumberVisible = true;
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

    public void setDegree(String degree){
        this.degree = degree;
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

    public boolean isSecondNumberVisible() {
        return isSecondNumberVisible;
    }

    public void processEnterPress(final int keyCode) {
        if (keyCode == ENTER) {
            calculate();
        }
    }

    public void calculate(){
        processInput();
        if (isCalculateButtonEnabled()){
            result = "";
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
            else if (getOperations().equals(Operations.DIVIDE)){
                ComplexNumber z1 = ComplexNumber.createAlgebraicForm(Double.parseDouble(getFirstRe()), Double.parseDouble(getFirstIm()));
                ComplexNumber z2 = ComplexNumber.createAlgebraicForm(Double.parseDouble(getSecondRe()), Double.parseDouble(getSecondIm()));
                result = ComplexNumberCalculator.divide(z1, z2).toString();
            }
            else if (getOperations().equals(Operations.POW)){
                ComplexNumber z = ComplexNumber.createAlgebraicForm(Double.parseDouble(getFirstRe()), Double.parseDouble(getFirstIm()));
                result = ComplexNumberCalculator.pow(z, Integer.parseInt(getDegree())).toString();
            }
            else if (getOperations().equals(Operations.ROOT)){
                ComplexNumber z = ComplexNumber.createAlgebraicForm(Double.parseDouble(getFirstRe()), Double.parseDouble(getFirstIm()));
                ComplexNumber [] result_list = ComplexNumberCalculator.extractRoot(z, Integer.parseInt(getDegree()));
                for (int i=0; i<result_list.length;i++){
                    result += result_list[i].toString() + "; ";
                }
            }
            else if (getOperations().equals(Operations.CONJUGATION)){
                ComplexNumber z = ComplexNumber.createAlgebraicForm(Double.parseDouble(getFirstRe()), Double.parseDouble(getFirstIm()));
                result = ComplexNumberCalculator.conjugation(z).toString();
            }
        }
    }

    private void hideDegree(){
        if(getOperations().equals(Operations.ADD)|| getOperations().equals(Operations.ROOT) || getOperations().equals(Operations.SUBTRACT)||getOperations().equals(Operations.MULTIPLY)||getOperations().equals(Operations.DIVIDE)){
            isDegreeVisible = false;
        }
        if(getOperations().equals(Operations.POW)|| getOperations().equals(Operations.ROOT)){
            isDegreeVisible = true;
        }
    }

    private void hideSecondNumber(){
        if(getOperations().equals(Operations.POW)|| getOperations().equals(Operations.ROOT) || getOperations().equals(Operations.CONJUGATION)){
            isSecondNumberVisible = false;
        }
        if(getOperations().equals(Operations.ADD)|| getOperations().equals(Operations.SUBTRACT)||getOperations().equals(Operations.MULTIPLY)||getOperations().equals(Operations.DIVIDE)){
            isSecondNumberVisible = true;
        }
    }

    public void hideUnnecessaryFields(){
        hideDegree();
        hideSecondNumber();
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
        if (getOperations().equals(Operations.CONJUGATION)){
            boolean matchRe1 = matchNumberInput(getFirstRe());
            boolean matchIm1 = matchNumberInput(getFirstIm());
            if (matchRe1 && matchIm1) {
                isCalculateButtonEnabled = true;
                isErrorMessageDisplayed = false;
            }
            else {
                isCalculateButtonEnabled = false;
                isErrorMessageDisplayed = true;
            }
            setError();
            return;
        }
        if (getOperations().equals(Operations.POW) || getOperations().equals(Operations.ROOT)){
            boolean matchRe1 = matchNumberInput(getFirstRe());
            boolean matchIm1 = matchNumberInput(getFirstIm());
            boolean matchDegree = matchDegreeInput(getDegree());
            if (matchRe1 && matchIm1 && matchDegree) {
                isCalculateButtonEnabled = true;
                isErrorMessageDisplayed = false;
                if(getOperations().equals(Operations.ROOT)){
                    if(Integer.parseInt(getDegree()) < 0){
                        isCalculateButtonEnabled = false;
                        isErrorMessageDisplayed = true;
                    }
                }
            }
            else {
                isCalculateButtonEnabled = false;
                isErrorMessageDisplayed = true;
            }
            setError();
            return;
        }
        boolean matchRe1 = matchNumberInput(getFirstRe());
        boolean matchIm1 = matchNumberInput(getFirstIm());
        boolean matchRe2 = matchNumberInput(getSecondRe());
        boolean matchIm2 = matchNumberInput(getSecondIm());
        if (matchRe1 && matchIm1 && matchRe2 && matchIm2) {
            isCalculateButtonEnabled = true;
            isErrorMessageDisplayed = false;
            if(getOperations().equals(Operations.DIVIDE)){
                ComplexNumber z = ComplexNumber.createAlgebraicForm(Double.parseDouble(getSecondRe()), Double.parseDouble(getSecondIm()));
                ComplexNumber zero = ComplexNumber.createAlgebraicForm(0.0, 0.0);
                if(z.equals(zero)){
                    isCalculateButtonEnabled = false;
                    isErrorMessageDisplayed = true;
                }
            }
        }
        else {
            isCalculateButtonEnabled = false;
            isErrorMessageDisplayed = true;
        }
        setError();
    }
}
