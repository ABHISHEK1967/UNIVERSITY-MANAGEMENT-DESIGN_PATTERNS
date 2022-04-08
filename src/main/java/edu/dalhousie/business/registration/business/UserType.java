package edu.dalhousie.business.registration.business;

import edu.dalhousie.business.registration.constants.RegistrationConstants;

public class UserType implements IUserType {
    public boolean isStudent(String typeOfUser) {
        return typeOfUser.equals(RegistrationConstants.STUDENT);
    }
}
