package edu.dalhousie.business.events.controller.email;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EmailTest {
    private static Email email;
    @BeforeAll
    public static void setUp(){
        email = new Email("test","Students have won various awards");
    }
    @Test
    public void getSubjectTest(){
        Assertions.assertEquals("test",email.getSubject());
    }
    @Test
    public void getBodyTest(){
        Assertions.assertEquals("Students have won various awards",email.getBody());
    }
}
