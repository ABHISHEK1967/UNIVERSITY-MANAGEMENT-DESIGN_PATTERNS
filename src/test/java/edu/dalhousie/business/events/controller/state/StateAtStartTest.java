package edu.dalhousie.business.events.controller.state;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StateAtStartTest {
    private static StateContext stateContext;
    private static StateAtStart stateAtStart;
    @BeforeAll
    public static void setUp(){
        stateContext = new StateContext();
        stateAtStart = Mockito.mock(StateAtStart.class);
    }

    @Test
    public void performStateTransitionTest(){
        stateAtStart.performStateTransition(stateContext);
        verify(stateAtStart,times(1))
                .performStateTransition(stateContext);
    }
}
