package edu.dalhousie.business.registration.business;

import edu.dalhousie.business.registration.constants.RegistrationConstants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateContactNumber implements IValidateContactNumber {
    @Override
    public boolean isInvalidContactNumber(String contactNumber) {
        Pattern pattern = Pattern.compile(RegistrationConstants.CONTACT_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(contactNumber);
        return !matcher.matches();
    }
}
