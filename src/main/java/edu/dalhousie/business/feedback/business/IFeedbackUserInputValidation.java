package edu.dalhousie.business.feedback.business;

import edu.dalhousie.business.feedback.model.FeedbackUserInputValidationModel;

public interface IFeedbackUserInputValidation {
    public FeedbackUserInputValidationModel validateFeedbackMenuInput(int menuInput);
}
