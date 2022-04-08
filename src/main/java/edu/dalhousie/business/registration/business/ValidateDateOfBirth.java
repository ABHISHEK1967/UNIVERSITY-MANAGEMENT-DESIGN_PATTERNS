package edu.dalhousie.business.registration.business;

import edu.dalhousie.business.registration.constants.RegistrationConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateDateOfBirth implements IValidateDateOfBirth {
    @Override
    public boolean isInvalidDateOfBirth(String dateOfBirth) {
        Pattern pattern = Pattern.compile(RegistrationConstants.DATE_OF_BIRTH_REGEX);
        Matcher matcher = pattern.matcher(dateOfBirth);
        return !matcher.matches();
    }
}
