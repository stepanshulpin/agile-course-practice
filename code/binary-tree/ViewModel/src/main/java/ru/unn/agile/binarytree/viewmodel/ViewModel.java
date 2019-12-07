package ru.unn.agile.binarytree.viewmodel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    private final StringProperty userKey = new SimpleStringProperty();

    private final StringProperty operationResult = new SimpleStringProperty();

    private final ObjectProperty<ObservableList<Operation>> operations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Operation.values()));

    private final ObjectProperty<Operation> operation = new SimpleObjectProperty<>();


    public ViewModel() {
        userKey.set("");
        operationResult.set("");
        operation.set(Operation.ADD);
    }

    public StringProperty operationResultProperty() {
        return operationResult;
    }

    public StringProperty userKeyProperty() {
        return userKey;
    }

    public ObjectProperty<Operation> operationProperty() {
        return operation;
    }
}

enum Operation {
    FIND,
    ADD,
    REMOVE
}