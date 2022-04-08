package edu.dalhousie.business.dalmembership.controller.handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class SilverHandlerTest {

    @Test
    void checkIfSilverHandlerClassIsNull() {
        SilverHandler silverHandler = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            silverHandler.nextHandler();
        });
    }

    @Test
    protected void ClassExistenceTest(){
        SilverHandler silverHandler = new SilverHandler();
        assertNotNull(silverHandler);
    }

    @Test
    void checkIfSilverHandlerProcessNextRequestIsNotNull() throws Exception {
        SilverHandler silverHandler = new SilverHandler();
        assertNotNull(silverHandler.processNextRequest("Silver"));
    }
}
