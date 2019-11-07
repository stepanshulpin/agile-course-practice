package ru.unn.agile.mortgagecalculator.Model;

import org.junit.Test;
import ru.unn.agile.mortgagecalculator.model.MortgageCalculator;
import ru.unn.agile.mortgagecalculator.model.MortgageParameters;
import ru.unn.agile.mortgagecalculator.model.PeriodType;

import static org.junit.Assert.*;

public class MortgageCalculatorTest {

    private final double delta = 0.001;

    @Test
    public void canCalculateForOneYearWithoutPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 1);

        double finalAmount = calculator.calculateWithoutPayments(parameters);

        assertEquals(55000, finalAmount, delta);
    }

    @Test
    public void canCalculateForTwoYearsWithoutPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 2);

        double finalAmount = calculator.calculateWithoutPayments(parameters);

        assertEquals(60500, finalAmount, delta);
    }

    @Test
    public void canCalculateForThreeYearsWithoutPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 3);

        double finalAmount = calculator.calculateWithoutPayments(parameters);

        assertEquals(66550, finalAmount, delta);
    }

    @Test
    public void canCalculateForFiveYearsWithoutPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 5);

        double finalAmount = calculator.calculateWithoutPayments(parameters);

        assertEquals(80525.50, finalAmount, delta);
    }

    @Test
    public void canCalculateForNineYearsWithoutPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 9);

        double finalAmount = calculator.calculateWithoutPayments(parameters);

        assertEquals(117897.40, finalAmount, delta);
    }

    @Test
    public void canCalculateForTwentyFourYearsWithoutPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 24);

        double finalAmount = calculator.calculateWithoutPayments(parameters);

        assertEquals(492486.68, finalAmount, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInitParametersForZeroYear() {
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInitParametersForNegativeMounts() {
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.MONTH, -3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInitParametersForZeroAmount() {
        MortgageParameters parameters = new MortgageParameters(0, 10, PeriodType.YEAR, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInitParametersForNegativeAmount() {
        MortgageParameters parameters = new MortgageParameters(-50000, 10, PeriodType.MONTH, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInitParametersForZeroPercent() {
        MortgageParameters parameters = new MortgageParameters(50000, 0, PeriodType.YEAR, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInitParametersForNegativePercent() {
        MortgageParameters parameters = new MortgageParameters(50000, -10, PeriodType.MONTH, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canInitParametersForOverflowPercent() {
        MortgageParameters parameters = new MortgageParameters(50000, 130, PeriodType.MONTH, 1);
    }

    @Test
    public void canCalculateForOneYearWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 1);

        double finalAmount = calculator.calculateWithDifferentialPayments(parameters).getFinalAmount();

        assertEquals(52708.33, finalAmount, delta);
    }

    @Test
    public void canCalculateForTwoYearsWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 2);

        double finalAmount = calculator.calculateWithDifferentialPayments(parameters).getFinalAmount();

        assertEquals(55208.33, finalAmount, delta);
    }

    @Test
    public void canCalculateForSevenYearsWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, PeriodType.YEAR, 7);

        double finalAmount = calculator.calculateWithDifferentialPayments(parameters).getFinalAmount();

        assertEquals(67708.33, finalAmount, delta);
    }

    @Test
    public void canCalculateForSevenMonthsWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, 7);

        double finalAmount = calculator.calculateWithDifferentialPayments(parameters).getFinalAmount();

        assertEquals(51666.67, finalAmount, delta);
    }

    @Test
    public void canCalculateForTwentySevenMonthsWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 10, 27);

        double finalAmount = calculator.calculateWithDifferentialPayments(parameters).getFinalAmount();

        assertEquals(55833.33, finalAmount, delta);
    }

    @Test
    public void canGetPaymentAtSecondMonthWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);

        double payment = calculator.calculateWithDifferentialPayments(parameters).getMonthReport(2).getPayment();

        assertEquals(5450.00, payment, delta);
    }

    @Test(expected = IllegalArgumentException.class)
    public void canGetPaymentAtFourteenMonthWithDifferentialPaymentsForOneYera() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, PeriodType.YEAR, 1);

        double payment = calculator.calculateWithDifferentialPayments(parameters).getMonthReport(14).getPayment();

        assertEquals(5450.00, payment, delta);
    }

    @Test
    public void canGetOutstandingAmountAtFifthMonthWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);

        double outstandingAmount = calculator.calculateWithDifferentialPayments(parameters).getMonthReport(5).getOutstandingAmount();

        assertEquals(25000.00, outstandingAmount, delta);
    }

    @Test
    public void canGetPercentPaymentAtSixMonthWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);

        double outstandingAmount = calculator.calculateWithDifferentialPayments(parameters).getMonthReport(6).getPercentPayment();

        assertEquals(250, outstandingAmount, delta);
    }

    @Test
    public void canGetOverpaymentWithDifferentialPayments() {
        MortgageCalculator calculator = new MortgageCalculator();
        MortgageParameters parameters = new MortgageParameters(50000, 12, 10);

        double overpayment = calculator.calculateWithDifferentialPayments(parameters).getOverpayment();

        assertEquals(2750, overpayment, delta);
    }

}
