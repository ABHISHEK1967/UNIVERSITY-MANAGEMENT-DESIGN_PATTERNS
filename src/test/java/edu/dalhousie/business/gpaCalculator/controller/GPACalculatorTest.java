package edu.dalhousie.business.gpaCalculator.controller;

import edu.dalhousie.utilities.printing.ICommonPrinting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.util.reflection.FieldSetter;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GPACalculatorTest {

    ICommonPrinting viewMock = Mockito.mock(ICommonPrinting.class);
    GPACalculator gpaCalculator = new GPACalculator();

    @BeforeEach
    public void init() throws  Exception {
        FieldSetter viewField = new FieldSetter(gpaCalculator, GPACalculator.class.getDeclaredField("view"));
        viewField.set(viewMock);
    }

//    @Test
//    public void testGPACalculator() {
//        Mockito.when(viewMock.getString()).thenReturn("3", "A-", "no");
//        assertTrue(Math.abs(3.33 - Double.parseDouble(gpaCalculator.calculateGPA())) < 1e-5);
//    }

}
