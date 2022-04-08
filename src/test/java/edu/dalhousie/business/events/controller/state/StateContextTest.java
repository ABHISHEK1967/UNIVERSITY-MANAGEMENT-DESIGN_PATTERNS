package edu.dalhousie.business.events.controller.state;

import edu.dalhousie.business.events.controller.email.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class StateContextTest {
    private static StateContext stateContext;
    @BeforeAll
    public static void setUp(){
        stateContext = new StateContext();

        stateContext.setState(stateContext.getState());
    }
    @Test
    public void getSubjectTest(){
        Assertions.assertNull(stateContext.getState());
    }

}
