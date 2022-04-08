package edu.dalhousie.business.viewprofile.business;

import edu.dalhousie.business.viewprofile.constants.ViewProfileConstants;

public class UserType implements IUserType {
    public boolean isStudent(String typeOfLogIn) {
        return typeOfLogIn.equals(ViewProfileConstants.userTypeStudent);
    }
}
