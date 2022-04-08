package edu.dalhousie.business.feedback.model;

public class FeedbackUserInputValidationModel {

    Boolean valid;
    String message;

    public FeedbackUserInputValidationModel() { }

    public FeedbackUserInputValidationModel(Boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
