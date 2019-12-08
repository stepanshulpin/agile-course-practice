package ru.unn.agile.vectorsdistancescalculator.viewmodel;

import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.vectorsdistancescalculator.model.VectorsDistancesCalculator.Operation;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {
    private final StringProperty x1 = new SimpleStringProperty();
    private final StringProperty y1 = new SimpleStringProperty();
    private final StringProperty z1 = new SimpleStringProperty();
    private final StringProperty x2 = new SimpleStringProperty();
    private final StringProperty y2 = new SimpleStringProperty();
    private final StringProperty z2 = new SimpleStringProperty();

    private final ObjectProperty<ObservableList<Operation>> operations =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Operation.values()));
    private final ObjectProperty<Operation> operation = new SimpleObjectProperty<>();
    private final BooleanProperty calculationDisabled = new SimpleBooleanProperty();

    private final StringProperty result = new SimpleStringProperty();
    private final StringProperty status = new SimpleStringProperty();

    private final List<ValueChangeListener> valueChangedListeners = new ArrayList<>();

    public ViewModel() {
        x1.set("");
        y1.set("");
        z1.set("");
        x2.set("");
        y2.set("");
        z2.set("");
        operation.set(Operation.CALCULATE_L1_DISTANCE);
        result.set("");
        status.set(Status.WAITING.toString());

        BooleanBinding couldCalculate = new BooleanBinding() {
            {
                super.bind(x1, y1, z1, x2, y2, z2);
            }
            @Override
            protected boolean computeValue() {
                return getInputStatus() == Status.READY;
            }
        };
        calculationDisabled.bind(couldCalculate.not());

        final List<StringProperty> fields = new ArrayList<>() { {
            add(x1);
            add(y1);
            add(z1);
            add(x2);
            add(y2);
            add(z2);
        } };

        for (StringProperty field : fields) {
            final ValueChangeListener listener = new ValueChangeListener();
            field.addListener(listener);
            valueChangedListeners.add(listener);
        }
    }

    private Status getInputStatus() {
        Status inputStatus = Status.READY;
        if (x1.get().isEmpty() || y1.get().isEmpty()
                || z1.get().isEmpty() || x2.get().isEmpty()
                || y2.get().isEmpty() || z2.get().isEmpty()) {
            inputStatus = Status.WAITING;
        }
        try {
            if (!x1.get().isEmpty()) {
                Double.parseDouble(x1.get());
            }
            if (!y1.get().isEmpty()) {
                Double.parseDouble(y1.get());
            }
            if (!z1.get().isEmpty()) {
                Double.parseDouble(z1.get());
            }
            if (!x2.get().isEmpty()) {
                Double.parseDouble(x2.get());
            }
            if (!y2.get().isEmpty()) {
                Double.parseDouble(y2.get());
            }
            if (!z2.get().isEmpty()) {
                Double.parseDouble(z2.get());
            }
        } catch (NumberFormatException nfe) {
            inputStatus = Status.BAD_FORMAT;
        }

        return inputStatus;
    }

    public StringProperty x1Property() {
        return x1;
    }
    public StringProperty y1Property() {
        return y1;
    }
    public StringProperty z1Property() {
        return z1;
    }
    public StringProperty x2Property() {
        return x2;
    }
    public StringProperty y2Property() {
        return y2;
    }
    public StringProperty z2Property() {
        return z2;
    }
    public ObjectProperty<Operation> operationProperty() {
        return operation;
    }
    public StringProperty resultProperty() {
        return result;
    }
    public StringProperty statusProperty() {
        return status;
    }
    public BooleanProperty calculationDisabledProperty() {
        return calculationDisabled;
    }

    private class ValueChangeListener implements ChangeListener<String> {
        @Override
        public void changed(final ObservableValue<? extends String> observable,
                            final String oldValue, final String newValue) {
            status.set(getInputStatus().toString());
        }
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
