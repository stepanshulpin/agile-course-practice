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
        Number[] values = {-1.0, 2};
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

    @Test
    public void canCopyDiscreteRandomVariable() {
        Double[] values = {-1.0, 2.0, 5.0};
        Double[] probabilities = {0.1, 0.1, 0.8};
        DiscreteRandomVariable var = new DiscreteRandomVariable(values, probabilities);

        DiscreteRandomVariable var2 = var;

        assertEquals(var, var2);
    }



}
