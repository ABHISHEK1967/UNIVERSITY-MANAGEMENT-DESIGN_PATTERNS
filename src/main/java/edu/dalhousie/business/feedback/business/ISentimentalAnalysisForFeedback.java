package edu.dalhousie.business.feedback.business;

import edu.dalhousie.business.feedback.model.SentimentAnalysisFeedbackModel;

import java.io.IOException;
import java.util.List;

public interface ISentimentalAnalysisForFeedback {
    public SentimentAnalysisFeedbackModel
    computeSentimentalAnalysis(List<String> feedbacks) throws IOException;
}
