package edu.dalhousie.business.dalmembership.model;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ServicesModelTest {
    private static ServicesModel services;

    @BeforeAll
    public static void setUp() {
        services = new ServicesModel("test",10);
    }

    @Test
    public void getNameTest(){
        assertEquals("test",services.getName());
    }

    @Test
    public void getChargesTest(){
        assertEquals(10,services.getCharges());
    }
}
