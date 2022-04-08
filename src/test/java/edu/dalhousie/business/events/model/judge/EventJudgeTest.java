package edu.dalhousie.business.events.model.judge;

import edu.dalhousie.business.events.model.Judge.EventJudge;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EventJudgeTest {
    private static EventJudge eventJudge;
    @BeforeAll
    public static void setUp() {
        eventJudge = new EventJudge();
    }

    @Test
    public void getJudgeNameTest(){
        assertNotNull(eventJudge);
    }


}
