package edu.dalhousie.business.scholarship.database;

import edu.dalhousie.business.scholarship.constants.StringConstants;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScholarshipData {

    String userID;
    String courseName;
    private static IDatabaseConnection IDatabaseConnection;

    public ScholarshipData(String userID, String courseName) throws SQLException {
        this.userID = userID;
        this.courseName = courseName;
        IDatabaseConnection = DatabaseConnectivity.getInstance();
    }

    public String getData() throws SQLException {
        String score = "";
        String query = "select applicationscore from new_application_score where userName = '" + userID + "' ";
        try {
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                score = rs.getString(StringConstants.kApplicationScoreColumn);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return score;
    }

}
