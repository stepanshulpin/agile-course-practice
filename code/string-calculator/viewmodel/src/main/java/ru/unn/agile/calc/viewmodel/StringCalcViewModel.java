package ru.unn.agile.calc.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import ru.unn.agile.calc.model.StringCalc;

import java.util.regex.Pattern;

public class StringCalcViewModel {

    private static final Pattern ALLOWED_SYMBOLS = Pattern.compile("[\\d-+*/.\\s]");
    private static final String ERROR_MESSAGE = "Error. Check your input";

    private final SimpleStringProperty expressionTf = new SimpleStringProperty();
    private final SimpleStringProperty resultLbl = new SimpleStringProperty();
    private final SimpleBooleanProperty calculationDisabled = new SimpleBooleanProperty();

    private final StringCalc calculator = new StringCalc();

    public StringCalcViewModel() {
        expressionTf.set("");
        resultLbl.set("");
        BooleanBinding canCalculateBoolBinding = new BooleanBinding() {
            {
                super.bind(expressionTf);
            }
            @Override
            protected boolean computeValue() {
                return isExpressionValid();
            }
        };
        calculationDisabled.bind(canCalculateBoolBinding.not());
    }

    public void calculate() {
        if (!isCalculationDisabled()) {
            try {
                String calcResult = String.valueOf(calculator.result(expressionTf.get()));
                resultLbl.setValue((calcResult));
            } catch (Exception e) {
                resultLbl.setValue(ERROR_MESSAGE);
            }
        }
    }

    public boolean isExpressionValid() {
        String exprText = expressionTf.get().trim();
        return !(exprText.isEmpty() || hasRestrictedSymbols(exprText));
    }

    private boolean hasRestrictedSymbols(final String input) {
        return input.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .anyMatch(symbol -> !ALLOWED_SYMBOLS.matcher(symbol).matches());
    }

    public StringProperty expressionTfProperty() {
        return expressionTf;
    }

    public StringProperty resultLblProperty() {
        return resultLbl;
    }

    private boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }

    public BooleanProperty calculationDisabledProperty() {
        return calculationDisabled;
    }

}
