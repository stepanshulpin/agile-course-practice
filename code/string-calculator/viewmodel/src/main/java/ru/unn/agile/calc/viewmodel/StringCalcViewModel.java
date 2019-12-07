package ru.unn.agile.calc.viewmodel;

import javafx.beans.property.*;
import ru.unn.agile.calc.model.StringCalc;

public class StringCalcViewModel {

    private final SimpleStringProperty expressionTf = new SimpleStringProperty();
    private final SimpleStringProperty resultLbl = new SimpleStringProperty();

    private final StringCalc calculator = new StringCalc();

    public StringCalcViewModel() {
        expressionTf.set("");
        resultLbl.set("");
    }

    public void calculate() {
        try {
            String calcResult = String.valueOf(calculator.result(expressionTf.get()));
            resultLbl.setValue((calcResult));
        } catch (Exception e) {
            resultLbl.setValue("Error. Check your input");
        }
    }

    public StringProperty expressionTfProperty() {
        return expressionTf;
    }

    public StringProperty resultLblProperty() {
        return resultLbl;
    }

}
