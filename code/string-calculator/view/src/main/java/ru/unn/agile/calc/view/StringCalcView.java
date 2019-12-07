package ru.unn.agile.calc.view;

import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import ru.unn.agile.calc.viewmodel.StringCalcViewModel;

public class StringCalcView {

    private final PseudoClass errorClass = PseudoClass.getPseudoClass("error");
    private final String tooltip = "Type your expression here";

    @FXML
    private StringCalcViewModel viewModel;
    @FXML
    private TextField expressionTf;
    @FXML
    private Label resultLbl;
    @FXML
    private Button calcBtn;

    @FXML
    void initialize() {

        expressionTf.textProperty().bindBidirectional(viewModel.expressionTfProperty());
        expressionTf.tooltipProperty().setValue(new Tooltip(tooltip));
        resultLbl.textProperty().bindBidirectional(viewModel.resultLblProperty());

        viewModel.expressionTfProperty()
                .addListener(obs  -> setErrorBorder(!viewModel.isExpressionValid()));

        calcBtn.disableProperty().bindBidirectional(viewModel.calculationDisabledProperty());

        calcBtn.setOnAction(e -> viewModel.calculate());
    }

    private void setErrorBorder(final boolean active) {
        expressionTf.pseudoClassStateChanged(errorClass, active);
    }

}
