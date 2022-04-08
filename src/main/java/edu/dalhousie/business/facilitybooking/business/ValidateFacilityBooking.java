package edu.dalhousie.business.facilitybooking.business;

import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.business.facilitybooking.controller.FacilityBookingFactory;
import edu.dalhousie.business.facilitybooking.databse.IGetAllUsers;
import edu.dalhousie.business.facilitybooking.model.Facility;
import edu.dalhousie.business.facilitybooking.model.IAvailableFacilitySlots;
import edu.dalhousie.business.facilitybooking.model.IBookedFacilities;

import java.util.ArrayList;
import java.util.List;

public class ValidateFacilityBooking implements IValidateFacilityBooking {
    @Override
    public boolean isValidUsername(String username) {
        IGetAllUsers users = FacilityBookingFactory.getInstance().getGetAllUsers();
        List<String> usernames = users.getAllUsers();
        return usernames.contains(username);
    }

    @Override
    public boolean isInvalidFacilityChoice(String facilityChoice) {
        if (facilityChoice.matches("\\d+")) {
            int choice = Integer.parseInt(facilityChoice);
            return !FacilityBookingConstants.facilityChoices.contains(choice);
        } else {
            return true;
        }
    }

    @Override
    public boolean isInvalidFacilityId(String facilityIdChoice) {
        IAvailableFacilitySlots facilitySlots = FacilityBookingFactory.getInstance().getAvailableFacilitySlots();
        if (facilityIdChoice.matches("\\d+")) {
            List<Integer> facilityIds = new ArrayList<>();
            int facilityId = Integer.parseInt(facilityIdChoice);
            for (Facility facility : facilitySlots.getFacilitySlots()) {
                facilityIds.add(facility.getFacilityId());
            }
            return !facilityIds.contains(facilityId);
        } else {
            return true;
        }
    }

    @Override
    public boolean hasConflictWithBooking(Facility facility) {
        IBookedFacilities bookedFacilities = FacilityBookingFactory.getInstance().getBookedFacilities();
        boolean flag = false;

        for (Facility facilityObject : bookedFacilities.getBookedFacilities()) {
            boolean isSameDate = facilityObject.getAvailableDate().equals(facility.getAvailableDate());
            boolean isSameTime = facilityObject.getAvailableTime().equals(facility.getAvailableTime());

            if (isSameDate && isSameTime) {
                flag = true;
            }
        }
        return flag;
    }
}
