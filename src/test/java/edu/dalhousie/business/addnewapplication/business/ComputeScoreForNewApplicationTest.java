package edu.dalhousie.business.addnewapplication.business;


import edu.dalhousie.business.addnewapplication.model.AddNewApplicationFormObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputeScoreForNewApplicationTest {

    @Test
    public void testComputeUniversityScore() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        addNewApplicationFormObject.setUniversity("iit");
        ComputeScoreForNewApplication computeScoreForNewApplication = new ComputeScoreForNewApplication(addNewApplicationFormObject);
        computeScoreForNewApplication.computeUniversityScore();
        assertEquals(50, computeScoreForNewApplication.score);
    }

    @Test
    public void testComputeEducationScore() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        addNewApplicationFormObject.setEducation("1");
        ComputeScoreForNewApplication computeScoreForNewApplication = new ComputeScoreForNewApplication(addNewApplicationFormObject);
        computeScoreForNewApplication.computeEducationScore();
        assertEquals(25, computeScoreForNewApplication.score);
    }

    @Test
    public void testComputeGPAScore() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        addNewApplicationFormObject.setGpa("8.55");
        ComputeScoreForNewApplication computeScoreForNewApplication = new ComputeScoreForNewApplication(addNewApplicationFormObject);
        computeScoreForNewApplication.computeGPAScore();
        assertEquals(35, computeScoreForNewApplication.score);
    }

    @Test
    public void testComputeTenthScore() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        addNewApplicationFormObject.setTenthMarks("97");
        ComputeScoreForNewApplication computeScoreForNewApplication = new ComputeScoreForNewApplication(addNewApplicationFormObject);
        computeScoreForNewApplication.computeTenthScore();
        assertEquals(50, computeScoreForNewApplication.score);
    }

    @Test
    public void testComputeTwelfthScore() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        addNewApplicationFormObject.setTwelfthMarks("30");
        ComputeScoreForNewApplication computeScoreForNewApplication = new ComputeScoreForNewApplication(addNewApplicationFormObject);
        computeScoreForNewApplication.computeTwelfthScore();
        assertEquals(false, computeScoreForNewApplication.isPass);
    }

    @Test
    public void testComputeIELTSScore() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        addNewApplicationFormObject.setIELTS("7.5");
        ComputeScoreForNewApplication computeScoreForNewApplication = new ComputeScoreForNewApplication(addNewApplicationFormObject);
        computeScoreForNewApplication.computeIELTSScore();
        assertEquals(40, computeScoreForNewApplication.score);
    }

    @Test
    public void testComputeGREScore() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        addNewApplicationFormObject.setGRE("291");
        ComputeScoreForNewApplication computeScoreForNewApplication = new ComputeScoreForNewApplication(addNewApplicationFormObject);
        computeScoreForNewApplication.computeGREScore();
        assertEquals(30, computeScoreForNewApplication.score);
    }

    @Test
    public void testComputeResearchPaperScore() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        addNewApplicationFormObject.setResearchPapers("4");
        ComputeScoreForNewApplication computeScoreForNewApplication = new ComputeScoreForNewApplication(addNewApplicationFormObject);
        computeScoreForNewApplication.computeResearchPapersScore();
        assertEquals(50, computeScoreForNewApplication.score);
    }

    @Test
    public void testComputeWorkExperienceScore() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        addNewApplicationFormObject.setWorkExp("1");
        ComputeScoreForNewApplication computeScoreForNewApplication = new ComputeScoreForNewApplication(addNewApplicationFormObject);
        computeScoreForNewApplication.computeWorkExperienceScore();
        assertEquals(30, computeScoreForNewApplication.score);
    }

    @Test
    public void testComputeGMATScore() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        addNewApplicationFormObject.setGMAT("700");
        ComputeScoreForNewApplication computeScoreForNewApplication = new ComputeScoreForNewApplication(addNewApplicationFormObject);
        computeScoreForNewApplication.computeGMATScore();
        assertEquals(50, computeScoreForNewApplication.score);
    }

    @Test
    public void testComputeGATEScore() {
        AddNewApplicationFormObject addNewApplicationFormObject = new AddNewApplicationFormObject();
        addNewApplicationFormObject.setGATE("90");
        ComputeScoreForNewApplication computeScoreForNewApplication = new ComputeScoreForNewApplication(addNewApplicationFormObject);
        computeScoreForNewApplication.computeGATEScore();
        assertEquals(50, computeScoreForNewApplication.score);
    }


}