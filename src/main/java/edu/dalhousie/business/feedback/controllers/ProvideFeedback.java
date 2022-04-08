package edu.dalhousie.business.feedback.controllers;

import edu.dalhousie.business.feedback.database.FeedbackData;
import edu.dalhousie.business.feedback.database.IFeedbackData;
import edu.dalhousie.business.feedback.model.FeedbackObjectModel;
import edu.dalhousie.business.feedback.constants.StringConstants;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.sql.SQLException;

public class ProvideFeedback implements IProvideFeedback{

    ICommonPrinting view;
    FeedbackObjectModel feedbackObjectModel;
    IFeedbackData feedbackData;

    public ProvideFeedback() {
        view = CommonPrinting.getInstance();
        feedbackObjectModel = new FeedbackObjectModel();
        feedbackData = new FeedbackData();
    }

    public void displayProvideFeedbackMenu() throws SQLException {
        view.showMessage(StringConstants.kEnterCourseId);
        feedbackObjectModel.setCourseID(view.getString());

        view.showMessage(StringConstants.kProvideYourFeedback);
        feedbackObjectModel.setFeedback(view.getString());

        view.showMessage(StringConstants.kRateYourProfessor);
        feedbackObjectModel.setProfessorRating(view.getInt());

        view.showMessage(StringConstants.kLevelOfDifficulty);
        feedbackObjectModel.setDifficultyLevel(view.getInt());

        view.showMessage(StringConstants.kRecommendThisCourse);
        feedbackObjectModel.setRecommendation(view.getInt());

        view.showMessage(StringConstants.kDevelopProfessionally);
        feedbackObjectModel.setProfessionalDevelopment(view.getInt());

        view.showMessage(StringConstants.kMeetYourNeeds);
        feedbackObjectModel.setNeedsMet(view.getInt());

        feedbackData.storeData(feedbackObjectModel);

        view.showMessage(StringConstants.kThankYouForFeedback);
    }

}
