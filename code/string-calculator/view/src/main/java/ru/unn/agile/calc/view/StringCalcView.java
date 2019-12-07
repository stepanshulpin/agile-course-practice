package ru.unn.agile.calc.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ru.unn.agile.calc.viewmodel.StringCalcViewModel;

public class StringCalcView {

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
        resultLbl.textProperty().bindBidirectional(viewModel.resultLblProperty());
    }

}
