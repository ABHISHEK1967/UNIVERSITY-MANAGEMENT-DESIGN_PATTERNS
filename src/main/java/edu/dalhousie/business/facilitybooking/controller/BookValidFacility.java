package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.business.IPickFacility;
import edu.dalhousie.business.facilitybooking.business.IValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.business.facilitybooking.databse.IBookFacility;
import edu.dalhousie.business.facilitybooking.databse.IUsersBookedFacilities;
import edu.dalhousie.business.facilitybooking.model.Facility;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;


public class BookValidFacility implements IBookValidFacility {
    public void showResultMessage(int result) {
        ICommonPrinting view = CommonPrinting.getInstance();
        if (result == 1) {
            view.showMessage(FacilityBookingConstants.BOOKING_SUCCESSFUL);
        } else {
            view.showMessage(FacilityBookingConstants.SOMETHING_WENT_WRONG_PLEASE_TRY_AGAIN);
        }
    }

    public void checkForSlotsConflicts(Facility facility) {
        ICommonPrinting view = CommonPrinting.getInstance();
        int result = -1;
        IValidateFacilityBooking validate = FacilityBookingFactory.getInstance().getValidateFacilityBooking();
        IBookFacility bookFacilityApi = FacilityBookingFactory.getInstance().getBookFacility();

        if (validate.hasConflictWithBooking(facility)) {
            view.showMessage(FacilityBookingConstants.ALREADY_BOOKED_SLOT);
        } else {
            result = bookFacilityApi.bookFacility(facility);
            showResultMessage(result);
        }
    }

    @Override
    public void bookFacility(int facilityId) {
        ICommonPrinting view = CommonPrinting.getInstance();
        IPickFacility pickFacility = FacilityBookingFactory.getInstance().getPickFacility();
        IUsersBookedFacilities usersBookedFacilities = FacilityBookingFactory.getInstance().getUsersBookedFacilities();

        usersBookedFacilities.getBookedFacilitiesByUsername(FacilityBooking.userName);
        Facility facility = pickFacility.getFacilityById(facilityId);
        if (facility.getAvailableSlots() > 0) {
            checkForSlotsConflicts(facility);
        } else {
            view.showMessage(FacilityBookingConstants.NO_SLOTS_AVAILABLE);
        }
    }
}
