package edu.dalhousie.business.facilitybooking.business;

import edu.dalhousie.business.facilitybooking.model.Facility;

public interface IValidateFacilityBooking {
    boolean isValidUsername(String username);

    boolean isInvalidFacilityChoice(String facilityChoice);

    boolean isInvalidFacilityId(String facilityIdChoice);

    boolean hasConflictWithBooking(Facility facility);
}
