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
    private final StringProperty imputDataStatus = new SimpleStringProperty();

    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();
    private final BooleanProperty deleteDisabled = new SimpleBooleanProperty();
    private final BooleanProperty addDisabled = new SimpleBooleanProperty();

    private final ObservableList<TableElement> listData = FXCollections.observableArrayList();

    private final List<ValueChangeListener> valueChangedListeners = new ArrayList<>();
    // FXML needs default c-tor for binding
    public ViewModel() {
        newValue.set("");
        newProbabilitie.set("");
        result.set("");
        operationStatus.set(OperationStatus.WAITING.toString());
        dataStatus.set(DataStatus.WAITING.toString());
        imputDataStatus.set(InputDataStatus.WAITING.toString());

        BooleanBinding couldAddNewData = new BooleanBinding() {
            {
                super.bind(newValue, newProbabilitie);
            }
            @Override
            protected boolean computeValue() {
                return getInputDataStatus() == InputDataStatus.READY;
            }
        };
        addDisabled.bind(couldAddNewData.not());

        final List<StringProperty> fields = new ArrayList<StringProperty>() { {
            add(newValue);
            add(newProbabilitie);
        } };

        for (StringProperty field : fields) {
            final ValueChangeListener listener = new ValueChangeListener();
            field.addListener(listener);
            valueChangedListeners.add(listener);
        }
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
    public StringProperty imputDataStatusProperty() {
        return imputDataStatus;
    }
    public final String getImputDataStatus() { return imputDataStatus.get(); }

    public ObservableList<TableElement> getListData() {return listData;}

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
    public BooleanProperty addDisabledProperty() {
        return addDisabled;
    }
    public final boolean isAddDisabled() {
        return addDisabled.get();
    }

    public void addNewTableElement() {
        imputDataStatus.set(getInputDataStatus().toString());
        if(getInputDataStatus() ==  InputDataStatus.READY) {
            listData.add(new TableElement(newValue.getValue(), newProbabilitie.getValue()));
            newValue.set("");
            newProbabilitie.set("");
            imputDataStatus.set(getImputDataStatus());
        }
    }

    private InputDataStatus getInputDataStatus() {
        InputDataStatus inputDataStatus = InputDataStatus.READY;
        if (newValueProperty().get().isEmpty() || newProbabilitieProperty().get().isEmpty()) {
            inputDataStatus = InputDataStatus.WAITING;
        }
        try {
            if (!newValueProperty().get().isEmpty()) {
                Double.parseDouble(newValueProperty().get());
            }
            if (!newProbabilitieProperty().get().isEmpty()) {
                Double.parseDouble(newProbabilitieProperty().get());
                if (Double.parseDouble(newProbabilitieProperty().get()) > 1.0){
                    inputDataStatus = InputDataStatus.BAD_FORMAT;
                }
            }
        } catch (NumberFormatException nfe) {
            inputDataStatus = InputDataStatus.BAD_FORMAT;
        }

        return inputDataStatus;
    }

    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            imputDataStatus.set(getInputDataStatus().toString());
        }
    }
}

enum InputDataStatus {
    WAITING("Enter data"),
    READY("Input data is correct"),
    BAD_FORMAT("Input data error");

    private final String name;
    InputDataStatus(final String name) {
        this.name = name;
    }
    public String toString() {
        return name;
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
