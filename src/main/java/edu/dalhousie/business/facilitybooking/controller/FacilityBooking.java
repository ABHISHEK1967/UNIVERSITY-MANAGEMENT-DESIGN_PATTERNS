package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.business.IValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;
import edu.dalhousie.utilities.Constants;
import edu.dalhousie.utilities.printing.PrintHeading;

public class FacilityBooking implements IFacilityBooking {
    public static String userName = "";

    public void renderFacilityBookingForm() {
        ICommonPrinting view = CommonPrinting.getInstance();
        IValidateFacilityBooking validateFacilityBooking = FacilityBookingFactory.getInstance().getValidateFacilityBooking();
        IBookFacilityForm bookFacilityForm = FacilityBookingFactory.getInstance().getBookFacilityForm();
        String username = "";

        view.showMessage(FacilityBookingConstants.ENTER_YOUR_USERNAME);
        username = view.getString();
        if (validateFacilityBooking.isValidUsername(username)) {
            userName = username;
            bookFacilityForm.renderFacilityForm();
        } else {
            view.showMessage(FacilityBookingConstants.PLEASE_PROVIDE_VALID_USERNAME);
        }
    }

    public void startFacilityBookingService() {
        ICommonPrinting view = CommonPrinting.getInstance();

        PrintHeading.printHeadingForTheScreen(FacilityBookingConstants.FACILITY_BOOKING, 42);
        renderFacilityBookingForm();

        System.out.println(Constants.PRESS_ENTER_TO_GO_BACK);
        view.getString();
    }
}
