package ru.unn.agile.StatisticsCalculation.Model;

import org.junit.Test;
import ru.unn.agile.StatisticsCalculation.model.DiscreteRandomVariable;

import static org.junit.Assert.*;

public class DiscreteRandomVariableTest {
    private final double delta = 0.001;

    @Test
    public void canCreateDisceteVarWithIntegerVals() {
        Integer[] values = {1};
        Double[] probabilities = {1.0};

        DiscreteRandomVariable var = new DiscreteRandomVariable(values, probabilities);

        assertNotNull(var);
    }
}
