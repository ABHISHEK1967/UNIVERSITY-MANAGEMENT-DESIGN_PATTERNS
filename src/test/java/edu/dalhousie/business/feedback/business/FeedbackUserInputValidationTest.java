package edu.dalhousie.business.feedback.business;

import edu.dalhousie.business.feedback.model.FeedbackUserInputValidationModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedbackUserInputValidationTest {

    @Test
    public void testValidFeedbackMenuInput() {
        FeedbackUserInputValidation feedbackUserInputValidation = new FeedbackUserInputValidation();
        FeedbackUserInputValidationModel validate = feedbackUserInputValidation.validateFeedbackMenuInput(3);
        assertEquals(true, validate.getValid());
    }

    @Test
    public void testInvalidFeedbackMenuInput() {
        FeedbackUserInputValidation feedbackUserInputValidation = new FeedbackUserInputValidation();
        FeedbackUserInputValidationModel validate = feedbackUserInputValidation.validateFeedbackMenuInput(5);
        assertEquals(false, validate.getValid());
    }

}