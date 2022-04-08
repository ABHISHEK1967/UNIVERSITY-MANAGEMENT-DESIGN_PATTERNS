package edu.dalhousie.business.events.controller.state;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StateInProgressTest {
    private static StateContext stateContext;
    private static StateInProgress stateInProgress;
    @BeforeAll
    public static void setUp(){
        stateContext = new StateContext();
        stateInProgress = Mockito.mock(StateInProgress.class);
    }

    @Test
    public void performStateTransitionTest(){
        stateInProgress.performStateTransition(stateContext);
        verify(stateInProgress,times(1))
                .performStateTransition(stateContext);
    }
}
