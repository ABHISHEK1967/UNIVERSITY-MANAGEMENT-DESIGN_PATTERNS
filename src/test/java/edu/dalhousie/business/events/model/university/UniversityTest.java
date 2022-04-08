package edu.dalhousie.business.events.model.university;

import edu.dalhousie.business.events.model.University.University;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UniversityTest {
    private static University university;
    @BeforeAll
    public static void setUp() {
        university = new University("test");
    }

    @Test
    public void getUniversityNameTest(){
        Assertions.assertEquals("test",university.getUniversityName());
    }
}
