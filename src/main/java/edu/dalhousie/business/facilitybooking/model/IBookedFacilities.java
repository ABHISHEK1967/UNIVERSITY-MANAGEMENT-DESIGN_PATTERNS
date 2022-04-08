package edu.dalhousie.business.facilitybooking.model;

import java.util.List;

public interface IBookedFacilities {
    List<Facility> getBookedFacilities();

    void setBookedFacilities(List<Facility> bookedFacilities);
}
