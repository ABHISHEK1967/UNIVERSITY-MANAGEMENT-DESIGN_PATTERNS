package edu.dalhousie.business.registration.business;

import edu.dalhousie.business.registration.constants.RegistrationConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateEmail implements IValidateEmail {
    @Override
    public boolean isInvalidEmail(String email) {
        Pattern pattern = Pattern.compile(RegistrationConstants.EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return !matcher.matches();
    }
}
