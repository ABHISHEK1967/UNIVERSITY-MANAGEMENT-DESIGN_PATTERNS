package edu.dalhousie.business.addnewapplication.database;

import edu.dalhousie.business.addnewapplication.model.AddNewApplicationFormObject;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddNewApplicationForAdmissionData implements IAddNewApplicationForAdmissionData{

    private static IDatabaseConnection IDatabaseConnection;
    UserSession userSession;

    public AddNewApplicationForAdmissionData() throws SQLException {
        IDatabaseConnection = DatabaseConnectivity.getInstance();
        userSession = UserSession.getInstance();
    }

    public void storeData(AddNewApplicationFormObject newApplication) throws SQLException {
        String course = newApplication.getCourse();
        String university = newApplication.getUniversity();
        String education = newApplication.getEducation();
        String gpa = newApplication.getGpa();
        String tenthMarks = newApplication.getTenthMarks();
        String twelfthMarks = newApplication.getTwelfthMarks();
        String IELTS = newApplication.getIELTS();
        String GRE = newApplication.getGRE();
        String researchPapers = newApplication.getResearchPapers();
        String workExp = newApplication.getWorkExp();
        String GMAT = newApplication.getGMAT();
        String GATE = newApplication.getGATE();

        String query = "insert into new_application" + " values ('"+ userSession.getUser().getUserName() + "','" + course+ "', '" + university + "', '"+education+"','" + Float.parseFloat(gpa) + "', '" + Float.parseFloat(tenthMarks) + "','" + Float.parseFloat(twelfthMarks) + "','" + Float.parseFloat(IELTS) + "','" + Integer.parseInt(GRE) + "', '" + Integer.parseInt(researchPapers) + "', '" + Float.parseFloat(workExp) + "', '" + Integer.parseInt(GMAT) + "', '" + Integer.parseInt(GATE) + "')";

        try {
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

    public void storeScore(AddNewApplicationFormObject newApplicationFormObject) throws SQLException {
        String score = newApplicationFormObject.getResult();
        String query = "insert into new_application_score " + " values ('"+ userSession.getUser().getUserName() +"', '" + Float.parseFloat(score) + "')";

        try {
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }

}
