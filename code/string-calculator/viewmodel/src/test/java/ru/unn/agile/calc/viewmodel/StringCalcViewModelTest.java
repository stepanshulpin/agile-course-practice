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
    public void canCalculateExpression1() {
        viewModel.expressionTfProperty().setValue("1+1");
        viewModel.calculate();
        assertEquals("2.0", viewModel.resultLblProperty().get());
    }

    @Test
    public void canCalculateExpression2() {
        viewModel.expressionTfProperty().setValue("1+2*3-4/5");
        viewModel.calculate();
        assertEquals("6.2", viewModel.resultLblProperty().get());
    }

    @Test
    public void canNotCalculateInvalidExpression1() {
        viewModel.expressionTfProperty().setValue("+-*/");
        viewModel.calculate();
        assertEquals("Error. Check your input", viewModel.resultLblProperty().get());
    }

    @Test
    public void isResultTheSameForSameExpression() {

        viewModel.expressionTfProperty().setValue("1+1");
        viewModel.calculate();
        String r1 = viewModel.resultLblProperty().get();

        viewModel.calculate();
        String r2 = viewModel.resultLblProperty().get();

        assertEquals(r1, r2);
    }

}
