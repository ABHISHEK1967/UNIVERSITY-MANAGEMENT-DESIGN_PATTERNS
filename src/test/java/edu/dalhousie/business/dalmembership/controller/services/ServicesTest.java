package edu.dalhousie.business.dalmembership.controller.services;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ServicesTest {
    private static Services services;
    @BeforeAll
    public static void setUp() {
        services = Mockito.mock(Services.class);
    }

    @Test
    public void showExistingBalanceTest(){
        services.getListOfServices();
        verify(services,times(1)).getListOfServices();
    }
}
