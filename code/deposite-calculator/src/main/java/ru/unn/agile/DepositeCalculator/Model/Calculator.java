package ru.unn.agile.DepositeCalculator.Model;

public class Calculator {

    //deposit-calculator example URL: fincult.info/services/deposit-calculator

    private final int MAX_PERCENT = 100;
    private final int MONTHS_IN_YEAR = 12;
    private final int DAYS_IN_MONTH = 30;
    private final int DAYS_IN_YEAR = 365;
    private final int DAYS_IN_QUARTER = 90;
    private final int QUARTER_IN_YEAR = 4;

    private double mStartSum;
    private double mPercent;
    private double mPeriodCoeff;
    private int mPeriodInDays;
    private int mCapitalizationCount;
    private double mCapitalizationCoeff;

    public Calculator setStartSum(double startSum) {
        mStartSum = startSum;
        return this;
    }

    public Calculator setPercent(int percent) {
        mPercent = (double) percent / MAX_PERCENT;
        return this;
    }

    public Calculator setPeriod(DepositeTimeType periodType, int count) {
        switch (periodType) {
            case YEAR:
                mPeriodCoeff = count;
                mPeriodInDays = count * DAYS_IN_YEAR;
                break;
            case MONTH:
                mPeriodCoeff = (double)count / MONTHS_IN_YEAR;
                mPeriodInDays = count * DAYS_IN_MONTH;
                break;
            case DAY:
                mPeriodCoeff = (double)count / DAYS_IN_YEAR;
                mPeriodInDays = count;
                break;
        }
        return this;
    }

    public Calculator setCapitalizationPeriod(CapitalizationPeriod capitalizationPeriod) {
        switch (capitalizationPeriod) {
            case YEAR:
                mCapitalizationCount = mPeriodInDays / DAYS_IN_YEAR;
                mCapitalizationCoeff = 1;
                break;
            case QUARTER:
                mCapitalizationCount = mPeriodInDays / DAYS_IN_QUARTER;
                mCapitalizationCoeff = (double)1 / QUARTER_IN_YEAR;
                break;
            case MONTH:
                mCapitalizationCount = mPeriodInDays / DAYS_IN_MONTH;
                mCapitalizationCoeff = (double)1 / MONTHS_IN_YEAR;
                break;
        }
        return this;
    }

    public double calculate() {

        if (mCapitalizationCount == 0) {
            return mStartSum + mStartSum * mPercent * mPeriodCoeff;
        } else {
            int i = 0;
            while (i < mCapitalizationCount) {
                double capitalizationPerPeriod = mStartSum * mPercent * mCapitalizationCoeff;
                mStartSum += capitalizationPerPeriod;
                i++;
            }
            return mStartSum;
        }
    }
}