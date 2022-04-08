package edu.dalhousie.business.feedback.controllers;

import edu.dalhousie.business.feedback.database.FeedbackData;
import edu.dalhousie.business.feedback.constants.StringConstants;
import edu.dalhousie.business.feedback.database.IFeedbackData;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisplayFeedback implements IDisplayFeedback {

    List<String> feedback;
    IFeedbackData feedbackData;
    ICommonPrinting view;

    public DisplayFeedback() {
        feedback = new ArrayList<>();
        feedbackData = new FeedbackData();
        view = CommonPrinting.getInstance();
    }

    public void displayFeedback() throws SQLException {
        view.showMessage(StringConstants.kEnterCourseIDForFeedbackRetrieval);
        String courseID = view.getString();
        feedback = feedbackData.retrieveData(courseID);
    }
}
