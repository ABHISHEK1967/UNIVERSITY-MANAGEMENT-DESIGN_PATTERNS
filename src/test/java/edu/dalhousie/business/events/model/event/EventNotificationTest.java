package edu.dalhousie.business.events.model.event;


import edu.dalhousie.business.events.model.Event.EventNotification;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class EventNotificationTest {
    private static EventNotification eventNotification;
    @BeforeAll
    public static void setUp(){
        eventNotification = Mockito.mock(EventNotification.class);
    }

    @Test
    public void sendEventNotificationToVolunteersTest(){
        eventNotification.sendEventNotificationToVolunteers();
        verify(eventNotification,times(1))
                .sendEventNotificationToVolunteers();
    }
    @Test
    public void invitationStatusTest(){
        eventNotification.invitationStatus();
        verify(eventNotification,times(1))
                .invitationStatus();
    }
    @Test
    public void sendWinnerMessageTest(){
        eventNotification.sendWinnerMessage();
        verify(eventNotification,times(1))
                .sendWinnerMessage();
    }
}
