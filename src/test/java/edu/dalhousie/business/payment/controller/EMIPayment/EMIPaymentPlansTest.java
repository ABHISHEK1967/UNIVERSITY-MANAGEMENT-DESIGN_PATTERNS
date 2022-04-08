/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.payment.controller.EMIPayment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
public class EMIPaymentPlansTest {
    private static EMIPaymentPlans emiPaymentPlans;
    @BeforeAll
    public static void setUp() {
        emiPaymentPlans = Mockito.mock(EMIPaymentPlans.class);
    }

    @Test
    public void showEMIStructureTest() throws Exception {
        emiPaymentPlans.showEMIStructure();
        verify(emiPaymentPlans,times(1)).showEMIStructure();
    }
}
