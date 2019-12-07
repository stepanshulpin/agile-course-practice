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
    private final StringProperty status = new SimpleStringProperty();


    public ViewModel() {
        userKey.set("");
        operationResult.set("");
        operation.set(Operation.ADD);
        status.set(Status.WAITING.toString());
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

    public StringProperty statusProperty() {
        return status;
    }
}

enum Operation {
    FIND,
    ADD,
    REMOVE
}

enum Status {
    WAITING("Please provide input data"),
    READY("Press 'Calculate' or Enter"),
    BAD_FORMAT("Bad format"),
    SUCCESS("Success");

    private final String name;
    Status(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}