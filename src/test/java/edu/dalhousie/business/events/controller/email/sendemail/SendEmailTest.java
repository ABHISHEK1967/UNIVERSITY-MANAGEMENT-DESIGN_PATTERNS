package edu.dalhousie.business.events.controller.email.sendemail;


import edu.dalhousie.business.events.controller.email.Email;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class SendEmailTest {
    private static SendEmail sendEmail;
    private static Email email;
    @BeforeAll
    public static void setUp() {
        sendEmail = Mockito.mock(SendEmail.class);
        email =new Email("test","test");
    }

    @Test
    public void sendEmailTest(){
        sendEmail.sendEmail("test@gmail.com",email);
        verify(sendEmail,times(1))
                .sendEmail("test@gmail.com",email);
    }
}
