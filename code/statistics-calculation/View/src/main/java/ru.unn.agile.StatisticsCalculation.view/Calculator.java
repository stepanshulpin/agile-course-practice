package ru.unn.agile.StatisticsCalculation.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import ru.unn.agile.StatisticsCalculation.viewmodel.ViewModel;

public class Calculator {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField txtValue;
    @FXML
    private TextField txtProbabilitie;
    @FXML
    private Button btnCalc;

    @FXML
    void initialize() {

        // Two-way binding hasn't supported by FXML yet, so place it in code-behind
        txtValue.textProperty().bindBidirectional(viewModel.newValueProperty());
        txtProbabilitie.textProperty().bindBidirectional(viewModel.newProbabilitieProperty());

        btnCalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.calculate();
            }
        });
    }
}
