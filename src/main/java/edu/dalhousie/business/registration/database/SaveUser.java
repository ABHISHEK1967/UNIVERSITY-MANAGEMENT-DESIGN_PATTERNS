package edu.dalhousie.business.registration.database;

import edu.dalhousie.business.registration.constants.RegistrationConstants;
import edu.dalhousie.business.registration.controller.RegistrationFactory;
import edu.dalhousie.business.registration.model.IUser;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;
import edu.dalhousie.utilities.Constants;

import java.sql.Connection;
import java.sql.Statement;

public class SaveUser implements ISaveUser {
    private static IDatabaseConnection IDatabaseConnection;

    public int saveUserDetails() {
        int result = -1;
        IUser user = RegistrationFactory.getInstance().getUser();

        String query = RegistrationConstants.INSERT_USER_QUERY
            .replace("tableName", Constants.USERS_TABLE)
            .replace("firstName", user.getFirstName())
            .replace("lastName", user.getLastName())
            .replace("emailAddress", user.getEmail())
            .replace("contactNumber", user.getContactNumber())
            .replace("passwordValue", user.getPassword())
            .replace("dateOfBirth", user.getDateOfBirth())
            .replace("genderValue", user.getGender())
            .replace("addressValue", user.getStreetAddress())
            .replace("apartmentNumber", user.getApartmentNumber())
            .replace("cityValue", user.getCity())
            .replace("provinceValue", user.getProvince())
            .replace("zipCode", user.getZipcode())
            .replace("username", user.getUsername())
            .replace("typeOfUser", user.getTypeOfUser());

        try {
            IDatabaseConnection = DatabaseConnectivity.getInstance();
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            result = statement.executeUpdate(query);
        } catch (Exception exception) {
            ILogger logger = LoggerAbstractFactory.getFactory().newLoggerInstance();
            logger.error(SaveUser.class.toString(), exception.getMessage());
            exception.printStackTrace();
        }
        return result;
    }
}
