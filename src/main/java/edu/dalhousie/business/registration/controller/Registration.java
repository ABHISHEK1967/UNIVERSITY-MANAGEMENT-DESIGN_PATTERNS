package edu.dalhousie.business.registration.controller;

import edu.dalhousie.business.registration.business.IUserType;
import edu.dalhousie.business.registration.constants.RegistrationConstants;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;
import edu.dalhousie.utilities.Constants;
import edu.dalhousie.utilities.printing.PrintHeading;

public class Registration implements IRegistration {
    @Override
    public void registerUser(String typeOfUser) {
        ICommonPrinting view = CommonPrinting.getInstance();
        IUserType userType = RegistrationFactory.getInstance().getUserType();
        IRegisterUser registerUser = RegistrationFactory.getInstance().getRegisterUser();
        IRegistrationForm registrationForm = RegistrationFactory.getInstance().getRegistrationForm();

        String title = userType.isStudent(typeOfUser) ? RegistrationConstants.REGISTER_AS_A_STUDENT : RegistrationConstants.REGISTER_AS_A_FACULTY;
        PrintHeading.printHeadingForTheScreen(title, 38);
        registrationForm.renderRegistrationForm(typeOfUser);
        registerUser.saveUserIntoDatabase();

        System.out.println(Constants.PRESS_ENTER_TO_GO_BACK);
        view.getString();
    }
}
