package ru.unn.agile.StatisticsCalculation.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.StatisticsCalculation.model.StatisticsCalculation;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    private final StringProperty newValue = new SimpleStringProperty();
    private final StringProperty newProbabilitie = new SimpleStringProperty();

    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty operationStatus = new SimpleStringProperty();
    private final StringProperty dataStatus = new SimpleStringProperty();

    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();
    private final BooleanProperty deleteDisabled = new SimpleBooleanProperty();

    //private final ObservableList<TableElement> listData = new ;

    // FXML needs default c-tor for binding
    public ViewModel() {
        newValue.set("");
        newProbabilitie.set("");
        result.set("");
        operationStatus.set(OperationStatus.WAITING.toString());
        dataStatus.set(DataStatus.WAITING.toString());
        calculationDisabled.set(true);
        deleteDisabled.set(true);
    }

    public StringProperty newValueProperty() {
        return newValue;
    }
    public StringProperty newProbabilitieProperty() {
        return newProbabilitie;
    }

    public StringProperty resultProperty() {
        return result;
    }
    public final String getResult() {
        return result.get();
    }
    public StringProperty operationStatusProperty() {
        return operationStatus;
    }
    public final String getOperationStatus() {
        return operationStatus.get();
    }
    public StringProperty dataStatusProperty() {
        return dataStatus;
    }
    public final String getDataStatus() {
        return dataStatus.get();
    }

    public BooleanProperty calculationDisabledProperty() {
        return calculationDisabled;
    }
    public final boolean isCalculationDisabled() {
        return calculationDisabled.get();
    }
    public BooleanProperty deleteDisabledProperty() {
        return deleteDisabled;
    }
    public final boolean isDeleteDisabled() {
        return deleteDisabled.get();
    }

}

enum DataStatus {
    WAITING("Enter data"),
    READY("Data is correct"),
    BAD_FORMAT("Data error");

    private final String name;
    DataStatus(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}

enum OperationStatus {
    WAITING("Choose an operation"),
    READY("Press 'Calculate'"),
    BAD_FORMAT("Enter parameter"),
    SUCCESS("Success");

    private final String name;
    OperationStatus(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
    }
}
