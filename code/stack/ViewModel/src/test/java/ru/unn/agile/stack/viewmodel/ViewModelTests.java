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
        assertEquals(emptyStatus, viewModel.getIsStackEmptyInfoProperty());
    }

    @Test
    public void checkDefaultStackSize() {
        var defaultSize = "0";
        assertEquals(defaultSize, viewModel.getStackSizeProperty());
    }

    @Test
    public void checkDefaultTopElement() {
        var defaultTopElement = "None";
        assertEquals(defaultTopElement, viewModel.getTopElementProperty());
    }

    @Test
    public void checkDefaultPopElement() {
        var defaultPopElement = "None";
        assertEquals(defaultPopElement, viewModel.getPopElementProperty());
    }

    @Test
    public void checkDefaultPushElement() {
        var defaultPushElement = "";
        assertEquals(defaultPushElement, viewModel.getPushElementProperty());
    }

    @Test
    public void checkDefaultStatus() {
        var defaultStatus = "Waiting for new element";
        assertEquals(defaultStatus, viewModel.getStatusProperty());
    }

    @Test
    public void checkDefaultPopButtonState() {
        assertEquals(false, viewModel.getDefaultPopButtonState());
    }

}
