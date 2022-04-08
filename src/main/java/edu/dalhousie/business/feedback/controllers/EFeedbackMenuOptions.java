package edu.dalhousie.business.feedback.controllers;

import edu.dalhousie.business.feedback.constants.StringConstants;

import java.io.IOException;
import java.sql.SQLException;

public enum EFeedbackMenuOptions {
    N1(1) {
        @Override
        public void displayFeedback() throws SQLException {
            IProvideFeedback provideFeedback = ProvideFeedbackFactory.getProvideFeedback(StringConstants.kProvideFeedbac);
            provideFeedback.displayProvideFeedbackMenu();
        }

    }, N2(2) {
        @Override
        public void displayFeedback() throws SQLException {
            IDisplayFeedback displayFeedback = DisplayFeedbackFactory.getDisplayFeedback(StringConstants.kDisplayFeedback);
            displayFeedback.displayFeedback();
        }

    }, N3(3) {
        @Override
        public void displayFeedback() throws SQLException, IOException {
            new SentimentalAnalysisOfFeedback();
        }
    };


    public abstract void displayFeedback() throws SQLException, IOException;

    private int value;

    EFeedbackMenuOptions(int value) {
        this.value = value;
    }

    public String toString() {
        return Integer.toString(value);
    }
}
