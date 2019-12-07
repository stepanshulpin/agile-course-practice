package ru.unn.agile.binarytree.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModel {
    private final StringProperty userKey = new SimpleStringProperty();

    private final StringProperty operationResult = new SimpleStringProperty();

    public ViewModel() {
        userKey.set("");
        operationResult.set("");
    }

    public StringProperty userKeyProperty() {
        return userKey;
    }

    public StringProperty findResultProperty() {
        return operationResult;
    }
}

