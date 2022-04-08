package edu.dalhousie.business.dalmembership.controller.subscription;

import edu.dalhousie.business.dalmembership.model.ServicesModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldSubscriptionTest {
    private static GoldSubscription goldSubscription;
    @BeforeAll
    public static void setUp() {
        goldSubscription  = new GoldSubscription();
        goldSubscription.initializeBasicSubscription();
    }

    @Test
    protected void calculateChargesTest(){
        assertEquals(0.0,goldSubscription.calculateCharges());
    }

    @Test
    protected void getMonthlyChargesTest(){
        assertEquals(10.0,goldSubscription.getMonthlyCharges());
    }

    @Test
    protected void calculatePercentageTest(){
        assertEquals(1.0,goldSubscription.calculatePercentage(10,10));
    }

    @Test
    protected void calculateDiscountTest(){
        assertEquals(15.0,goldSubscription.calculateDiscount(10.0,10.0));
    }

    @Test
    protected void applyDiscountTest(){
        assertEquals(1.0,goldSubscription
                .applyDiscount(11.0,10.0));
    }

    @Test
    protected void getAmountTest(){
        goldSubscription.setTotalAmount(100.0);
        assertEquals(100.0,goldSubscription
                .getTotalAmount());
    }

    @Test
    protected void getServicesListTest(){
        Set<ServicesModel> servicesList = new HashSet<>();
        servicesList.add(new ServicesModel("test1",2));
        servicesList.add(new ServicesModel("test2",4));
        goldSubscription.addServices(servicesList);
        assertEquals(4,goldSubscription
                .getServicesList().size());
    }
}
