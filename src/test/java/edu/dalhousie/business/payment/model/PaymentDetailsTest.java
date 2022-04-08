package edu.dalhousie.business.payment.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class PaymentDetailsTest {
    private static PaymentDetails paymentDetails;
    @BeforeAll
    public static void setUp() {
      paymentDetails = new PaymentDetails(1,1,"test","test");
    }

    @Test
    public void getCourseIdTest(){
        Assertions.assertEquals(1,paymentDetails.getCourseId());
    }
    @Test
    public void getStudentIdTest(){
        Assertions.assertEquals(1,paymentDetails.getStudentId());
    }
    @Test
    public void getCourseNameTest(){
        Assertions.assertEquals("test",paymentDetails.getCourseName());
    }
    @Test
    public void getCourseTypeTest(){
        Assertions.assertEquals("test",paymentDetails.getCourseType());
    }

}
