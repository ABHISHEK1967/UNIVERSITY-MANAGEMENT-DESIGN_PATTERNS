package edu.dalhousie.business.registration.database;

import edu.dalhousie.business.registration.constants.RegistrationConstants;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetUser implements IGetUSer {
    private static IDatabaseConnection IDatabaseConnection;

    @Override
    public int getUserDetailByUsername(String username) {
        int userId = -1;
        String query = RegistrationConstants.GET_USER_QUERY
            .replace("tableName", Constants.USERS_TABLE)
            .replace("userName", username);

        try {
            IDatabaseConnection = DatabaseConnectivity.getInstance();
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                userId = resultSet.getInt("id");
            }
        } catch (Exception exception) {
            ILogger logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
            logger.error(GetUser.class.toString(), exception.getMessage());
            exception.printStackTrace();
        }
        return userId;
    }
}
