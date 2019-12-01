package ru.unn.agile.StatisticsCalculation.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.text.Text;
import javafx.util.Callback;
import ru.unn.agile.StatisticsCalculation.viewmodel.TableElement;
import ru.unn.agile.StatisticsCalculation.viewmodel.ViewModel;


public class Calculator {
    @FXML
    private ViewModel viewModel;

    @FXML
    private TextField textfieldNewValue;
    @FXML
    private TextField textfieldNewProbabilitie;

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
    private TableColumn<TableElement, String> columnProbabilitie;

    @FXML
    void initialize() {
        textfieldNewValue.textProperty().bindBidirectional(viewModel.newValueProperty());
        textfieldNewProbabilitie.textProperty().bindBidirectional(viewModel.newProbabilitieProperty());

        columnValue.setCellValueFactory(new PropertyValueFactory<TableElement, String>("value"));

        columnProbabilitie.setCellValueFactory(new PropertyValueFactory<TableElement, String>("probabilitie"));

        buttonUpdate.setOnAction(event -> {
            viewModel.addNewTableElement();
            tableViewData.setItems(viewModel.getListData());
        });

        //listData.add(new TableElement("1", "0.2"));
        //listData.add(new TableElement("2", "0.2"));
        //tableViewData.setItems(listData);
    }
}
