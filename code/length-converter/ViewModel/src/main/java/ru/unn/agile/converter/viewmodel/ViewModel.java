package ru.unn.agile.converter.viewmodel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.converter.model.LengthType;

public class ViewModel {

    private StringProperty input = new SimpleStringProperty();
    private StringProperty error = new SimpleStringProperty();
    private StringProperty output = new SimpleStringProperty();
    private BooleanProperty btnDisabled = new SimpleBooleanProperty();
    private ObjectProperty<LengthType> fromType = new SimpleObjectProperty<>();
    private ObjectProperty<LengthType> toType = new SimpleObjectProperty<>();

    private final ObjectProperty<ObservableList<LengthType>> lengthTypes =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(LengthType.values()));

    public ViewModel() {
        input.set("");
        error.set("");
        output.set("");
        btnDisabled.set(true);
        fromType.set(LengthType.METER);
        toType.set(LengthType.CENTIMETER);

        input.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });
    }

    public StringProperty getInput() {
        return input;
    }

    public StringProperty getOutput() {
        return output;
    }

    public BooleanProperty isConvertButtonDisabled() {
        return btnDisabled;
    }

    public ObjectProperty<LengthType> getFromType() {
        return fromType;
    }

    public ObjectProperty<LengthType> getToType() {
        return toType;
    }

    public ObservableList<LengthType> getLengthTypes() {
        return lengthTypes.get();
    }

    public StringProperty getError() {
        return error;
    }

    private void onInput(String newValue) {
        boolean isNumeric = isNumeric(newValue);
        error.set(isNumeric || newValue.isEmpty() ? "" : "invalid");
        btnDisabled.set(newValue.isEmpty() || !isNumeric);
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public void convert() {
        output.set("100");
    }
}
