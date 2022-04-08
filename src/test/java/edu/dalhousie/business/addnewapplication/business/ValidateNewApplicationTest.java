package edu.dalhousie.business.addnewapplication.business;

import edu.dalhousie.business.addnewapplication.model.AddNewApplicationFormValidation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateNewApplicationTest {

    @Test
    public void testVerifyValidCourseName() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyCourseName("macs");
        assertEquals(true, validation.getValid());
    }

    @Test
    public void testVerifyInvalidCourseName() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyCourseName("cs");
        assertEquals(false, validation.getValid());
    }

    @Test
    public void testVerifyPreviousSchoolName() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyPreviousSchoolName("ii");
        assertEquals(false, validation.getValid());
    }

    @Test
    public void testVerifyValidPreviousLevelOfEducation() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifypreviousLevelOfEducation("2");
        assertEquals(true, validation.getValid());
    }

    @Test
    public void testVerifyInvalidPreviousLevelOfEducation() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifypreviousLevelOfEducation("7");
        assertEquals(false, validation.getValid());
    }

    @Test
    public void testVerifyValidCGPA() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyCGPA("8");
        assertEquals(true, validation.getValid());
    }

    @Test
    public void testVerifyInvalidCGPA() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyCGPA("8s");
        assertEquals(false, validation.getValid());
    }

    @Test
    public void testVerifyValidTenthPercentage() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyTenthPercentage("80");
        assertEquals(true, validation.getValid());
    }

    @Test
    public void testVerifyInvalidTenthPercentage() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyTenthPercentage("80%");
        assertEquals(false, validation.getValid());
    }

    @Test
    public void testVerifyValidTwelfthPercentage() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyTwelfthPercentage("90");
        assertEquals(true, validation.getValid());
    }

    @Test
    public void testVerifyInvalidTwelfthPercentage() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyTwelfthPercentage("90%");
        assertEquals(false, validation.getValid());
    }

    @Test
    public void testVerifyValidIELTS() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyIELTS("8");
        assertEquals(true, validation.getValid());
    }

    @Test
    public void testVerifyInvalidIELTS() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyIELTS("8.7");
        assertEquals(false, validation.getValid());
    }

    @Test
    public void testVerifyValidGRE() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyGRE("340");
        assertEquals(true, validation.getValid());
    }

    @Test
    public void testVerifyInvalidGRE() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyGRE("400");
        assertEquals(false, validation.getValid());
    }

    @Test
    public void testVerifyResearchPaper() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyReasearchPapers("9");
        assertEquals(true, validation.getValid());
    }

    @Test
    public void testVerifyWorkExperience() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyWorkExperience("3");
        assertEquals(true, validation.getValid());
    }

    @Test
    public void testVerifyValidGMAT() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyGMAT("600");
        assertEquals(true, validation.getValid());
    }

    @Test
    public void testVerifyInvalidGMAT() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyGMAT("900");
        assertEquals(false, validation.getValid());
    }


    @Test
    public void testVerifyValidGATE() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyGATE("40");
        assertEquals(true, validation.getValid());
    }

    @Test
    public void testVerifyInvalidGATE() {
        ValidateNewApplication validateNewApplication = new ValidateNewApplication();
        AddNewApplicationFormValidation validation = validateNewApplication.verifyGATE("200");
        assertEquals(false, validation.getValid());
    }

}