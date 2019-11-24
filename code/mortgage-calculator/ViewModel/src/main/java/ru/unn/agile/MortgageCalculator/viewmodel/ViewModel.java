package ru.unn.agile.mortgagecalculator.viewmodel;

import javafx.beans.property.*;

import java.util.Calendar;
import java.util.Date;

public class ViewModel {
    private StringProperty apartmentPrice = new SimpleStringProperty();
    private StringProperty firstPayment = new SimpleStringProperty();
    private StringProperty loanPeriod = new SimpleStringProperty();
    private StringProperty loanPeriodType = new SimpleStringProperty();
    private StringProperty interestRate = new SimpleStringProperty();
    private StringProperty interestRateType = new SimpleStringProperty();
    private StringProperty oneTimeComisions = new SimpleStringProperty();
    private StringProperty oneTimeComisionsType = new SimpleStringProperty();
    private StringProperty monthlyComissions = new SimpleStringProperty();
    private StringProperty monthlyComissionsType = new SimpleStringProperty();
    private StringProperty typeOfPayment = new SimpleStringProperty();
    private StringProperty result = new SimpleStringProperty();
    private ObjectProperty<Date> startDate = new SimpleObjectProperty<>();

    public ViewModel() {
        apartmentPrice.set("");
        firstPayment.set("");
        loanPeriod.set("");
        loanPeriodType.set("");
        interestRate.set("");
        interestRateType.set("");
        oneTimeComisions.set("");
        oneTimeComisionsType.set("");
        monthlyComissions.set("");
        monthlyComissionsType.set("");
        typeOfPayment.set("");
        result.set("");
        //startDate.set(new Date(Calendar.YEAR, Calendar.JANUARY,Calendar.MONDAY));

        apartmentPrice.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });

        firstPayment.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });

        loanPeriod.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });

        interestRate.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });

        oneTimeComisions.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });

        monthlyComissions.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });

        loanPeriodType.addListener((observable, oldValue, newValue) -> {
            onTypeChange();
        });

        interestRateType.addListener((observable, oldValue, newValue) -> {
            onTypeChange();
        });

        typeOfPayment.addListener((observable, oldValue, newValue) -> {
            onTypeChange();
        });

        monthlyComissionsType.addListener((observable, oldValue, newValue) -> {
            onTypeChange();
        });

        oneTimeComisionsType.addListener((observable, oldValue, newValue) -> {
            onTypeChange();
        });

    }

    private void onInput(final String newValue) {
        try {
            Double.parseDouble(newValue);
        } catch (Exception e) {
            result.set("Incorrect input");
        }
        result.set("");
    }

    private void onTypeChange() {
        result.set("");
    }

    public String getApartmentPrice() {
        return apartmentPrice.get();
    }

    public StringProperty apartmentPriceProperty() {
        return apartmentPrice;
    }

    public String getFirstPayment() {
        return firstPayment.get();
    }

    public StringProperty firstPaymentProperty() {
        return firstPayment;
    }

    public String getLoanPeriod() {
        return loanPeriod.get();
    }

    public StringProperty loanPeriodProperty() {
        return loanPeriod;
    }

    public String getLoanPeriodType() {
        return loanPeriodType.get();
    }

    public StringProperty loanPeriodTypeProperty() {
        return loanPeriodType;
    }

    public String getInterestRate() {
        return interestRate.get();
    }

    public StringProperty interestRateProperty() {
        return interestRate;
    }

    public String getInterestRateType() {
        return interestRateType.get();
    }

    public StringProperty interestRateTypeProperty() {
        return interestRateType;
    }

    public String getOneTimeComisions() {
        return oneTimeComisions.get();
    }

    public StringProperty oneTimeComisionsProperty() {
        return oneTimeComisions;
    }

    public String getOneTimeComisionsType() {
        return oneTimeComisionsType.get();
    }

    public StringProperty oneTimeComisionsTypeProperty() {
        return oneTimeComisionsType;
    }

    public String getMonthlyComissions() {
        return monthlyComissions.get();
    }

    public StringProperty monthlyComissionsProperty() {
        return monthlyComissions;
    }

    public String getMonthlyComissionsType() {
        return monthlyComissionsType.get();
    }

    public StringProperty monthlyComissionsTypeProperty() {
        return monthlyComissionsType;
    }

    public String getTypeOfPayment() {
        return typeOfPayment.get();
    }

    public StringProperty typeOfPaymentProperty() {
        return typeOfPayment;
    }

    public String getResult() {
        return result.get();
    }

    public StringProperty resultProperty() {
        return result;
    }

    public Date getStartDate() {
        return startDate.get();
    }

    public ObjectProperty<Date> startDateProperty() {
        return startDate;
    }

    public void calculate() {
        //
    }
}
