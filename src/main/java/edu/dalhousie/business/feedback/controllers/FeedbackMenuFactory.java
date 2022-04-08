package edu.dalhousie.business.feedback.controllers;

import edu.dalhousie.business.addnewapplication.constants.StringConstants;

public class FeedbackMenuFactory {

    public static IFeedbackMenu getFeedbackMenu(String feedbackMenu) {

        IFeedbackMenu feedback = null;

        if(feedbackMenu == null) {
            return null;
        } else if (feedbackMenu == StringConstants.kFeedbackMenu) {
            feedback = new FeedbackMenu();
        }

        return feedback;

    }
}
