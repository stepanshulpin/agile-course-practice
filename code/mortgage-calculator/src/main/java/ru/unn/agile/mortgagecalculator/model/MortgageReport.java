package ru.unn.agile.mortgagecalculator.model;

import java.util.ArrayList;
import java.util.List;

public class MortgageReport {

    private List<MortgageMonthReport> monthsReports;
    private double finalAmount;

    public MortgageReport() {
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
}
