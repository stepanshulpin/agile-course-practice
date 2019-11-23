package ru.unn.agile.converter.viewmodel;

import javafx.beans.property.*;

public class ViewModel {

    private StringProperty input = new SimpleStringProperty();
    private StringProperty output = new SimpleStringProperty();
    private BooleanProperty btnDisabled = new SimpleBooleanProperty();

    public ViewModel() {
        input.set("");
        output.set("");
        btnDisabled.set(true);
    }

    public StringProperty getInput() {
        return input;
    }

    public StringProperty getOutput() {
        return output;
    }

    public BooleanProperty isConvertButtonDisabled() {
        return btnDisabled;
    }
}
