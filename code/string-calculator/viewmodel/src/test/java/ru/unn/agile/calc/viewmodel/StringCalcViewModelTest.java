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
    public void fakeTest() {
        assertTrue(true);
    }

}
