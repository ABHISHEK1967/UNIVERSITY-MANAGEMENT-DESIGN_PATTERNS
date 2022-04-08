package edu.dalhousie.business.dalmembership.controller.subscription;

import edu.dalhousie.business.dalmembership.model.ServicesModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SilverSubscriptionTest {
    private static SilverSubscription silverSubscription;
    @BeforeAll
    public static void setUp() {
        silverSubscription  = new SilverSubscription();
        silverSubscription.initializeBasicSubscription();
    }

    @Test
    protected void calculateChargesTest(){
        assertEquals(0.0,silverSubscription.calculateCharges());
    }

    @Test
    protected void getMonthlyChargesTest(){
        assertEquals(5.0,silverSubscription.getMonthlyCharges());
    }

    @Test
    protected void calculatePercentageTest(){
        assertEquals(1.0,silverSubscription.calculatePercentage(10,10));
    }

    @Test
    protected void calculateDiscountTest(){
        assertEquals(15.0,silverSubscription.calculateDiscount(10.0,10.0));
    }

    @Test
    protected void applyDiscountTest(){
        assertEquals(1.0,silverSubscription
                .applyDiscount(11.0,10.0));
    }

    @Test
    protected void getAmountTest(){
        silverSubscription.setTotalAmount(100.0);
        assertEquals(100.0,silverSubscription
                .getTotalAmount());
    }

    @Test
    protected void getServicesListTest(){
        Set<ServicesModel> servicesList = new HashSet<>();
        servicesList.add(new ServicesModel("test1",2));
        servicesList.add(new ServicesModel("test2",4));
        silverSubscription.addServices(servicesList);
        assertEquals(4,silverSubscription
                .getServicesList().size());
    }
}
