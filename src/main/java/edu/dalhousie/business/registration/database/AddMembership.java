package edu.dalhousie.business.registration.database;

import edu.dalhousie.business.registration.constants.RegistrationConstants;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.Statement;

public class AddMembership implements IAddMembership {
    private static edu.dalhousie.database.IDatabaseConnection IDatabaseConnection;

    @Override
    public int addMembershipDetails(int userID) {
        int result = -1;
        String query = RegistrationConstants.ADD_MEMBERSHIP_QUERY
            .replace("tableName", Constants.MEMBERSHIPS_TABLE)
            .replace("userId", userID + "");

        try {
            IDatabaseConnection = DatabaseConnectivity.getInstance();
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            result = statement.executeUpdate(query);
        } catch (Exception exception) {
            ILogger logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
            logger.error(AddMembership.class.toString(), exception.getMessage());
            exception.printStackTrace();
        }
        return result;
    }
}
