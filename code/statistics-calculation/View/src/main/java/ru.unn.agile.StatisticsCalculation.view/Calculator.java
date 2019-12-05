package ru.unn.agile.StatisticsCalculation.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ru.unn.agile.StatisticsCalculation.viewmodel.Operation;
import ru.unn.agile.StatisticsCalculation.viewmodel.TableElement;
import ru.unn.agile.StatisticsCalculation.viewmodel.ViewModel;


public class Calculator {
    @FXML
    private ViewModel viewModel;

    @FXML
    private TextField textfieldNewValue;
    @FXML
    private TextField textfieldNewProbability;
    @FXML
    private TextField textfieldParameter;

    @FXML
    private ComboBox<Operation> comboBoxOperation;

    @FXML
    private Button buttonUpdate;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonCalculate;

    @FXML
    private TableView<TableElement> tableViewData;
    @FXML
    private TableColumn<TableElement, String> columnValue;
    @FXML
    private TableColumn<TableElement, String> columnProbability;

    @FXML
    void initialize() {
        textfieldNewValue.textProperty().bindBidirectional(viewModel.newValueProperty());
        textfieldNewProbability.textProperty().bindBidirectional(
                viewModel.newProbabilityProperty());
        textfieldParameter.textProperty().bindBidirectional(
                viewModel.operationParameterProperty());

        comboBoxOperation.valueProperty().bindBidirectional(viewModel.operationProperty());

        columnValue.setCellValueFactory(
                new PropertyValueFactory<TableElement, String>("value"));
        columnProbability.setCellValueFactory(
                new PropertyValueFactory<TableElement, String>("probability"));

        buttonUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.updateTableElement(tableViewData.getSelectionModel().getFocusedIndex());
                tableViewData.setItems(viewModel.getListData());
                tableViewData.getSelectionModel().clearSelection();
            }
        });

        buttonDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.deleteTableElement(tableViewData.getSelectionModel().getFocusedIndex());
                tableViewData.setItems(viewModel.getListData());
                tableViewData.getSelectionModel().clearSelection();
            }
        });

        tableViewData.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(final MouseEvent event) {
                viewModel.selectElement(tableViewData.getSelectionModel().getFocusedIndex());
            }
        });

        comboBoxOperation.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.updateOperation();
            }
        });

        buttonCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(final ActionEvent event) {
                viewModel.calculate();
            }
        });
    }
}
