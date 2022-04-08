package edu.dalhousie.business.events.model.winner;


import edu.dalhousie.business.events.model.Winner.EventWinner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EventWinnerTest {
    private static EventWinner eventWinner;
    @BeforeAll
    public static void setUp() {
        eventWinner = new EventWinner();
        eventWinner.setWinnerName("test");
    }

    @Test
    public void getEventWinnerTest(){
        Assertions.assertEquals("test",eventWinner.getWinnerName());
    }
}
