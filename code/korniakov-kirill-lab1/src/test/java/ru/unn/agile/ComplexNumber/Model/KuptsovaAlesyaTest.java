package ru.unn.agile.ComplexNumber.Model;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ru.unn.agile.ComplexNumber.model.ComplexNumber;

import static java.lang.String.valueOf;
import static junit.framework.TestCase.assertEquals;

public class KuptsovaAlesyaTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void canNotCreateComplexNumberWithUncorrectValues() {
        String re = "3.14";
        String im = "-rjfho;i";
        thrown.expect(IllegalArgumentException.class);
        ComplexNumber z = new ComplexNumber(re, im);
    }
    @Test
    public void canGetRealFromComplexNumberWithARealPart() {
        String re = "3.14";
        String im = "-13.0";
        ComplexNumber z = new ComplexNumber(re, im);
        double num = z.getReal();
        String num_str = valueOf(num);
        assertEquals(re, num_str);
    }
    @Test
    public void canGetImaginaryFromComplexNumberWithImaginaryPart() {
        String re = "3.14";
        String im = "-13.0";
        ComplexNumber z = new ComplexNumber(re, im);
        double num = z.getImaginary();
        String num_str = valueOf(num);
        assertEquals(im, num_str);
    }

    @Test
    public void canMultiplyNumbersWithNegativePartS() {
        ComplexNumber z1 = new ComplexNumber(-1, 4);
        ComplexNumber z2 = new ComplexNumber(-2, -3);
        ComplexNumber num = z1.multiply(z2);
        assertEquals(new ComplexNumber(14, -5), num);
    }
}
