package ru.unn.agile.converter.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import ru.unn.agile.converter.model.LengthType;
import ru.unn.agile.converter.viewmodel.ViewModel;

public class LengthConverter {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField txtInput;
    @FXML
    private Label lblError;
    @FXML
    private TextField txtOutput;
    @FXML
    private ComboBox<LengthType> cbFromType;
    @FXML
    private ComboBox<LengthType> cbToType;
    @FXML
    private Button btnConvert;
    @FXML
    private Button btnSwap;

    @FXML
    void initialize() {

        txtInput.textProperty().bindBidirectional(viewModel.getInput());
        lblError.textProperty().bindBidirectional(viewModel.getError());
        txtOutput.textProperty().bindBidirectional(viewModel.getOutput());
        cbFromType.valueProperty().bindBidirectional(viewModel.getFromType());
        cbToType.valueProperty().bindBidirectional(viewModel.getToType());
        btnConvert.disableProperty().bindBidirectional(viewModel.isConvertButtonDisabled());
        btnConvert.setOnAction(event -> viewModel.convert());
        btnSwap.setOnAction(event -> viewModel.swap());

    }

}
