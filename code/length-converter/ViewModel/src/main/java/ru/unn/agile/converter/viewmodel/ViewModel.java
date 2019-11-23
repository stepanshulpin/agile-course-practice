package ru.unn.agile.converter.viewmodel;

import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.converter.model.LengthType;

import java.util.List;
import java.util.Objects;

public class ViewModel {

    private StringProperty input = new SimpleStringProperty();
    private StringProperty output = new SimpleStringProperty();
    private BooleanProperty btnDisabled = new SimpleBooleanProperty();
    private ObjectProperty<LengthType> fromType = new SimpleObjectProperty<>();
    private ObjectProperty<LengthType> toType = new SimpleObjectProperty<>();

    private final ObjectProperty<ObservableList<LengthType>> lengthTypes =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(LengthType.values()));

    public ViewModel() {
        input.set("");
        output.set("");
        btnDisabled.set(true);
        fromType.set(LengthType.METER);
        toType.set(LengthType.CENTIMETER);

        input.addListener((observable, oldValue, newValue) -> {
            btnDisabled.set(newValue.isEmpty());
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
}
