package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.business.IValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

public class BookFacilityForm implements IBookFacilityForm {
    @Override
    public void bookFacilityForm() {
        ICommonPrinting view = CommonPrinting.getInstance();
        IValidateFacilityBooking validate = FacilityBookingFactory.getInstance().getValidateFacilityBooking();
        IBookValidFacility bookValidFacility = FacilityBookingFactory.getInstance().getBookValidFacility();
        String facilityId = "";

        view.showMessage(FacilityBookingConstants.ENTER_ID_FROM_LIST);
        facilityId = view.getString();
        while (validate.isInvalidFacilityId(facilityId)) {
            view.showMessage(FacilityBookingConstants.ENTER_VALID_ID_FROM_LIST);
            facilityId = view.getString();
        }
        bookValidFacility.bookFacility(Integer.parseInt(facilityId));
    }

    @Override
    public void renderFacilityForm() {
        ICommonPrinting view = CommonPrinting.getInstance();
        IValidateFacilityBooking validate = FacilityBookingFactory.getInstance().getValidateFacilityBooking();
        IShowFacilityAvailability showFacility = FacilityBookingFactory.getInstance().getShowFacilityAvailability();
        String facilityChoice = "";

        view.showMessage(FacilityBookingConstants.ENTER_CHOICE_FOR_FACILITY);
        facilityChoice = view.getString();
        while (validate.isInvalidFacilityChoice(facilityChoice)) {
            view.showMessage(FacilityBookingConstants.PLEASE_PROVIDE_VALID_CHOICE);
            view.showMessage(FacilityBookingConstants.ENTER_CHOICE_FOR_FACILITY);
            facilityChoice = view.getString();
        }
        facilityChoice = FacilityBookingConstants.facilities.get(Integer.parseInt(facilityChoice));
        showFacility.renderFacilityAvailability(facilityChoice);
        bookFacilityForm();
    }
}
