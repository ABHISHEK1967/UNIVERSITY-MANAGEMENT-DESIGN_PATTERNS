package edu.dalhousie.business.addnewapplication.business;

public abstract class ComputeScoreForNewApplicationTemplate {

    public final String calculateScore() {
        computeUniversityScore();
        computeEducationScore();
        computeGPAScore();
        computeTenthScore();
        computeTwelfthScore();
        computeIELTSScore();
        computeGREScore();
        computeResearchPapersScore();
        computeWorkExperienceScore();
        computeGMATScore();
        computeGATEScore();
        String result = checkEligibility();
        return result;
    }

    abstract void computeUniversityScore();
    abstract void computeEducationScore();
    abstract void computeGPAScore();
    abstract void computeTenthScore();
    abstract void computeTwelfthScore();
    abstract void computeIELTSScore();
    abstract void computeGREScore();
    abstract void computeResearchPapersScore();
    abstract void computeWorkExperienceScore();
    abstract void computeGMATScore();
    abstract void computeGATEScore();
    abstract String checkEligibility();

}
