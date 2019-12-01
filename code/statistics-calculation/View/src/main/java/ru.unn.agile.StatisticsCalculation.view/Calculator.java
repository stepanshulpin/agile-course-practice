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
    private Button buttonAdd;
    @FXML
    private Button buttonDelete;
    @FXML
    private Button buttonCalculate;

    private ObservableList<TableElement> listData = FXCollections.observableArrayList();
    @FXML
    private TableView<TableElement> tableViewData;
    @FXML
    private TableColumn<TableElement, String> columnValue;
    @FXML
    private TableColumn<TableElement, String> columnProbabilitie;

    @FXML
    void initialize() {
        columnValue.setCellValueFactory(
                new PropertyValueFactory<TableElement, String>("value"));
        columnValue.setCellFactory(TextFieldTableCell.forTableColumn());
        columnValue.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<TableElement, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<TableElement, String> t) {
                        ((TableElement) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setValue(t.getNewValue());
                    }
                }
        );

        columnProbabilitie.setCellValueFactory(
                new PropertyValueFactory<TableElement, String>("probabilitie"));
        columnProbabilitie.setCellFactory(TextFieldTableCell.forTableColumn());
        columnProbabilitie.setOnEditCommit(
                new EventHandler<TableColumn.CellEditEvent<TableElement, String>>() {
                    @Override
                    public void handle(TableColumn.CellEditEvent<TableElement, String> t) {
                        ((TableElement) t.getTableView().getItems().get(
                                t.getTablePosition().getRow())
                        ).setProbabilitie(t.getNewValue());
                    }
                }
        );

        buttonAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                listData.add(new TableElement(
                        textfieldNewValue.getText(),
                        textfieldNewProbabilitie.getText()));
                textfieldNewValue.clear();
                textfieldNewProbabilitie.clear();
                tableViewData.setItems(listData);
            }
        });

        //listData.add(new TableElement("1", "0.2"));
        //listData.add(new TableElement("2", "0.2"));
        //tableViewData.setItems(listData);
    }
}
