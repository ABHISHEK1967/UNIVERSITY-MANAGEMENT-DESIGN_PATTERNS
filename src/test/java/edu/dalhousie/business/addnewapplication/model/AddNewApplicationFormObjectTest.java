package edu.dalhousie.business.addnewapplication.model;

import edu.dalhousie.business.payment.model.PaymentDetails;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddNewApplicationFormObjectTest {

    private static AddNewApplicationFormObject addNewApplicationFormObject;

    @BeforeAll
    public static void setup() {
        addNewApplicationFormObject = new AddNewApplicationFormObject("macs", "iit", "2", "8.5", "90", "90", "8", "340", "5", "2", "600", "90");
    }

    @Test
    public void testCourse() {
        assertEquals("macs", addNewApplicationFormObject.getCourse());
    }

    @Test
    public void testUniversity() {
        assertEquals("iit", addNewApplicationFormObject.getUniversity());
    }

    @Test
    public void testEducation() {
        assertEquals("2", addNewApplicationFormObject.getEducation());
    }

    @Test
    public void testGPA() {
        assertEquals("8.5", addNewApplicationFormObject.getGpa());
    }

    @Test
    public void testTenthPercentage() {
        assertEquals("90", addNewApplicationFormObject.getTenthMarks());
    }

    @Test
    public void testTwelfthPercentage() {
        assertEquals("90", addNewApplicationFormObject.getTwelfthMarks());
    }

    @Test
    public void testIELTS() {
        assertEquals("8", addNewApplicationFormObject.getIELTS());
    }

    @Test
    public void testGRE() {
        assertEquals("340", addNewApplicationFormObject.getGRE());
    }

    @Test
    public void testResearchPapers() {
        assertEquals("5", addNewApplicationFormObject.getResearchPapers());
    }

    @Test
    public void testWorkExperience() {
        assertEquals("2", addNewApplicationFormObject.getWorkExp());
    }

    @Test
    public void testGMAT() {
        assertEquals("600", addNewApplicationFormObject.getGMAT());
    }

    @Test
    public void testGATE() {
        assertEquals("90", addNewApplicationFormObject.getGATE());
    }

}