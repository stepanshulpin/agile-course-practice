package ru.unn.agile.mortgagecalculator.viewmodel;

import javafx.beans.property.*;
import ru.unn.agile.mortgagecalculator.model.calculator.MortgageCalculator;
import ru.unn.agile.mortgagecalculator.model.calculator.MortgageWithAnnuityPaymentsCalculator;
import ru.unn.agile.mortgagecalculator.model.calculator.MortgageWithDifferentialPaymentsCalculator;
import ru.unn.agile.mortgagecalculator.model.parameters.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.parameters.PeriodType;
import ru.unn.agile.mortgagecalculator.model.parameters.commission.Commission;
import ru.unn.agile.mortgagecalculator.model.parameters.commission.FixedCommission;
import ru.unn.agile.mortgagecalculator.model.parameters.commission.PercentCommission;
import ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission.FixedMonthlyCommission;
import ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission.MonthlyCommission;
import ru.unn.agile.mortgagecalculator.model.parameters.monthlycommission.PercentAmountMonthlyCommission;
import ru.unn.agile.mortgagecalculator.model.report.MortgageMonthReport;
import ru.unn.agile.mortgagecalculator.model.report.MortgageReport;


public class ViewModel {
    private StringProperty apartmentPrice = new SimpleStringProperty();
    private StringProperty firstPayment = new SimpleStringProperty();
    private StringProperty loanPeriod = new SimpleStringProperty();
    private StringProperty loanPeriodType = new SimpleStringProperty();
    private StringProperty interestRate = new SimpleStringProperty();
    private StringProperty oneTimeComisions = new SimpleStringProperty();
    private StringProperty oneTimeComisionsType = new SimpleStringProperty();
    private StringProperty monthlyComissions = new SimpleStringProperty();
    private StringProperty monthlyComissionsType = new SimpleStringProperty();
    private StringProperty typeOfPayment = new SimpleStringProperty();
    private StringProperty result = new SimpleStringProperty();

    public ViewModel() {
        apartmentPrice.set("");
        firstPayment.set("");
        loanPeriod.set("");
        loanPeriodType.set("");
        interestRate.set("");
        oneTimeComisions.set("");
        oneTimeComisionsType.set("");
        monthlyComissions.set("");
        monthlyComissionsType.set("");
        typeOfPayment.set("");
        result.set("");

        apartmentPrice.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });

        firstPayment.addListener((observable, oldValue, newValue) -> {
            onInput(newValue);
        });

        loanPeriod.addListener((observable, oldValue, newValue) -> {
            onIntInput(newValue);
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
        if (newValue == null) {
            result.set("");
            return;
        }
        try {
            double val = Double.parseDouble(newValue);
            if (val < 0) {
                result.set("Incorrect input");
                return;
            }
        } catch (Exception e) {
            result.set("Incorrect input");
            return;
        }
        result.set("");
    }

    private void onIntInput(final String newValue) {
        if (newValue == null) {
            result.set("");
            return;
        }
        try {
            int val = Integer.parseInt(newValue);
            if (val < 0) {
                result.set("Incorrect input");
                return;
            }
        } catch (Exception e) {
            result.set("Incorrect input");
            return;
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

    private boolean checkInput() {
        boolean res = true;
        if (apartmentPrice.get().equals("")) {
            res = false;
        }
        if (interestRate.get().equals("")) {
            res = false;
        }
        if (loanPeriod.get().equals("")) {
            res = false;
        }
        if (loanPeriodType.get().equals("")) {
            res = false;
        }
        if (firstPayment.get().equals("")) {
            res = false;
        }
        if (oneTimeComisions.get().equals("")) {
            res = false;
        }
        if (monthlyComissions.get().equals("")) {
            res = false;
        }
        if (monthlyComissionsType.get().equals("")) {
            res = false;
        }
        if (oneTimeComisionsType.get().equals("")) {
            res = false;
        }
        if (typeOfPayment.get().equals("")) {
            res = false;
        }
        return res;
    }

    public void calculate() {
        if (result.get().equals("Incorrect input")) {
            return;
        }

        if (!checkInput()) {
            result.set("Incorrect input");
            return;
        }

        double amount = Double.parseDouble(apartmentPrice.get());
        double percent = Double.parseDouble(interestRate.get());
        int period = Integer.parseInt(loanPeriod.get());
        PeriodType periodType = loanPeriodType.get().equals("Year")
                ? PeriodType.YEAR : PeriodType.MONTH;
        double initialPayment = Double.parseDouble((firstPayment.get()));
        double fixedComissionAmount = Double.parseDouble((oneTimeComisions.get()));
        double monthlyComissionAmount = Double.parseDouble((monthlyComissions.get()));
        Commission fixedCommission = null;
        MonthlyCommission monthlyCommission = null;
        try {
            fixedCommission = oneTimeComisionsType.get().equals("Percent")
                    ? new PercentCommission(fixedComissionAmount)
                    : new FixedCommission(fixedComissionAmount);
            monthlyCommission = monthlyComissionsType.get().equals("Percent")
                    ? new PercentAmountMonthlyCommission(monthlyComissionAmount)
                    : new FixedMonthlyCommission(monthlyComissionAmount);
        } catch (Exception e) {
            result.set("Incorrect input");
            return;
        }

        MortgageParameters mortgageParameters = null;
        try {
            mortgageParameters = new MortgageParameters(
                    amount, percent, periodType, period);
        } catch (Exception e) {
            result.set("Incorrect input");
            return;
        }

        try {
            mortgageParameters.setInitialPayment(initialPayment);
        } catch (Exception e) {
            result.set("Incorrect input");
            return;
        }

        mortgageParameters.setCommission(fixedCommission);
        mortgageParameters.setMonthlyCommission(monthlyCommission);

        MortgageCalculator calculator;
        if (typeOfPayment.get().equals("Annuity")) {
            calculator = new MortgageWithAnnuityPaymentsCalculator();
        } else {
            calculator = new MortgageWithDifferentialPaymentsCalculator();
        }

        MortgageReport report = calculator.calculate(mortgageParameters);
        MortgageMonthReport monthReport = report.getMonthReport(1);
        String result = "Final amount " + report.getFinalAmount() + "; "
                + "Overpayment " + report.getOverpayment()
                + "; With month payment " + monthReport.getPayment() + " for "
                + "" + mortgageParameters.getMonthsPeriod() + " months.";
        this.result.set(result);
    }
}
