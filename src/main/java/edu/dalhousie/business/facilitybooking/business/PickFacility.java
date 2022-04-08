package edu.dalhousie.business.facilitybooking.business;

import edu.dalhousie.business.facilitybooking.controller.FacilityBookingFactory;
import edu.dalhousie.business.facilitybooking.model.Facility;
import edu.dalhousie.business.facilitybooking.model.IAvailableFacilitySlots;

import java.util.List;

public class PickFacility implements IPickFacility {
    @Override
    public Facility getFacilityById(int facilityId) {
        Facility facility = null;
        IAvailableFacilitySlots facilitySlots = FacilityBookingFactory.getInstance().getAvailableFacilitySlots();
        List<Facility> availableFacilitySlots = facilitySlots.getFacilitySlots();
        for (Facility facilityObject : availableFacilitySlots) {
            if (facilityObject.getFacilityId() == facilityId) {
                facility = facilityObject;
            }
        }
        return facility;
    }
}
