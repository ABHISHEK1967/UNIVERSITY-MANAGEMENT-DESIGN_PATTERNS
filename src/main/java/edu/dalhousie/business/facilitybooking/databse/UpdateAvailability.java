package edu.dalhousie.business.facilitybooking.databse;

import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.Statement;

public class UpdateAvailability implements IUpdateAvailability {
    private static IDatabaseConnection IDatabaseConnection;

    @Override
    public void updateSlotsAvailability(int facilityId, int availableSlots) {
        String query = FacilityBookingConstants.UPDATE_FACILITY_SLOTS_QUERY
            .replace("tableName", Constants.FACILITIES_TABLE)
            .replace("availableSlots", availableSlots + "")
            .replace("facilityId", facilityId + "");

        try {
            IDatabaseConnection = DatabaseConnectivity.getInstance();
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception exception) {
            ILogger logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
            logger.error(UpdateAvailability.class.toString(), exception.getMessage());
            exception.printStackTrace();
        }
    }
}
