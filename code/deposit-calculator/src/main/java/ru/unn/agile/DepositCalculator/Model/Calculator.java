package ru.unn.agile.DepositCalculator.Model;

public class Calculator {

    private static final double MIN_INTEREST_RATE_FOR_TAX = 0.1825;
    private static final double DEPOSIT_TAX = 0.35;

    private static final int MAX_PERCENT = 100;
    private static final int MONTHS_IN_YEAR = 12;
    private static final int DAYS_IN_MONTH = 30;
    private static final int DAYS_IN_YEAR = 365;
    private static final int DAYS_IN_QUARTER = 90;
    private static final int QUARTER_IN_YEAR = 4;

    private double mStartSum;
    private double mPercent;
    private double mPeriodCoeff;
    private int mPeriodInDays;
    private int mCapitalizationCount;
    private double mCapitalizationCoeff;

    public Calculator setStartSum(final double startSum) {
        if (startSum < 0) {
            throw new IllegalArgumentException("start sum on the deposit should be >= 0");
        }
        mStartSum = startSum;
        return this;
    }

    public Calculator setPercent(final int percent) {
        if (percent < 0 || percent > MAX_PERCENT) {
            throw new IllegalArgumentException("percent should be from 0 to " + MAX_PERCENT);
        }
        mPercent = (double) percent / MAX_PERCENT;
        return this;
    }

    public Calculator setPeriod(final DepositTimeType periodType, final int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count should be > 0");
        }
        switch (periodType) {
            case YEAR:
                mPeriodCoeff = count;
                mPeriodInDays = count * DAYS_IN_YEAR;
                break;
            case MONTH:
                mPeriodCoeff = (double) count / MONTHS_IN_YEAR;
                mPeriodInDays = count * DAYS_IN_MONTH;
                break;
            case DAY:
                mPeriodCoeff = (double) count / DAYS_IN_YEAR;
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
                mCapitalizationCount = mPeriodInDays / DAYS_IN_YEAR;
                mCapitalizationCoeff = 1;
                break;
            case QUARTER:
                mCapitalizationCount = mPeriodInDays / DAYS_IN_QUARTER;
                mCapitalizationCoeff = (double) 1 / QUARTER_IN_YEAR;
                break;
            case MONTH:
                mCapitalizationCount = mPeriodInDays / DAYS_IN_MONTH;
                mCapitalizationCoeff = (double) 1 / MONTHS_IN_YEAR;
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
        if (mPercent > MIN_INTEREST_RATE_FOR_TAX) {
            mPercent -= mPercent * DEPOSIT_TAX;
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
