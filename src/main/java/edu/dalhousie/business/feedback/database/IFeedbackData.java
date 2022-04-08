package edu.dalhousie.business.feedback.database;

import edu.dalhousie.business.feedback.model.FeedbackObjectModel;

import java.sql.SQLException;
import java.util.List;

public interface IFeedbackData {
    public void storeData(FeedbackObjectModel feedbackObjectModel) throws SQLException;
    public List<String> retrieveData(String courseID) throws SQLException;
}
