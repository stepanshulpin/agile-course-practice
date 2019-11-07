package ru.unn.agile.mortgagecalculator.model.report;

import ru.unn.agile.mortgagecalculator.model.validation.Validator;

import java.util.ArrayList;
import java.util.List;

public class MortgageReport {

    private double amount;
    private List<MortgageMonthReport> monthsReports;
    private double finalAmount;

    public MortgageReport(double amount) {
        this.amount = amount;
        monthsReports = new ArrayList<>();
    }

    public void add(MortgageMonthReport monthReport) {
        monthsReports.add(monthReport);
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }

    public int getMonthsCount() {
        return monthsReports.size();
    }

    public List<MortgageMonthReport> getMonthsReports() {
        return monthsReports;
    }

    public MortgageMonthReport getMonthReport(int month) {
        new Validator().checkReportSize(month, monthsReports.size());
        return monthsReports.get(month - 1);
    }

    public double getOverpayment() {
        return finalAmount - amount;
    }
}
