package ru.unn.agile.DepositCalculator.Model;

public class Calculator {

    private final double minInterestRateForTax = 0.1825;
    private final double depositTax = 0.35;

    private final int maxPercent = 100;
    private final int monthsInYear = 12;
    private final int daysInMonth = 30;
    private final int daysInYear = 365;
    private final int daysInQuarter = 90;
    private final int quarterInYear = 4;

    private double mStartSum;
    private double mPercent;
    private double mPeriodCoeff;
    private int mPeriodInDays;
    private int mCapitalizationCount;
    private double mCapitalizationCoeff;

    public Calculator setStartSum(final double startSum) {
        mStartSum = startSum;
        return this;
    }

    public Calculator setPercent(final int percent) {
        mPercent = (double) percent / maxPercent;
        return this;
    }

    public Calculator setPeriod(final DepositTimeType periodType, final int count) {
        switch (periodType) {
            case YEAR:
                mPeriodCoeff = count;
                mPeriodInDays = count * daysInYear;
                break;
            case MONTH:
                mPeriodCoeff = (double) count / monthsInYear;
                mPeriodInDays = count * daysInMonth;
                break;
            case DAY:
                mPeriodCoeff = (double) count / daysInYear;
                mPeriodInDays = count;
                break;
                default:
                    mPeriodCoeff = 0;
                    mPeriodInDays = 0;
                    break;
        }
        return this;
    }

    public Calculator setCapitalizationPeriod(final CapitalizationPeriod capitalizationPeriod) {
        switch (capitalizationPeriod) {
            case YEAR:
                mCapitalizationCount = mPeriodInDays / daysInYear;
                mCapitalizationCoeff = 1;
                break;
            case QUARTER:
                mCapitalizationCount = mPeriodInDays / daysInQuarter;
                mCapitalizationCoeff = (double) 1 / quarterInYear;
                break;
            case MONTH:
                mCapitalizationCount = mPeriodInDays / daysInMonth;
                mCapitalizationCoeff = (double) 1 / monthsInYear;
                break;
                default:
                    mCapitalizationCoeff = 0;
                    mCapitalizationCount = 0;
                    break;
        }
        return this;
    }

    public double calculate() {

        double result = 0.0;

        if (mPercent > minInterestRateForTax) {
            mPercent -= mPercent * depositTax;
        }

        if (mCapitalizationCount == 0) {
            result = mStartSum + mStartSum * mPeriodCoeff * mPercent;

        } else {
            int i = 0;
            result = mStartSum;
            while (i < mCapitalizationCount) {
                double capitalizationPerPeriod = result * mPercent * mCapitalizationCoeff;
                result += capitalizationPerPeriod;
                i++;
            }
        }

        clear();
        return result;
    }

    private void clear() {
        mStartSum = 0;
        mPercent = 0.0;
        mPeriodCoeff = 0.0;
        mPeriodInDays = 0;
        mCapitalizationCount = 0;
        mCapitalizationCoeff = 0.0;
    }
}
