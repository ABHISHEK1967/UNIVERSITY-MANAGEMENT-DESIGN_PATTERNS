package edu.dalhousie.business.feedback.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SentimentAnalysisFeedbackModelTest {

    private static SentimentAnalysisFeedbackModel sentimentAnalysisFeedbackModel;

    @BeforeAll
    public static void setup() {
        List<String> positiveWords = new ArrayList<>();
        List<String> negativeWords = new ArrayList<>();
        positiveWords.add("good");
        positiveWords.add("perfect");
        positiveWords.add("best");
        negativeWords.add("poor");
        negativeWords.add("horrible");
        sentimentAnalysisFeedbackModel = new SentimentAnalysisFeedbackModel("Positive", negativeWords, positiveWords);
    }

    @Test
    public void testPolarity() {
        assertEquals("Positive", sentimentAnalysisFeedbackModel.getPolarity());
    }

    @Test
    public void testPositiveWords() {
        assertEquals("good", sentimentAnalysisFeedbackModel.getPositiveWords().get(0));
    }

    @Test
    public void testNegativeWords() {
        assertEquals("poor", sentimentAnalysisFeedbackModel.getNegativeWords().get(0));
    }
}