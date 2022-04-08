package edu.dalhousie.business.events.controller.email;


import edu.dalhousie.business.events.controller.email.StudentEmail;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class StudentEmailTest {
    private static StudentEmail studentEmail;
    @BeforeAll
    public static void setUp() {
        studentEmail = Mockito.mock(StudentEmail.class);
    }

    @Test
    public void generateEmailTest(){
        studentEmail.generateEmail();
        verify(studentEmail,times(1))
                .generateEmail();
    }
}
