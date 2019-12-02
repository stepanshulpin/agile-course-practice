package ru.unn.agile.arabicromanconverter.viewmodel;

import javafx.beans.property.*;
import ru.unn.agile.arabicromanconverter.model.*;

import java.util.ArrayList;
import java.util.List;

public class ViewModel {

    private StringProperty input = new SimpleStringProperty();
    private StringProperty output = new SimpleStringProperty();
    private StringProperty error = new SimpleStringProperty();
    private StringProperty convert = new SimpleStringProperty();
    private BooleanProperty btnDisabled = new SimpleBooleanProperty();
    private List<NumConverter> converters = new ArrayList<NumConverter>();
    private int selector = 0;

    private void prepareConverters() {
        ArabicToRomanConverter converterA = new ArabicToRomanConverter();
        RomanToArabicConverter converterB = new RomanToArabicConverter();
        converters.add(converterA);
        converters.add(converterB);
    }

    public ViewModel() {
        refresh();
        convert.set("Arabic to Romain");
        btnDisabled.set(true);
        prepareConverters();

        input.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });
    }

    public void convert() {
        String value = input.get();
        NumConverter converter = converters.get(selector);
        String result = converter.convert(value);
        output.set(result);
    }

    public void swap() {
        if (selector == 0) {
            selector = 1;
            convert.set("Romain to Arabic");
            refresh();
        } else {
            selector = 0;
            convert.set("Arabic to Romain");
            refresh();
        }
    }

    public void refresh() {
        input.set("");
        output.set("");
        error.set("");
    }

    public StringProperty getInput() {
        return input;
    }

    public StringProperty getOutput() {
        return output;
    }

    public StringProperty getConvert() {
        return convert;
    }


    public StringProperty getError() {
        return error;
    }

    public BooleanProperty isConvertButtonDisabled() {
        return btnDisabled;
    }

    private void onInput(final String newValue) {
        boolean isValid = converters.get(selector).validate(newValue);
        if (isValid || newValue.isEmpty()) {
            error.set("");
        } else if (selector == 0) {
            error.set("Insert correct arabic number");
        } else {
            error.set("Insert correct roman number");
        }
        btnDisabled.set(newValue.isEmpty() || !isValid);
        output.set("");
    }
}
