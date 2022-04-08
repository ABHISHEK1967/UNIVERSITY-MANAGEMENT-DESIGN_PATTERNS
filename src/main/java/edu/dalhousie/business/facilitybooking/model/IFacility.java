package edu.dalhousie.business.facilitybooking.model;

public interface IFacility {
    int getFacilityId();

    void setFacilityId(int facilityId);

    String getFacilityName();

    void setFacilityName(String facilityName);

    String getAvailableDate();

    void setAvailableDate(String availableDate);

    String getAvailableTime();

    void setAvailableTime(String availableTime);

    int getAvailableSlots();

    void setAvailableSlots(int availableSlots);
}
