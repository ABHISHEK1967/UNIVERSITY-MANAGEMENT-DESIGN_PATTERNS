package edu.dalhousie.business.feedback.controllers;

import edu.dalhousie.business.feedback.business.SentimentalAnalysisForFeedback;
import edu.dalhousie.business.feedback.business.ISentimentalAnalysisForFeedback;
import edu.dalhousie.business.feedback.database.FeedbackData;
import edu.dalhousie.business.feedback.database.IFeedbackData;
import edu.dalhousie.business.feedback.model.SentimentAnalysisFeedbackModel;
import edu.dalhousie.business.feedback.constants.StringConstants;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class SentimentalAnalysisOfFeedback implements ISentimentalAnalysisOfFeedback{

    ICommonPrinting studentView;
    IFeedbackData feedbackData;
    ISentimentalAnalysisForFeedback sentimentalAnalysisForFeedback;

    String courseID;

    public SentimentalAnalysisOfFeedback() throws SQLException, IOException {
        studentView = CommonPrinting.getInstance();
        feedbackData = new FeedbackData();
        sentimentalAnalysisForFeedback = new SentimentalAnalysisForFeedback();
        inputCourseID();
    }

    public void inputCourseID () throws SQLException, IOException {
        studentView.showMessage(StringConstants.kEnterCourseIDForSentimentalAnalysisOfFeedback);
        courseID = studentView.getString();
        displaySentimentalAnalysisOfFeedback(courseID);
    }

    public void displaySentimentalAnalysisOfFeedback(String courseID) throws SQLException, IOException {
        List<String> feedbacks = feedbackData.retrieveData(courseID);
        SentimentAnalysisFeedbackModel sentimentAnalysisFeedback = sentimentalAnalysisForFeedback.computeSentimentalAnalysis(feedbacks);
        studentView.showMessage(StringConstants.kPolarity + sentimentAnalysisFeedback.getPolarity());
        studentView.showMessage(StringConstants.kPositiveWords + sentimentAnalysisFeedback.getPositiveWords().toString());
        studentView.showMessage(StringConstants.kNegativeWords + sentimentAnalysisFeedback.getNegativeWords().toString());
    }

}