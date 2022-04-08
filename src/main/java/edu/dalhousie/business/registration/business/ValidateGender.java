package edu.dalhousie.business.registration.business;

import edu.dalhousie.business.registration.constants.RegistrationConstants;

public class ValidateGender implements IValidateGender {
    @Override
    public boolean isInvalidGender(String gender) {
        if (gender.matches("\\d")) {
            int choice = Integer.parseInt(gender);
            return !RegistrationConstants.genders.containsKey(choice);
        } else {
            return true;
        }
    }
}
