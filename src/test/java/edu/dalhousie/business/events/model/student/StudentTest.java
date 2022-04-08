package edu.dalhousie.business.events.model.student;

import edu.dalhousie.business.events.model.Student.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    private static Student student;
    @BeforeAll
    public static void setUp() {
        student = new Student();
        student.setUserName("test");
    }
    @Test
    public void getJudgeNameTest(){
        assertEquals("test",student.getUserName());
    }
}
