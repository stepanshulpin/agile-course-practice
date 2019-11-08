package ru.unn.agile.mortgagecalculator.model.report;

import static ru.unn.agile.mortgagecalculator.model.Constants.HASH_CODE_CONST_31;
import static ru.unn.agile.mortgagecalculator.model.Constants.HASH_CODE_CONST_32;

public class MortgageMonthReport {

    private double payment;
    private double basicPayment;
    private double percentPayment;
    private double outstandingAmount;

    public MortgageMonthReport() {
    }

    public MortgageMonthReport(final double payment, final double basicPayment,
                               final double percentPayment, final double currentAmount) {
        this.payment = payment;
        this.basicPayment = basicPayment;
        this.percentPayment = percentPayment;
        this.outstandingAmount = currentAmount;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(final double payment) {
        this.payment = payment;
    }

    public double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(final double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public double getPercentPayment() {
        return percentPayment;
    }

    public void setPercentPayment(final double percentPayment) {
        this.percentPayment = percentPayment;
    }

    public double getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(final double outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MortgageMonthReport that = (MortgageMonthReport) o;

        if (Double.compare(that.payment, payment) != 0) {
            return false;
        }
        if (Double.compare(that.basicPayment, basicPayment) != 0) {
            return false;
        }
        if (Double.compare(that.percentPayment, percentPayment) != 0) {
            return false;
        }
        return Double.compare(that.outstandingAmount, outstandingAmount) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(payment);
        result = (int) (temp ^ (temp >>> HASH_CODE_CONST_32));
        temp = Double.doubleToLongBits(basicPayment);
        result = HASH_CODE_CONST_31 * result + (int) (temp ^ (temp >>> HASH_CODE_CONST_32));
        temp = Double.doubleToLongBits(percentPayment);
        result = HASH_CODE_CONST_31 * result + (int) (temp ^ (temp >>> HASH_CODE_CONST_32));
        temp = Double.doubleToLongBits(outstandingAmount);
        result = HASH_CODE_CONST_31 * result + (int) (temp ^ (temp >>> HASH_CODE_CONST_32));
        return result;
    }
}
