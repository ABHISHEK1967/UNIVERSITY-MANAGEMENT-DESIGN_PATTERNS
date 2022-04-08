package edu.dalhousie.business.facilitybooking.databse;

import edu.dalhousie.business.facilitybooking.constants.FacilityBookingConstants;
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

public class GetAllUsers implements IGetAllUsers {
    private static IDatabaseConnection IDatabaseConnection;

    @Override
    public List<String> getAllUsers() {
        List<String> usernames = new ArrayList<>();
        IDatabaseConnection = DatabaseConnectivity.getInstance();
        String query = FacilityBookingConstants.SELECT_ALL_USERS_QUERY.replace("tableName", Constants.USERS_TABLE);
        try {
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                usernames.add(resultSet.getString(FacilityBookingConstants.USER_NAME));
            }
        } catch (Exception exception) {
            ILogger logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
            logger.error(GetAllUsers.class.toString(), exception.getMessage());
            exception.printStackTrace();
        }
        return usernames;
    }
}
