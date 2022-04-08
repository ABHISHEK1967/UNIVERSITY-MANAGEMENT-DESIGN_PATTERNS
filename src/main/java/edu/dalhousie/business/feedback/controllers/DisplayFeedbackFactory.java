package edu.dalhousie.business.feedback.controllers;

import edu.dalhousie.business.feedback.constants.StringConstants;

public class DisplayFeedbackFactory {

    public static IDisplayFeedback getDisplayFeedback(String displayFeedback) {

        IDisplayFeedback feedback = null;

        if(displayFeedback == null) {
            return null;
        } else if(displayFeedback == StringConstants.kDisplayFeedback) {
            feedback = new DisplayFeedback();
        }

        return feedback;

    }

}
