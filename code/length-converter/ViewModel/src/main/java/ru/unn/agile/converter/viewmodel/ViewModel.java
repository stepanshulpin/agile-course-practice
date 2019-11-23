package ru.unn.agile.converter.viewmodel;

import javafx.beans.property.*;

public class ViewModel {

    private StringProperty input = new SimpleStringProperty();
    private StringProperty output = new SimpleStringProperty();

    public ViewModel() {
        input.set("");
        output.set("");
    }

    public StringProperty getInput() {
        return input;
    }

    public StringProperty getOutput() {
        return output;
    }
}
