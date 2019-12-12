package ru.unn.agile.depositcalculator.viewmodel;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.unn.agile.depositcalculator.model.CapitalizationPeriod;
import ru.unn.agile.depositcalculator.model.DepositTimeType;


public class ViewModelTest {

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
    public void canSetDefaultDepositPeriod() {
        Assert.assertEquals(DepositTimeType.DAY, viewModel.periodProperty().get());
    }

    @Test
    public void canSetDefaultCapitPeriod() {
        Assert.assertEquals(CapitalizationPeriod.MONTH, viewModel.capitalizationProperty().get());
    }

    @Test
    public void canSetDefaultStartSum() {
        Assert.assertEquals("1000", viewModel.getStartSumProperty());
    }

    @Test
    public void canSetDefaultPercent() {
        Assert.assertEquals("8", viewModel.getPercentProperty());
    }

}
