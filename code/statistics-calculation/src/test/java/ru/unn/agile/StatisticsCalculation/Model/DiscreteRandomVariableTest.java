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

    @Test
    public void canCreateDisceteVarWithDoubleVals() {
        Double[] values = {1.0, 2.0};
        Double[] probabilities = {0.5, 0.5};

        DiscreteRandomVariable var = new DiscreteRandomVariable(values, probabilities);

        assertNotNull(var);
    }

    @Test
    public void canGetValues() {
        Double[] values = {1.0, 2.0};
        Double[] probabilities = {0.5, 0.5};
        DiscreteRandomVariable var = new DiscreteRandomVariable(values, probabilities);

        assertArrayEquals(values, var.getValues());
    }

    @Test
    public void canGetProbabilities() {
        Double[] values = {1.0, 2.0};
        Double[] probabilities = {0.5, 0.5};
        DiscreteRandomVariable var = new DiscreteRandomVariable(values, probabilities);

        assertArrayEquals(probabilities, var.getProbabilities());
    }
}
