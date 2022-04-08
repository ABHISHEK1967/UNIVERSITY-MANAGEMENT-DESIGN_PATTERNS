package edu.dalhousie.business.events.controller.cost;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class EventCostTest {
    private static EventCost eventCost;
    @BeforeAll
    public static void setUp() {
        eventCost = Mockito.mock(EventCost.class);
    }

    @Test
    public void showExistingBalanceTest(){
        eventCost.studentPayment(10);
        verify(eventCost,times(1)).studentPayment(10);
    }

}
