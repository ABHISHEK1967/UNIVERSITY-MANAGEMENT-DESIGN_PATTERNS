package edu.dalhousie.business.gpaCalculator.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GPACalculatorModelTest {

    private static GPACalculatorModel gpaCalculatorModel;

    @BeforeAll
    public static void setFields() {
        gpaCalculatorModel = new GPACalculatorModel(0.00,0,0,"4",4.00,"A+",8,"0.00",4);
    }

    @Test
    public void testtotalPoints() {
        assertEquals(0.00, gpaCalculatorModel.getTotalPoints());
    }

    @Test
    public void testtotalCredits() {
        assertEquals(0, gpaCalculatorModel.getTotalCredits());
    }

    @Test
    public void testcredits() {
        assertEquals(0, gpaCalculatorModel.getCredits());
    }

    @Test
    public void testsubjectCredits() {
        assertEquals("4", gpaCalculatorModel.getSubjectCredits());
    }

    @Test
    public void testgradeValue() {
        assertEquals(4.00, gpaCalculatorModel.getGradeValue());
    }

    @Test
    public void testgrade() {
        assertEquals("A+", gpaCalculatorModel.getGrade());
    }

    @Test
    public void testpoints() {
        assertEquals(8, gpaCalculatorModel.getPoints());
    }

    @Test
    public void testpattern() {
        assertEquals("0.00", gpaCalculatorModel.getPattern());
    }

    @Test
    public void testoverallGPA() {
        assertEquals(4, gpaCalculatorModel.getOverallGPA());
    }

}