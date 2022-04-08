package edu.dalhousie.business.events.controller.email;

import edu.dalhousie.business.events.controller.email.EmailFactory;
import edu.dalhousie.business.events.controller.email.IEmail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class EmailFactoryTest {
    private static EmailFactory emailFactory;

    @BeforeAll
    public static void setUp() {
        emailFactory = new EmailFactory();
    }

    @Test
    public void generateStudentEmailTest(){
        IEmail email = emailFactory.getEmailTemplate("STUDENT");
        Assertions.assertTrue(email instanceof  IEmail);
    }

    @Test
    public void generateCollegeEmailTest(){
        IEmail email = emailFactory.getEmailTemplate("college");
        Assertions.assertTrue(email instanceof  IEmail);
    }
}

