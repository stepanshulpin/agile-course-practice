package ru.unn.agile.stack.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

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
    public void checkDefaultEmptyStatus() {
        var emptyStatus = "Stack is empty";
        assertEquals(emptyStatus, viewModel.getIsStackEmptyInfo());
    }

    @Test
    public void checkDefaultStackSize() {
        var defaultSize = "0";
        assertEquals(defaultSize, viewModel.getStackSize());
    }

    @Test
    public void checkDefaultTopElement() {
        var defaultTopElement = "None";
        assertEquals(defaultTopElement, viewModel.getTopElement());
    }

    @Test
    public void checkDefaultPopElement() {
        var defaultPopElement = "None";
        assertEquals(defaultPopElement, viewModel.getPopElement());
    }

}
