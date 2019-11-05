package ru.unn.agile.StatisticsCalculation.Model;

import org.junit.Test;
import ru.unn.agile.StatisticsCalculation.model.MomentOrderChecker;

public class MomentOrderCheckerTest {
    @Test(expected = IllegalArgumentException.class)
    public void throwWhenCheckNegativeOrder() {
        Integer order = -1;

        MomentOrderChecker.checkOrder(order);
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwWhenCheckNullOrder() {
        Integer order = null;

        MomentOrderChecker.checkOrder(order);
    }
}
