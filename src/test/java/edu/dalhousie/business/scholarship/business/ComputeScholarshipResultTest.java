package edu.dalhousie.business.scholarship.business;

import edu.dalhousie.business.scholarship.constants.StringConstants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputeScholarshipResultTest {

    @Test
    public void testSuccessfulScholarship() {
        ComputeScholarshipResult computeScholarshipResult = new ComputeScholarshipResult();
        String result = computeScholarshipResult.computeResult(401);
        assertEquals(result, StringConstants.kEligibleForScholarship);
    }

    @Test
    public void testDeniedScholarship() {
        ComputeScholarshipResult computeScholarshipResult = new ComputeScholarshipResult();
        String result = computeScholarshipResult.computeResult(399);
        assertEquals(result, StringConstants.kNotEligibleForScholarship);
    }

}