package edu.dalhousie.business.feedback.database;

import edu.dalhousie.business.feedback.model.FeedbackObjectModel;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FeedbackData implements IFeedbackData {

    private static IDatabaseConnection IDatabaseConnection;
    UserSession userSession;

    public FeedbackData() {
        IDatabaseConnection = DatabaseConnectivity.getInstance();
        userSession = UserSession.getInstance();
    }


    public void storeData(FeedbackObjectModel feedbackObjectModel) throws SQLException {
        String courseID = feedbackObjectModel.getCourseID();
        String feedback = feedbackObjectModel.getFeedback();
        int professorRating = feedbackObjectModel.getProfessorRating();
        int difficultyLevel = feedbackObjectModel.getDifficultyLevel();
        int recommendation = feedbackObjectModel.getRecommendation();
        int professionalDevelopment = feedbackObjectModel.getProfessionalDevelopment();
        int needsMet = feedbackObjectModel.getNeedsMet();

        String query = "insert into feedback " +  "values ('"+  userSession.getUser().getUserName() +"', '" + courseID+ "','" + feedback+ "','" + professorRating + "', '" + difficultyLevel + "', '" + recommendation + "', '" + professionalDevelopment + "', '" + needsMet + "')";

        try {
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
    }


    public List<String> retrieveData(String courseID) throws SQLException {
        List<String> feedbackList = new ArrayList<>();

        String feedback = "";
        String query = "select feedback from feedback where courseID = '" + courseID + "' ";
        try {
            final Connection connection = IDatabaseConnection.getDatabaseConnection();
            final Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                feedback = rs.getString("feedback");
                System.out.println(feedback);
                feedbackList.add(feedback);
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return feedbackList;
    }

}
