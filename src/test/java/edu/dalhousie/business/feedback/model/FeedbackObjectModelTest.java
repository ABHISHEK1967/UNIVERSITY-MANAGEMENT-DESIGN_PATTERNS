package edu.dalhousie.business.feedback.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackObjectModelTest {

    private static FeedbackObjectModel feedbackObjectModel;

    @BeforeAll
    public static void setup() {
        feedbackObjectModel = new FeedbackObjectModel("CSCI1234", "Good", 1,2,3,4,5);
    }

    @Test
    public void testCourseID() {
        assertEquals("CSCI1234", feedbackObjectModel.getCourseID());
    }

    @Test
    public void testFeedback() {
        assertEquals("Good", feedbackObjectModel.getFeedback());
    }

    @Test
    public void testProfessorRating() {
        assertEquals(1, feedbackObjectModel.getProfessorRating());
    }

    @Test
    public void testDifficultyLevel() {
        assertEquals(2, feedbackObjectModel.getDifficultyLevel());
    }

    @Test
    public void testRecommendation() {
        assertEquals(3, feedbackObjectModel.getRecommendation());
    }

    @Test
    public void testProfessionalDevelopment() {
        assertEquals(4, feedbackObjectModel.getProfessionalDevelopment());
    }

    @Test
    public void testNeedsMet() {
        assertEquals(5, feedbackObjectModel.getNeedsMet());
    }

}