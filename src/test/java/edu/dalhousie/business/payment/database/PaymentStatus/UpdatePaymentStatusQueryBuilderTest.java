/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.payment.database.PaymentStatus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UpdatePaymentStatusQueryBuilderTest {
    @Test
    public void updatePaymentStatus(){
        UpdatePaymentStatusQueryBuilder updatePaymentStatusQueryBuilder
                = UpdatePaymentStatusQueryBuilder.getInstance();
        String expectedQuery = updatePaymentStatusQueryBuilder
                .updatePaymentStatus(1,"emi","fall");
        String actualQuery = "INSERT INTO payment(payment_status, student_id, term)" +
                "VALUES('emi' ,1,'fall')";
        assertEquals(expectedQuery,actualQuery);
    }
}
