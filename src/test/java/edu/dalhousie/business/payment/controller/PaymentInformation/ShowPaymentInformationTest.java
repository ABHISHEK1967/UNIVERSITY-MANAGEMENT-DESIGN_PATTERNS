/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.payment.controller.PaymentInformation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ShowPaymentInformationTest {
    private static ShowPaymentInformation showPaymentInformation;

    @BeforeAll
    public static void setUp() {
        showPaymentInformation = Mockito.mock(ShowPaymentInformation.class);
    }

    @Test
    public void showPaymentInformationTest() throws Exception {
        showPaymentInformation.showFeeDetails();
        verify(showPaymentInformation,times(1)).showFeeDetails();
    }
}
