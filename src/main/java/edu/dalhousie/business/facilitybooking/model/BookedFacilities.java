package edu.dalhousie.business.facilitybooking.model;

import java.util.List;

public class BookedFacilities implements IBookedFacilities{
    private static List<Facility> bookedFacilities;

    public List<Facility> getBookedFacilities() {
        return bookedFacilities;
    }

    public void setBookedFacilities(List<Facility> bookedFacilities) {
        BookedFacilities.bookedFacilities = bookedFacilities;
    }
}
