package edu.dalhousie.business.scholarship.business;

import edu.dalhousie.business.scholarship.constants.StringConstants;

public class ComputeScholarshipResult {

    private final int eligibilityScore = 400;

    public String computeResult(float score) {
        String decision = "";

        if (score >= eligibilityScore) {
            decision = StringConstants.kEligibleForScholarship;
        } else {
            decision = StringConstants.kNotEligibleForScholarship;
        }

        return decision;
    }

}