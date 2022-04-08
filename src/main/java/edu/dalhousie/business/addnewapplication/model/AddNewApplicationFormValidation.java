package edu.dalhousie.business.addnewapplication.model;

public class AddNewApplicationFormValidation {

    Boolean valid;
    String message;

    public AddNewApplicationFormValidation(Boolean valid, String message) {
        this.valid = valid;
        this.message = message;
    }

    public AddNewApplicationFormValidation() {

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
