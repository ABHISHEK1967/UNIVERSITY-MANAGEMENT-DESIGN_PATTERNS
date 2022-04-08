package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.business.PickFacility;
import edu.dalhousie.business.facilitybooking.business.IPickFacility;
import edu.dalhousie.business.facilitybooking.business.IValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.business.ValidateFacilityBooking;
import edu.dalhousie.business.facilitybooking.databse.*;
import edu.dalhousie.business.facilitybooking.model.*;
import edu.dalhousie.business.facilitybooking.model.BookedFacilities;
import edu.dalhousie.business.facilitybooking.model.IBookedFacilities;

public class FacilityBookingFactory {
    private static FacilityBookingFactory facilityBookingFactory = null;

    IFacilityBooking facilityBooking;
    IValidateFacilityBooking validateFacilityBooking;
    IGetAllUsers getAllUsers;
    IGetFacilityAvailability getFacilityAvailability;
    IFacility facility;
    IAvailableFacilitySlots availableFacilitySlots;
    IBookedFacilities bookedFacilities;
    IShowFacilityAvailability showFacilityAvailability;
    IBookFacilityForm bookFacilityForm;
    IBookValidFacility bookValidFacility;
    IPickFacility pickFacility;
    IBookFacility bookFacility;
    IUsersBookedFacilities usersBookedFacilities;
    IUpdateAvailability updateAvailability;

    public FacilityBookingFactory() {
        facilityBooking = new FacilityBooking();
        validateFacilityBooking = new ValidateFacilityBooking();
        getAllUsers = new GetAllUsers();
        getFacilityAvailability = new GetFacilityAvailability();
        facility = new Facility();
        availableFacilitySlots = new AvailableFacilitySlots();
        bookedFacilities = new BookedFacilities();
        showFacilityAvailability = new ShowFacilityAvailability();
        bookFacilityForm = new BookFacilityForm();
        bookValidFacility = new BookValidFacility();
        pickFacility = new PickFacility();
        bookFacility = new BookFacility();
        usersBookedFacilities = new UsersBookedFacilities();
        updateAvailability = new UpdateAvailability();
    }

    public static FacilityBookingFactory getInstance() {
        if (facilityBookingFactory == null) {
            facilityBookingFactory = new FacilityBookingFactory();
        }
        return facilityBookingFactory;
    }

    public IFacilityBooking getFacilityBooking() {
        return facilityBooking;
    }

    public IValidateFacilityBooking getValidateFacilityBooking() {
        return validateFacilityBooking;
    }

    public IGetAllUsers getGetAllUsers() {
        return getAllUsers;
    }

    public IGetFacilityAvailability getGetFacilityAvailability() {
        return getFacilityAvailability;
    }

    public IFacility getFacility() {
        return facility;
    }

    public IAvailableFacilitySlots getAvailableFacilitySlots() {
        return availableFacilitySlots;
    }

    public IBookedFacilities getBookedFacilities() {
        return bookedFacilities;
    }

    public IShowFacilityAvailability getShowFacilityAvailability() {
        return showFacilityAvailability;
    }

    public IBookFacilityForm getBookFacilityForm() {
        return bookFacilityForm;
    }

    public IPickFacility getPickFacility() {
        return pickFacility;
    }

    public IBookValidFacility getBookValidFacility() {
        return bookValidFacility;
    }

    public IBookFacility getBookFacility() {
        return bookFacility;
    }

    public IUsersBookedFacilities getUsersBookedFacilities() {
        return usersBookedFacilities;
    }

    public IUpdateAvailability getUpdateAvailability() {
        return updateAvailability;
    }
}
