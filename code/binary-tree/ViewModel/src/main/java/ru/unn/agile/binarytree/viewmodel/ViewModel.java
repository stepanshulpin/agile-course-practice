package ru.unn.agile.binarytree.viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ViewModel {
    private final StringProperty findKey = new SimpleStringProperty();
    private final StringProperty addKey = new SimpleStringProperty();
    private final StringProperty removeKey = new SimpleStringProperty();

    private final StringProperty findResult = new SimpleStringProperty();
    private final StringProperty addResult = new SimpleStringProperty();
    private final StringProperty removeResult = new SimpleStringProperty();

    public ViewModel() {
        findKey.set("");
        addKey.set("");
        removeKey.set("");
        findResult.set("");
        addResult.set("");
        removeResult.set("");
    }

    public StringProperty findKeyProperty() {
        return findKey;
    }

    public StringProperty addKeyProperty() {
        return addKey;
    }

    public StringProperty removeKeyProperty() {
        return removeKey;
    }

    public StringProperty findResultProperty() {
        return findResult;
    }

    public StringProperty addResultProperty() {
        return addResult;
    }

    public StringProperty removeResultProperty() {
        return removeResult;
    }
}

