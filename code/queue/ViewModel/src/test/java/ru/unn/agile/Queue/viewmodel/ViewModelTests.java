package ru.unn.agile.Queue.viewmodel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ViewModelTests {
    private ViewModel viewModel;
    @Before
    public void creatingViewModel() {
        viewModel = new ViewModel();
    }

    @After
    public void deletingViewModel() {
        viewModel = null;
    }

    @Test
    public void canSetDefaultQueueValue() {
        assertEquals("", viewModel.getQueueString());
    }

    @Test
    public void canSetDefaultInputElement() {
        assertEquals("", viewModel.getInputElement());
    }
}
