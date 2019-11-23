package ru.unn.agile.converter.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ru.unn.agile.converter.model.LengthType;
import ru.unn.agile.converter.viewmodel.ViewModel;

public class LengthConverter {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField txtInput;
    @FXML
    private TextField txtOutput;
    @FXML
    private ComboBox<LengthType> cbFromType;
    @FXML
    private ComboBox<LengthType> cbToType;
    @FXML
    private Button btnConvert;

    @FXML
    void initialize() {

        cbFromType.valueProperty().bindBidirectional(viewModel.getFromType());
        cbToType.valueProperty().bindBidirectional(viewModel.getToType());
        btnConvert.disableProperty().bindBidirectional(viewModel.isConvertButtonDisabled());

    }

}
