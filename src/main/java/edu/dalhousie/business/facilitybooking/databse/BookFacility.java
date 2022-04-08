package edu.dalhousie.business.facilitybooking.databse;

import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.business.facilitybooking.controller.FacilityBooking;
import edu.dalhousie.business.facilitybooking.controller.FacilityBookingFactory;
import edu.dalhousie.business.facilitybooking.model.Facility;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.Statement;

public class BookFacility implements IBookFacility {
    private static IDatabaseConnection IDatabaseConnection;

    @Override
    public int bookFacility(Facility facility) {
        IUpdateAvailability updateAvailability = FacilityBookingFactory.getInstance().getUpdateAvailability();
        int result = -1;
        String query = FacilityBookingConstants.BOOK_FACILITY_QUERY
            .replace("tableName", Constants.FACILITIES_BOOKINGS)
            .replace("username", FacilityBooking.userName)
            .replace("facilityName", facility.getFacilityName())
            .replace("facilityDate", facility.getAvailableDate())
            .replace("facilityTime", facility.getAvailableTime());

        try {
            IDatabaseConnection = DatabaseConnectivity.getInstance();
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            result = statement.executeUpdate(query);
            if (result == 1) {
                updateAvailability.updateSlotsAvailability(facility.getFacilityId(), facility.getAvailableSlots() - 1);
            }
        } catch (Exception exception) {
            ILogger logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
            logger.error(BookFacility.class.toString(), exception.getMessage());
            exception.printStackTrace();
        }
        return result;
    }
}
