package edu.dalhousie.business.feedback.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackUserInputValidationModelTest {

    private static FeedbackUserInputValidationModel feedbackUserInputValidationModel;

    @BeforeAll
    public static void setup() {
        feedbackUserInputValidationModel = new FeedbackUserInputValidationModel(true, "success");
    }

    @Test
    public void testValidFeedbackUserInput() {
        assertEquals(true, feedbackUserInputValidationModel.getValid());
    }

    @Test
    public void testFeedbackUserInputMessage() {
        assertEquals("success", feedbackUserInputValidationModel.getMessage());
    }

}