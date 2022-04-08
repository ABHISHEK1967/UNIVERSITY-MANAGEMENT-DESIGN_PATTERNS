package edu.dalhousie.business.dalmembership.controller.handler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class GoldHandlerTest {
    @Test
    void checkIfGoldHandlerClassIsNull() {
        GoldHandler goldHandler = null;
        Assertions.assertThrows(NullPointerException.class, () -> {
            goldHandler.nextHandler();
        });
    }

    @Test
    protected void ClassExistenceTest(){
        GoldHandler goldHandler = new GoldHandler();
        assertNotNull(goldHandler);
    }

    @Test
    void checkIfGoldHandlerProcessNextRequestIsNotNull() throws Exception {
        GoldHandler goldHandler = new GoldHandler();
        assertNotNull(goldHandler.processNextRequest("gold"));
    }
}
