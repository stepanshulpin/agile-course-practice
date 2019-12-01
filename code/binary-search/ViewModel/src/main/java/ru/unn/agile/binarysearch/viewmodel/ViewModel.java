package ru.unn.agile.binarysearch.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModel {
    private final StringProperty arrayInput = new SimpleStringProperty();
    private final StringProperty elementInput = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();
    private final StringProperty result = new SimpleStringProperty();

    public ViewModel() {
        arrayInput.set("");
        elementInput.set("");
        status.set("");
        result.set("");
    };

    public StringProperty arrayInputProperty() {
        return arrayInput;
    }
    public StringProperty elementInputProperty() {
        return elementInput;
    }
    public StringProperty statusProperty() {
        return status;
    }
    public StringProperty resultProperty() {
        return result;
    }

    public String getArrayInputProperty() {
        return arrayInput.get();
    }
    public String getElementInputProperty() {
        return elementInput.get();
    }
    public String getStatusProperty() {
        return status.get();
    }
    public String getResultProperty() {
        return result.get();
    }
}
