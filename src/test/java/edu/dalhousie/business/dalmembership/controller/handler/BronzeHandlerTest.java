package edu.dalhousie.business.dalmembership.controller.handler;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BronzeHandlerTest {

    @Test
    void checkIfBronzeHandlerClassIsNull() {
        BronzeHandler bronzeHandler = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            bronzeHandler.nextHandler();
        });
    }

    @Test
    protected void ClassExistenceTest(){
        BronzeHandler bronzeHandler = new BronzeHandler();
        assertNotNull(bronzeHandler);
    }

    @Test
    void checkIfBronzeHandlerProcessNextRequestIsNotNull() throws Exception {
        BronzeHandler bronzeHandler = new BronzeHandler();
        assertNotNull(bronzeHandler.processNextRequest("bronze"));
    }
}
