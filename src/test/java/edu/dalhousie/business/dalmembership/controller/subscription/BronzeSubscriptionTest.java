package edu.dalhousie.business.dalmembership.controller.subscription;

import edu.dalhousie.business.dalmembership.model.ServicesModel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BronzeSubscriptionTest {
    private static BronzeSubscription bronzeSubscription;
    @BeforeAll
    public static void setUp() {
        bronzeSubscription  = new BronzeSubscription();
        bronzeSubscription.initializeBasicSubscription();
    }

    @Test
    protected void calculateChargesTest(){
        assertEquals(0.0,bronzeSubscription.calculateCharges());
    }

    @Test
    protected void getMonthlyChargesTest(){
        assertEquals(0,bronzeSubscription.getMonthlyCharges());
    }

    @Test
    protected void calculatePercentageTest(){
        assertEquals(1.0,bronzeSubscription.calculatePercentage(10,10));
    }

    @Test
    protected void calculateDiscountTest(){
        assertEquals(15.0,bronzeSubscription.calculateDiscount(10.0,10.0));
    }

    @Test
    protected void applyDiscountTest(){
        assertEquals(1.0,bronzeSubscription
                .applyDiscount(11.0,10.0));
    }

    @Test
    protected void getAmountTest(){
        bronzeSubscription.setTotalAmount(100.0);
        assertEquals(100.0,bronzeSubscription
                .getTotalAmount());
    }

    @Test
    protected void getServicesListTest(){
        Set<ServicesModel> servicesList = new HashSet<>();
        servicesList.add(new ServicesModel("test1",2));
        servicesList.add(new ServicesModel("test2",4));
        bronzeSubscription.addServices(servicesList);
        assertEquals(4,bronzeSubscription
                .getServicesList().size());
    }
}
