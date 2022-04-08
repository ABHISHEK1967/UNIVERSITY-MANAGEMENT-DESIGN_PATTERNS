package edu.dalhousie.business.registration.controller;

import edu.dalhousie.business.registration.constants.RegistrationConstants;
import edu.dalhousie.business.registration.database.IAddMembership;
import edu.dalhousie.business.registration.database.IGetUSer;
import edu.dalhousie.business.registration.database.ISaveUser;
import edu.dalhousie.business.registration.model.IUser;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

public class RegisterUser implements IRegisterUser {
    @Override
    public void saveUserIntoDatabase() {
        ICommonPrinting view = CommonPrinting.getInstance();
        ISaveUser saveUser = RegistrationFactory.getInstance().getSaveUser();
        IUser user = RegistrationFactory.getInstance().getUser();
        IGetUSer getUSer = RegistrationFactory.getInstance().getFetchUser();
        IAddMembership addMembership = RegistrationFactory.getInstance().getAddMembership();

        view.showMessage(RegistrationConstants.VERIFYING_YOUR_DETAILS);
        if (saveUser.saveUserDetails() == 1) {
            view.showMessage(RegistrationConstants.DETAILS_VERIFIED);
            view.showMessage(RegistrationConstants.YOUR_USERNAME.replace("userName", user.getUsername()));
            view.showMessage(RegistrationConstants.PLEASE_LOGIN);
            int userId = getUSer.getUserDetailByUsername(user.getUsername());
            if (addMembership.addMembershipDetails(userId) == 1) {
                view.showMessage(RegistrationConstants.MEMBERSHIP_CREATED);
            }
        } else {
            view.showMessage(RegistrationConstants.SOMETHING_WENT_WRONG_PLEASE_TRY_AGAIN);
        }
    }
}
