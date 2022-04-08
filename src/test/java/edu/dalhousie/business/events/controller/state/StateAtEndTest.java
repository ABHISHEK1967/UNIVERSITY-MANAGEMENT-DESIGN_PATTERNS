package edu.dalhousie.business.events.controller.state;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StateAtEndTest {
    private static StateContext stateContext;
    private static StateAtEnd stateAtEnd;
    @BeforeAll
    public static void setUp(){
        stateContext = new StateContext();
        stateAtEnd = Mockito.mock(StateAtEnd.class);
    }

    @Test
    public void performStateTransitionTest(){
        stateAtEnd.performStateTransition(stateContext);
        verify(stateAtEnd,times(1))
                .performStateTransition(stateContext);
    }
}
