package ru.unn.agile.binarytree.viewmodel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import ru.unn.agile.binarytree.model.BinaryTree;

public class ViewModel {
    private BinaryTree binaryTree;

    public String getAddKey() {
        return addKey.get();
    }

    public StringProperty addKeyProperty() {
        return addKey;
    }

    public String getAddValue() {
        return addValue.get();
    }

    public StringProperty addValueProperty() {
        return addValue;
    }

    public String getAddResult() {
        return addResult.get();
    }

    public StringProperty addResultProperty() {
        return addResult;
    }

    public String getAddStatus() {
        return addStatus.get();
    }

    public StringProperty addStatusProperty() {
        return addStatus;
    }

    public String getFindKey() {
        return findKey.get();
    }

    public StringProperty findKeyProperty() {
        return findKey;
    }

    public String getFindResult() {
        return findResult.get();
    }

    public StringProperty findResultProperty() {
        return findResult;
    }

    public String getFindStatus() {
        return findStatus.get();
    }

    public StringProperty findStatusProperty() {
        return findStatus;
    }

    public String getRemoveKey() {
        return removeKey.get();
    }

    public StringProperty removeKeyProperty() {
        return removeKey;
    }

    public String getRemoveResult() {
        return removeResult.get();
    }

    public StringProperty removeResultProperty() {
        return removeResult;
    }

    public String getRemoveStatus() {
        return removeStatus.get();
    }

    public StringProperty removeStatusProperty() {
        return removeStatus;
    }

    private final StringProperty addKey = new SimpleStringProperty();
    private final StringProperty addValue = new SimpleStringProperty();
    private final StringProperty addResult = new SimpleStringProperty();
    private final StringProperty addStatus = new SimpleStringProperty();

    private final StringProperty findKey = new SimpleStringProperty();
    private final StringProperty findResult = new SimpleStringProperty();
    private final StringProperty findStatus = new SimpleStringProperty();

    private final StringProperty removeKey = new SimpleStringProperty();
    private final StringProperty removeResult = new SimpleStringProperty();
    private final StringProperty removeStatus = new SimpleStringProperty();

    public void add() {
        final int key = Integer.parseInt(addKey.get());
        final String value = addValue.get();

        binaryTree.add(key, value);
    }

    public ViewModel() {
        addKey.set("");
        addValue.set("");
        addResult.set("");
        addStatus.set(Status.WAITING.toString());

        findKey.set("");
        findResult.set("");
        findStatus.set(Status.WAITING.toString());

        removeKey.set("");
        removeResult.set("");
        removeStatus.set(Status.WAITING.toString());
    }
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