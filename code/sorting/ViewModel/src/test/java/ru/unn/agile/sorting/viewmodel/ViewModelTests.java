package ru.unn.agile.sorting.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.sorting.model.api.Direction;

import static org.junit.Assert.assertEquals;

public class ViewModelTests {

    private ViewModel viewModel;

    @Before
    public void setUp() {
        viewModel = new ViewModel();
    }

    @After
    public void tearDown() {
        viewModel = null;
    }

    @Test
    public void canSetEmptyInputArray() {
        assertEquals("", viewModel.inputProperty().get());
    }

    @Test
    public void canSetEmptyResultArray() {
        assertEquals("", viewModel.outputProperty().get());
    }

    @Test
    public void canSetDefaultDirection() {
        assertEquals(Direction.ASC, viewModel.directionProperty().get());
    }

    @Test
    public void canSetDefaultErrorMessage() {
        assertEquals("", viewModel.errorProperty().get());
    }

    @Test
    public void canSetDirection() {
        viewModel.directionProperty().set(Direction.DESC);
        assertEquals(Direction.DESC, viewModel.directionProperty().get());
    }

    @Test
    public void canShowErrorMessage() {
        viewModel.inputProperty().set("qwerty");
        assertEquals("Incorrect Input", viewModel.errorProperty().get());
    }

    @Test
    public void isSortButtonDisabledByDefault() {
        assertEquals(true, viewModel.sortButtonDisabledProperty().get());
    }

    @Test
    public void isSortButtonDisabledAfterInputValue() {
        viewModel.inputProperty().set("1");
        assertEquals(false, viewModel.sortButtonDisabledProperty().get());
    }

    @Test
    public void isSortButtonDisabledAfterIncorrectInput() {
        viewModel.inputProperty().set("q");
        assertEquals(true, viewModel.sortButtonDisabledProperty().get());
    }

    @Test
    public void isSortButtonDisabledAfterNegativeValueInput() {
        viewModel.inputProperty().set("-3");
        assertEquals(false, viewModel.sortButtonDisabledProperty().get());
    }

    @Test
    public void isSortButtonDisabledAfterDoubleValueInput() {
        viewModel.inputProperty().set("2.5");
        assertEquals(true, viewModel.sortButtonDisabledProperty().get());
    }

    @Test
    public void isSortButtonDisableAfterDeletingValue() {
        viewModel.inputProperty().set("1 2 4 3");
        viewModel.inputProperty().set("");
        assertEquals(true, viewModel.sortButtonDisabledProperty().get());
    }

    @Test
    public void canSortNumbersDesc() {
        viewModel.directionProperty().set(Direction.DESC);
        viewModel.inputProperty().set("2 1 3 6 9");
        viewModel.sort();
        assertEquals("9, 6, 3, 2, 1", viewModel.outputProperty().get());
    }

    @Test
    public void canSortNegativeNumbersAsc() {
        viewModel.inputProperty().set("-2 -1 -5 -8");
        viewModel.sort();
        assertEquals("-8, -5, -2, -1", viewModel.outputProperty().get());
    }

    @Test
    public void canSortNegativeAndPositiveNumbersAsc() {
        viewModel.inputProperty().set("5 -1 3 -6 12");
        viewModel.sort();
        assertEquals("-6, -1, 3, 5, 12", viewModel.outputProperty().get());
    }
}

