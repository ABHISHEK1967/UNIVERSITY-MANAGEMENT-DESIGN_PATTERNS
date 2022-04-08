package edu.dalhousie.business.facilitybooking.business;

import edu.dalhousie.business.facilitybooking.model.Facility;

public interface IPickFacility {
    Facility getFacilityById(int facilityId);
}
