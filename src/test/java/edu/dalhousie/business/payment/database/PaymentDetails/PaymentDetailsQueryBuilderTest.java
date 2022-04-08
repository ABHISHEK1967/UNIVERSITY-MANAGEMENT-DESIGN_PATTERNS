/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.payment.database.PaymentDetails;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentDetailsQueryBuilderTest {
    @Test
    public void selectEnrolledCoursesQuery(){
        PaymentDetailsQueryBuilder paymentDetailsQueryBuilder
                = PaymentDetailsQueryBuilder.getInstance();
        String expectedQuery = paymentDetailsQueryBuilder.selectEnrolledCoursesQuery(1);
        String actualQuery = "SELECT course_name,CT.course_type,student_id,C.course_id " +
                "FROM course_enrolled AS CE " +
                "INNER JOIN courses AS C ON CE.course_id = C.course_id " +
                "INNER JOIN course_type AS CT ON CT.id = C.course_type" +
                " WHERE student_id = 1";
        assertEquals(expectedQuery,actualQuery);
    }
}
