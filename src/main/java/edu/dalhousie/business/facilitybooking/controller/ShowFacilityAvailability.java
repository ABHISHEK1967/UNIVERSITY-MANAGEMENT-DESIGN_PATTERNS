package edu.dalhousie.business.facilitybooking.controller;

import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.business.facilitybooking.databse.IGetFacilityAvailability;
import edu.dalhousie.business.facilitybooking.model.Facility;
import edu.dalhousie.business.facilitybooking.model.IAvailableFacilitySlots;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;


public class ShowFacilityAvailability implements IShowFacilityAvailability {
    @Override
    public void renderFacilityAvailability(String facility) {
        ICommonPrinting view = CommonPrinting.getInstance();
        IGetFacilityAvailability facilityAvailability = FacilityBookingFactory.getInstance().getGetFacilityAvailability();
        IAvailableFacilitySlots facilitySlots = FacilityBookingFactory.getInstance().getAvailableFacilitySlots();

        facilityAvailability.getFacilityAvailability(facility);

        view.showFormattedMessage("\n%40s\n", FacilityBookingConstants.AVAILABILITY_FOR.concat(facility).toUpperCase());
        view.showFormattedMessage("%8s %10s %13s %16s %6s\n", "ID", "Date", "Time", "Availability", "Slots");
        int count = 0;
        for (Facility slot : facilitySlots.getFacilitySlots()) {
            String counter = ++count + "";
            String facilityId = slot.getFacilityId() + "";
            String availableDate = slot.getAvailableDate();
            String availableTime = slot.getAvailableTime();
            String availableOrNot = slot.getAvailableSlots() > 0 ? FacilityBookingConstants.AVAILABLE : FacilityBookingConstants.BOOKED;
            String availableSlots = slot.getAvailableSlots() + "";

            view.showFormattedMessage("%s. %4s | %12s | %9s | %12s | %4s\n", counter, facilityId, availableDate, availableTime, availableSlots, availableOrNot);
        }
    }
}
