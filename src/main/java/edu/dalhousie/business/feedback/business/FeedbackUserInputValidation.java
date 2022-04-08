package edu.dalhousie.business.feedback.business;

import edu.dalhousie.business.feedback.constants.StringConstants;
import edu.dalhousie.business.feedback.model.FeedbackUserInputValidationModel;

public class FeedbackUserInputValidation implements IFeedbackUserInputValidation {

    public FeedbackUserInputValidationModel validateFeedbackMenuInput(int menuInput) {
        if (menuInput>=0 && menuInput<=4) {
            return new FeedbackUserInputValidationModel(true, StringConstants.kSuccess);
        }
        return new FeedbackUserInputValidationModel(false, StringConstants.kWrongInput);
    }

}
