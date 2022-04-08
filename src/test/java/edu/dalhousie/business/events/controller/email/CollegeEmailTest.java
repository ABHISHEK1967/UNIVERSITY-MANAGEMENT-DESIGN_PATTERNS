package edu.dalhousie.business.events.controller.email;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CollegeEmailTest {
    private static CollegeEmail collegeEmail;
    @BeforeAll
    public static void setUp() {
        collegeEmail = Mockito.mock(CollegeEmail.class);
    }

    @Test
    public void generateEmailTest(){
        collegeEmail.generateEmail();
        verify(collegeEmail,times(1))
                .generateEmail();
    }
}
