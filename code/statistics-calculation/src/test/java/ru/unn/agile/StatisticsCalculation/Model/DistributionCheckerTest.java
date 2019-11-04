package ru.unn.agile.StatisticsCalculation.Model;

import org.junit.Test;
import ru.unn.agile.StatisticsCalculation.model.DistributionChecker;

public class DistributionCheckerTest {
    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateEmptyValuesAndProbs() {
        Integer[] values = {};
        Double[] probabilities = {};

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateEmptyValues() {
        Integer[] values = {};
        Double[] probabilities = {1.0};

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateEmptyProbs() {
        Integer[] values = {1};
        Double[] probabilities = {};

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateNullValuesAndProbs() {
        Integer[] values = null;
        Double[] probabilities = null;

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateNullValues() {
        Integer[] values = null;
        Double[] probabilities = {1.0};

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateNullProbs() {
        Integer[] values = {1};
        Double[] probabilities = null;

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateValsAndProbsWithDifferentSize() {
        Integer[] values = {1, 2, 3};
        Double[] probabilities = {0.1, 0.9};

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateValuesWithNull() {
        Integer[] values = {1, null, 3};
        Double[] probabilities = {0.1, 0.8, 0.1};

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateProbsWithNull() {
        Integer[] values = {1, 2, 3};
        Double[] probabilities = {0.1, null, 0.1};

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateProbsWithNegativeValues() {
        Integer[] values = {1, 2, 3};
        Double[] probabilities = {-0.1, 1.0, 0.1};

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateProbsWithBigValues() {
        Integer[] values = {1, 2, 3};
        Double[] probabilities = {0.1, 1.2, 0.1};

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateProbsWithSumMoreOne() {
        Integer[] values = {1, 2, 3};
        Double[] probabilities = {0.1, 0.9, 0.1};

        DistributionChecker.validate(values, probabilities);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenValidateProbsWithSumLessOne() {
        Integer[] values = {1, 2, 3};
        Double[] probabilities = {0.1, 0.3, 0.1};

        DistributionChecker.validate(values, probabilities);
    }
}
