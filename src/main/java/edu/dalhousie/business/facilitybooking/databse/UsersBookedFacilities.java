package edu.dalhousie.business.facilitybooking.databse;

import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.business.facilitybooking.controller.FacilityBookingFactory;
import edu.dalhousie.business.facilitybooking.model.Facility;
import edu.dalhousie.business.facilitybooking.model.IBookedFacilities;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UsersBookedFacilities implements IUsersBookedFacilities {
    private static IDatabaseConnection IDatabaseConnection;

    @Override
    public void getBookedFacilitiesByUsername(String username) {
        IBookedFacilities bookedFacilities = FacilityBookingFactory.getInstance().getBookedFacilities();
        String query = FacilityBookingConstants.GET_BOOKED_FACILITIES_OF_USER
            .replace("tableName", Constants.FACILITIES_BOOKINGS)
            .replace("userName", username);

        try {
            IDatabaseConnection = DatabaseConnectivity.getInstance();
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            List<Facility> facilities = new ArrayList<>();
            while (resultSet.next()) {
                Facility facility = new Facility();
                facility.setFacilityName(resultSet.getString(FacilityBookingConstants.FACILITY_NAME_COLUMN));
                facility.setAvailableDate(resultSet.getString(FacilityBookingConstants.FACILITY_DATE));
                facility.setAvailableTime(resultSet.getString(FacilityBookingConstants.FACILITY_TIME));
                facilities.add(facility);
            }
            bookedFacilities.setBookedFacilities(facilities);
        } catch (Exception exception) {
            ILogger logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
            logger.error(UsersBookedFacilities.class.toString(), exception.getMessage());
            exception.printStackTrace();
        }
    }
}
