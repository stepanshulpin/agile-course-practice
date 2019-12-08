package ru.unn.agile.Matrix.view;

import javafx.fxml.FXML;
import ru.unn.agile.Matrix.viewmodel.ViewModel;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class Matrix {
    @FXML
    private ViewModel viewModel;
    @FXML
    private Button buttonCompare;
    @FXML
    private Button transposeFirst;
    @FXML
    private Button transposeSecond;
    @FXML
    private Button sumButton;
    @FXML
    private TextField first00 = new TextField();
    @FXML
    private TextField first10 = new TextField();
    @FXML
    private TextField first20 = new TextField();
    @FXML
    private TextField first01 = new TextField();
    @FXML
    private TextField first11 = new TextField();
    @FXML
    private TextField first21 = new TextField();
    @FXML
    private TextField first02 = new TextField();
    @FXML
    private TextField first12 = new TextField();
    @FXML
    private TextField first22 = new TextField();
    @FXML
    private TextField second00 = new TextField();
    @FXML
    private TextField second10 = new TextField();
    @FXML
    private TextField second20 = new TextField();
    @FXML
    private TextField second01 = new TextField();
    @FXML
    private TextField second11 = new TextField();
    @FXML
    private TextField second21 = new TextField();
    @FXML
    private TextField second02 = new TextField();
    @FXML
    private TextField second12 = new TextField();
    @FXML
    private TextField second22 = new TextField();
    @FXML
    private Label result00 = new Label();
    @FXML
    private Label result10 = new Label();
    @FXML
    private Label result20 = new Label();
    @FXML
    private Label result01 = new Label();
    @FXML
    private Label result11 = new Label();
    @FXML
    private Label result21 = new Label();
    @FXML
    private Label result02 = new Label();
    @FXML
    private Label result12 = new Label();
    @FXML
    private Label result22 = new Label();

    @FXML
    private TextField[] firstMatrixFields = new TextField[] {
            first00,
            first10,
            first20,
            first01,
            first11,
            first21,
            first02,
            first12,
            first22
    };


    @FXML
    void initialize() {
        first00.textProperty().bindBidirectional(viewModel.getFirstMatrixPropertiesByIndex("0"));
        first10.textProperty().bindBidirectional(viewModel.getFirstMatrixPropertiesByIndex("1"));
        first20.textProperty().bindBidirectional(viewModel.getFirstMatrixPropertiesByIndex("2"));
        first01.textProperty().bindBidirectional(viewModel.getFirstMatrixPropertiesByIndex("3"));
        first11.textProperty().bindBidirectional(viewModel.getFirstMatrixPropertiesByIndex("4"));
        first21.textProperty().bindBidirectional(viewModel.getFirstMatrixPropertiesByIndex("5"));
        first02.textProperty().bindBidirectional(viewModel.getFirstMatrixPropertiesByIndex("6"));
        first12.textProperty().bindBidirectional(viewModel.getFirstMatrixPropertiesByIndex("7"));
        first22.textProperty().bindBidirectional(viewModel.getFirstMatrixPropertiesByIndex("8"));

        second00.textProperty().bindBidirectional(viewModel.getSecondMatrixPropertiesByIndex("0"));
        second10.textProperty().bindBidirectional(viewModel.getSecondMatrixPropertiesByIndex("1"));
        second20.textProperty().bindBidirectional(viewModel.getSecondMatrixPropertiesByIndex("2"));
        second01.textProperty().bindBidirectional(viewModel.getSecondMatrixPropertiesByIndex("3"));
        second11.textProperty().bindBidirectional(viewModel.getSecondMatrixPropertiesByIndex("4"));
        second21.textProperty().bindBidirectional(viewModel.getSecondMatrixPropertiesByIndex("5"));
        second02.textProperty().bindBidirectional(viewModel.getSecondMatrixPropertiesByIndex("6"));
        second12.textProperty().bindBidirectional(viewModel.getSecondMatrixPropertiesByIndex("7"));
        second22.textProperty().bindBidirectional(viewModel.getSecondMatrixPropertiesByIndex("8"));

        result00.textProperty().bindBidirectional(viewModel.getResultMatrixPropertiesByIndex("0"));
        result10.textProperty().bindBidirectional(viewModel.getResultMatrixPropertiesByIndex("1"));
        result20.textProperty().bindBidirectional(viewModel.getResultMatrixPropertiesByIndex("2"));
        result01.textProperty().bindBidirectional(viewModel.getResultMatrixPropertiesByIndex("3"));
        result11.textProperty().bindBidirectional(viewModel.getResultMatrixPropertiesByIndex("4"));
        result21.textProperty().bindBidirectional(viewModel.getResultMatrixPropertiesByIndex("5"));
        result02.textProperty().bindBidirectional(viewModel.getResultMatrixPropertiesByIndex("6"));
        result12.textProperty().bindBidirectional(viewModel.getResultMatrixPropertiesByIndex("7"));
        result22.textProperty().bindBidirectional(viewModel.getResultMatrixPropertiesByIndex("8"));

        buttonCompare.setOnAction(actionEvent -> {
            viewModel.compareMatrices();
        });
        transposeFirst.setOnAction(actionEvent -> viewModel.transposeFirstMatrix());
        transposeSecond.setOnAction(actionEvent -> viewModel.transposeSecondMatrix());
        sumButton.setOnAction(actionEvent -> viewModel.sumMatrices());

    }


}
