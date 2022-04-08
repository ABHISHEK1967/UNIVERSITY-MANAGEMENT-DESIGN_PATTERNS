/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.payment.controller.FullPayment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class FullPaymentTest {
    private static FullPayment fullPayment;
    @BeforeAll
    public static void setUp() {
        fullPayment = Mockito.mock(FullPayment.class);
    }
    @Test
    public void deductTotalAmountTest() throws Exception {
        fullPayment.deductTotalAmount();
        verify(fullPayment,times(1)).deductTotalAmount();
    }
}
