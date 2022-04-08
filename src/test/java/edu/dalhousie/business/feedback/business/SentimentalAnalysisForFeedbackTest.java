package edu.dalhousie.business.feedback.business;

import edu.dalhousie.business.feedback.model.SentimentAnalysisFeedbackModel;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SentimentalAnalysisForFeedbackTest {

    @Test
    public void testPositiveSentiment() throws IOException {
        SentimentalAnalysisForFeedback sentimentalAnalysisForFeedback = new SentimentalAnalysisForFeedback();

        List<String> feedbacks = new ArrayList<>();
        feedbacks.add("exceptional course");
        feedbacks.add("easy course");
        feedbacks.add("great lectures");
        feedbacks.add("poor teaching");

        SentimentAnalysisFeedbackModel feedbackModel = sentimentalAnalysisForFeedback.computeSentimentalAnalysis(feedbacks);
        assertEquals("Positive", feedbackModel.getPolarity());
    }

    @Test
    public void testNegativeSentiment() throws IOException {
        SentimentalAnalysisForFeedback sentimentalAnalysisForFeedback = new SentimentalAnalysisForFeedback();

        List<String> feedbacks = new ArrayList<>();
        feedbacks.add("bad course");
        feedbacks.add("horrible");
        feedbacks.add("great lectures");
        feedbacks.add("poor teaching");

        SentimentAnalysisFeedbackModel feedbackModel = sentimentalAnalysisForFeedback.computeSentimentalAnalysis(feedbacks);
        assertEquals("Negative", feedbackModel.getPolarity());
    }

}