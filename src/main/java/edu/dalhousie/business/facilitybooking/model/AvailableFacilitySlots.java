package edu.dalhousie.business.facilitybooking.model;

import java.util.List;

public class AvailableFacilitySlots implements IAvailableFacilitySlots {
    private static List<Facility> facilitySlots;

    public List<Facility> getFacilitySlots() {
        return facilitySlots;
    }

    public void setFacilitySlots(List<Facility> facilitySlots) {
        AvailableFacilitySlots.facilitySlots = facilitySlots;
    }
}
