package edu.dalhousie.business.facilitybooking.model;

import java.util.List;

public interface IAvailableFacilitySlots {
    List<Facility> getFacilitySlots();

    void setFacilitySlots(List<Facility> facilitySlots);
}
