package edu.dalhousie.business.viewprofile.database;

import edu.dalhousie.business.viewprofile.model.IViewProfileModel;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.business.viewprofile.controller.ViewProfileFactory;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ViewProfileConnection implements IViewProfileConnection {
    private IDatabaseConnection IDatabaseConnection;
    UserSession userSession;

    public ViewProfileConnection() {
        this.IDatabaseConnection = DatabaseConnectivity.getInstance();
        userSession = UserSession.getInstance();
    }

    public void executeViewTable() {
        ICommonPrinting view = CommonPrinting.getInstance();
        IViewProfileModel viewProfileModel = ViewProfileFactory.initialize().getViewProfileModel();
        viewProfileModel.setUserID(userSession.getUser().getUserName());

        try {
            final Connection connection =
                    IDatabaseConnection.getDatabaseConnection();
            final Statement statement =
                    connection.createStatement();
            String SQL_View = String.format("SELECT * FROM users WHERE user_name = '%s'", viewProfileModel.getUserID());
            ResultSet rs_view = statement.executeQuery(SQL_View);

            while (rs_view.next()) {
                viewProfileModel.setUsername(rs_view.getString("user_name"));
                viewProfileModel.setFirstName(rs_view.getString("first_name"));
                viewProfileModel.setLastName(rs_view.getString("last_name"));
                viewProfileModel.setEmail(rs_view.getString("email_address"));
                viewProfileModel.setContactNumber(rs_view.getString("contact_number"));
                viewProfileModel.setDateOfBirth(rs_view.getString("dob"));
                viewProfileModel.setGender(rs_view.getString("gender"));
                viewProfileModel.setStreetAddress(rs_view.getString("address"));
                viewProfileModel.setApartmentNumber(rs_view.getString("apartment_number"));
                viewProfileModel.setCity(rs_view.getString("city"));
                viewProfileModel.setProvince(rs_view.getString("province"));
                viewProfileModel.setZipcode(rs_view.getString("zip_code"));
            }

            view.showMessage("Username:\t\t\t" + viewProfileModel.getUsername());
            view.showMessage("First name:\t\t\t" + viewProfileModel.getFirstName());
            view.showMessage("Last name:\t\t\t" + viewProfileModel.getLastName());
            view.showMessage("Email address:\t\t" + viewProfileModel.getEmail());
            view.showMessage("Contact number:\t\t" + viewProfileModel.getContactNumber());
            view.showMessage("Date of Birth:\t\t" + viewProfileModel.getDateOfBirth());
            view.showMessage("Gender:\t\t\t\t" + viewProfileModel.getGender());
            view.showMessage("Address:\t\t\t" + viewProfileModel.getStreetAddress());
            view.showMessage("Apartment number:\t" + viewProfileModel.getApartmentNumber());
            view.showMessage("City:\t\t\t\t" + viewProfileModel.getCity());
            view.showMessage("Province:\t\t\t" + viewProfileModel.getProvince());
            view.showMessage("Zip code:\t\t\t" + viewProfileModel.getZipcode());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
