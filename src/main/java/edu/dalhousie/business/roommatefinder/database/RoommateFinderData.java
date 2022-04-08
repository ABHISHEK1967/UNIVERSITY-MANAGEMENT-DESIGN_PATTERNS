package edu.dalhousie.business.roommatefinder.database;
import edu.dalhousie.business.roommatefinder.model.RoommateFinderObjectModel;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoommateFinderData implements IRoommateFinderData {

    private static IDatabaseConnection IDatabaseConnection;
    UserSession userSession;

    public RoommateFinderData() {
        userSession = UserSession.getInstance();
    }

    public void storeData(RoommateFinderObjectModel roommateFinderObject) throws SQLException {
        IDatabaseConnection = DatabaseConnectivity.getInstance();
        String userName = "";
        int gender = roommateFinderObject.getGender();
        int foodPreference = roommateFinderObject.getFoodPreference();
        int genderPreference = roommateFinderObject.getGenderPreference();
        String hobbies = roommateFinderObject.getHobbies();
        int campus = roommateFinderObject.getCampusPreference();
        int accomodation = roommateFinderObject.getAccomodationPreference();

        String query = "insert into roommates " + " values ('"+ userSession.getUser().getUserName() +"', '" + gender+ "', '" + campus+ "', '" + accomodation+ "', '" +genderPreference+ "', '"+foodPreference+"', '"+hobbies+"')";

        try {
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    public List<String> retrieveData(RoommateFinderObjectModel roommateFinderObject) throws SQLException {
        List<String> matches = new ArrayList<>();

        String userName = "";
        String query = "";

        int gender = roommateFinderObject.getGender();
        int foodPreference = roommateFinderObject.getFoodPreference();
        int genderPreference = roommateFinderObject.getGenderPreference();
        String hobbies = roommateFinderObject.getHobbies();
        int campus = roommateFinderObject.getCampusPreference();
        int accomodation = roommateFinderObject.getAccomodationPreference();

        if (foodPreference == 3) {
            if (genderPreference == 3) {
                query = "select userName from roommates where genderpref > 0 && campus = '" + campus + "' && accomodationType = '" + accomodation + "' && gender > 0 && foodpref > 0 && hobbies LIKE '%" + hobbies + "%' ";
            }
            query = "select userName from roommates where genderpref = '" + gender + "' && campus = '" + campus + "' && accomodationType = '" + accomodation + "' && gender = '" + genderPreference + "' && foodpref > 0 && hobbies LIKE '%" + hobbies + "%' ";
        } else if(genderPreference == 3) {
            query = "select userName from roommates where genderpref > 0 && campus = '" + campus + "' && accomodationType = '" + accomodation + "' && gender>0 && foodpref = '" + foodPreference + "' && hobbies LIKE '%" + hobbies + "%' ";
        } else {
            query = "select userName from roommates where genderpref = '" + gender + "' && campus = '" + campus + "' && accomodationType = '" + accomodation + "' && gender = '" + genderPreference + "' && foodpref = '" + foodPreference + "' && hobbies LIKE '%" + hobbies + "%' ";
        }

        try {
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                matches.add(rs.getString("userName"));
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return matches;
    }
}
