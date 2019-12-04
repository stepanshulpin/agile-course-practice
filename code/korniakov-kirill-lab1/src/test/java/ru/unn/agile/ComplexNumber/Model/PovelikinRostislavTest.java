package ru.unn.agile.ComplexNumber.Model;

import org.junit.Test;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static org.junit.Assert.*;

public class PovelikinRostislavTest {
    @Test
    public void canCreateDefaultComplexNumber() {
        ComplexNumber number = new ComplexNumber();
        assertNotNull(number);
    }

    @Test
    public void isDefaultComplexNumberNeutral() {
        ComplexNumber defaultNumber = new ComplexNumber();
        ComplexNumber z = new ComplexNumber(1, 2);

        ComplexNumber sum  = z.add(defaultNumber);

        assertTrue(sum.equals(z));
    }
}
