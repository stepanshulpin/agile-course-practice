package ru.unn.agile.sorting.viewmodel;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.unn.agile.sorting.model.api.Direction;
import ru.unn.agile.sorting.model.api.Sorting;
import ru.unn.agile.sorting.model.impl.NumberSorting;

import java.util.Arrays;

public class ViewModel {
    private final StringProperty input = new SimpleStringProperty();
    private final BooleanProperty sortButtonDisabled = new SimpleBooleanProperty();
    private final ObjectProperty<ObservableList<Direction>> directions =
            new SimpleObjectProperty<>(FXCollections.observableArrayList(Direction.values()));
    private final ObjectProperty<Direction> direction = new SimpleObjectProperty<>();
    private final StringProperty output = new SimpleStringProperty();
    private final StringProperty error = new SimpleStringProperty();

    public ViewModel() {

        input.set("");
        direction.set(Direction.ASC);
        sortButtonDisabled.set(true);
        output.set("");
        error.set("");
        input.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });
    }

    public void sort() {
        Sorting<Integer> numberSorting = new NumberSorting(direction.get());
        String[] strArr = input.get().split(" ");
        Integer[] numbers = new Integer[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numbers[i] = Integer.parseInt(strArr[i]);
        }
        String result = Arrays.toString(numberSorting.sort(numbers));
        output.set(result.substring(1, result.length() - 1));
    }

    private void onInput(final String newValue) {
        if (!newValue.matches("^-?\\d+(\\s-?\\d+)*$")) {
            sortButtonDisabled.set(true);
            error.set("Incorrect Input");
        } else {
            sortButtonDisabled.set(false);
            error.set("");
        }
    }

    public StringProperty inputProperty() {
        return input;
    }

    public StringProperty outputProperty() {
        return output;
    }

    public final String getOutput() {
        return output.get();
    }

    public StringProperty errorProperty() {
        return error;
    }

    public final String getError() {
        return error.get();
    }

    public ObjectProperty<ObservableList<Direction>> directionsProperty() {
        return directions;
    }

    public final ObservableList<Direction> getDirections() {
        return directions.get();
    }

    public ObjectProperty<Direction> directionProperty() {
        return direction;
    }

    public BooleanProperty sortButtonDisabledProperty() {
        return sortButtonDisabled;
    }
}
