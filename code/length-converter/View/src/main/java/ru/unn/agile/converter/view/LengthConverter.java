package ru.unn.agile.converter.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import ru.unn.agile.converter.viewmodel.ViewModel;

public class LengthConverter {
    @FXML
    private ViewModel viewModel;
    @FXML
    private TextField txtInput;
    @FXML
    private TextField txtOutput;
    @FXML
    private ComboBox cbFromType;
    @FXML
    private ComboBox cbToType;
    @FXML
    private Button btnConvert;

    @FXML
    void initialize() {

        btnConvert.disableProperty().bindBidirectional(viewModel.isConvertButtonDisabled());

    }

}
