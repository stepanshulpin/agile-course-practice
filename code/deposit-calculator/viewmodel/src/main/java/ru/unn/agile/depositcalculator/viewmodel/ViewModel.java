package ru.unn.agile.depositcalculator.viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import ru.unn.agile.depositcalculator.model.CapitalizationPeriod;
import ru.unn.agile.depositcalculator.model.DepositTimeType;


public class ViewModel {

    private final SimpleStringProperty cmbPeriod = new SimpleStringProperty();
    private final SimpleStringProperty cmbCapit = new SimpleStringProperty();
    private final SimpleStringProperty cmdSumm = new SimpleStringProperty();
    private final SimpleStringProperty cmbPercent = new SimpleStringProperty();
    private final SimpleStringProperty txtResult = new SimpleStringProperty();

    private final ObjectProperty<DepositTimeType> period = new SimpleObjectProperty<>();
    private final ObjectProperty<CapitalizationPeriod> capitalization =
            new SimpleObjectProperty<>();


    public DepositTimeType getPeriod() {
        return period.get();
    }

    public ObjectProperty<DepositTimeType> periodProperty() {
        return period;
    }

    public CapitalizationPeriod getCapitalization() {
        return capitalization.get();
    }

    public ObjectProperty<CapitalizationPeriod> capitalizationProperty() {
        return capitalization;
    }

}
