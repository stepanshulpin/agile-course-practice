package ru.unn.agile.calc.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalcViewModelTest {

    private StringCalcViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new StringCalcViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canCalculateExpression() {
        viewModel.expressionTfProperty().setValue("1+1");
        viewModel.calculate();
        assertEquals("2.0", viewModel.resultLblProperty().get());
    }

}
