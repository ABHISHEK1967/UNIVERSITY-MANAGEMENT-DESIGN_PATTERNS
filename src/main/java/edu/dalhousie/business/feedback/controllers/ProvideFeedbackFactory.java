package edu.dalhousie.business.feedback.controllers;

import edu.dalhousie.business.feedback.constants.StringConstants;

public class ProvideFeedbackFactory {

    public static IProvideFeedback getProvideFeedback(String provideFeedback) {

        IProvideFeedback feedback = null;

        if(provideFeedback == null) {
            return null;
        } else if(provideFeedback == StringConstants.kProvideFeedbac) {
            feedback = new ProvideFeedback();
        }

        return feedback;
    }
}
