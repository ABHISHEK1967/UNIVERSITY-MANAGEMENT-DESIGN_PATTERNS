package edu.dalhousie.business.addnewapplication.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class
AddNewApplicationFormValidationTest {

    private static AddNewApplicationFormValidation addNewApplicationFormValidation;

    @BeforeAll
    public static void setup() {
        addNewApplicationFormValidation = new AddNewApplicationFormValidation(true, "success");
    }

    @Test
    public void testIsValid() {
        assertEquals(true, addNewApplicationFormValidation.getValid());
    }

    @Test
    public void testMessage() {
        assertEquals("success", addNewApplicationFormValidation.getMessage());
    }
}