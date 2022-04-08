package edu.dalhousie.business.feedback.model;

import java.util.ArrayList;
import java.util.List;

public class SentimentAnalysisFeedbackModel {
    String polarity;
    List<String> negativeWords;
    List<String> positiveWords;

    public SentimentAnalysisFeedbackModel() {
        negativeWords = new ArrayList<>();
        positiveWords = new ArrayList<>();
    }

    public SentimentAnalysisFeedbackModel(String polarity, List<String> negativeWords, List<String> positiveWords) {
        this.polarity = polarity;
        this.negativeWords = negativeWords;
        this.positiveWords = positiveWords;
    }

    public String getPolarity() {
        return polarity;
    }

    public void setPolarity(String polarity) {
        this.polarity = polarity;
    }

    public List<String> getNegativeWords() {
        return negativeWords;
    }

    public void setNegativeWords(List<String> negativeWords) {
        this.negativeWords = negativeWords;
    }

    public List<String> getPositiveWords() {
        return positiveWords;
    }

    public void setPositiveWords(List<String> positiveWords) {
        this.positiveWords = positiveWords;
    }
}
