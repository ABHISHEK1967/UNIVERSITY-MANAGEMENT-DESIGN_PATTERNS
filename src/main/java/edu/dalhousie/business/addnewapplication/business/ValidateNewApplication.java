package edu.dalhousie.business.addnewapplication.business;

import edu.dalhousie.business.addnewapplication.model.AddNewApplicationFormValidation;
import edu.dalhousie.constants.StringConstants;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.util.Arrays;
import java.util.List;

public class ValidateNewApplication implements IValidateNewApplication {

    ICommonPrinting view;

    public ValidateNewApplication() {
        view = CommonPrinting.getInstance();
    }

    public AddNewApplicationFormValidation verifyCourseName(String courseName) {
        if (courseName.length()>=4) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidCourse);
    }

    public AddNewApplicationFormValidation verifyPreviousSchoolName(String previousSchoolName) {
        if (previousSchoolName.length()>=3) {
            return new AddNewApplicationFormValidation(true,StringConstants.kSuccess );
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidPreviousSchoolName);
    }

    public AddNewApplicationFormValidation verifypreviousLevelOfEducation(String previousLevelOfEducation) {
        if ((previousLevelOfEducation.length() == 1) && ((Integer.parseInt(previousLevelOfEducation) == 1) || (Integer.parseInt(previousLevelOfEducation) == 2) || (Integer.parseInt(previousLevelOfEducation) == 3) || (Integer.parseInt(previousLevelOfEducation) == 4))){
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (previousLevelOfEducation.length()>1) {
            return new AddNewApplicationFormValidation(false, StringConstants.kOnlyOneEducation);
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidPreviousLevelOfEducation);
    }

    public AddNewApplicationFormValidation verifyCGPA(String cgpa) {
        if (cgpa.matches("[0-9]*(\\.[0-9]*)?") && cgpa.length()>=1) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (!cgpa.matches("[0-9]*(\\.[0-9]*)?")) {
            return new AddNewApplicationFormValidation(false, StringConstants.kCGPAInNumericsOnly);
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidCGPA);
    }

    public AddNewApplicationFormValidation verifyTenthPercentage(String tenthPercentage) {
        if (tenthPercentage.contains("%")) {
            return new AddNewApplicationFormValidation(false, StringConstants.kPercentageInNumericsOnly);
        } else if (tenthPercentage.matches("[0-9]*(\\.[0-9]*)?") && tenthPercentage.length()>=1) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (!tenthPercentage.matches("[0-9]*(\\.[0-9]*)?")) {
            return new AddNewApplicationFormValidation(false, StringConstants.kTenthPercentageInNumericsOnly );
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidTenthPercentage);
    }

    public AddNewApplicationFormValidation verifyTwelfthPercentage(String twelfthPercentage) {
        if (twelfthPercentage.contains("%")) {
            return new AddNewApplicationFormValidation(false, StringConstants.kPercentageInNumericsOnly);
        } else if (twelfthPercentage.matches("[0-9]*(\\.[0-9]*)?") && twelfthPercentage.length()>=1) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (!twelfthPercentage.matches("[0-9]*(\\.[0-9]*)?")) {
            return new AddNewApplicationFormValidation(false, StringConstants.kTwelfthPercentageInNumericsOnly);
        }
        return new AddNewApplicationFormValidation(false, StringConstants.kValidTwelfthPercentage);
    }

    public AddNewApplicationFormValidation verifyIELTS(String ielts) {
        List<String> ieltsBands = Arrays.asList("5", "5.5", "6", "6.5", "7", "7.5", "8", "8.5", "9");
        if (ieltsBands.contains(ielts)) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        }
        return new AddNewApplicationFormValidation(false, "Please enter valid ielts band");
    }

    public AddNewApplicationFormValidation verifyGRE(String gre) {
        if (gre.length() == 1 && gre.contains("0")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (gre.length() == 3 && (Integer.parseInt(gre)>=260 && Integer.parseInt(gre)<=340) && !gre.contains(".")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (gre.length() == 3 && (Integer.parseInt(gre)<=260 && Integer.parseInt(gre)>=340)) {
            return new AddNewApplicationFormValidation(false, "Please enter score in the range of 260-340");
        }
        return new AddNewApplicationFormValidation(false, "Please valid gre score");
    }

    public AddNewApplicationFormValidation verifyReasearchPapers(String researchPapers) {
        if (researchPapers.matches("[0-9]*")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        }
        return new AddNewApplicationFormValidation(false, "Please enter a valid number");
    }

    public AddNewApplicationFormValidation verifyWorkExperience(String workExperience) {
        if (workExperience.matches("[0-9]*")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        }
        return new AddNewApplicationFormValidation(false, "Please enter a valid number");
    }

    public AddNewApplicationFormValidation verifyGMAT(String gmat) {
        if (gmat.length() == 1 && gmat.contains("0")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (gmat.length() == 3 && (Integer.parseInt(gmat)>=200 && Integer.parseInt(gmat)<=800) && !gmat.contains(".")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if (gmat.length() == 3 && (Integer.parseInt(gmat)<=200 || Integer.parseInt(gmat)>=800)) {
            return new AddNewApplicationFormValidation(false, "Please enter score in the range of 200-800");
        }
        return new AddNewApplicationFormValidation(false, "Please valid gmat score");
    }

    public AddNewApplicationFormValidation verifyGATE(String gate) {
        if ((gate.length()>=0 &&gate.length()<=3)  && (Integer.parseInt(gate)>=0 && Integer.parseInt(gate)<=100) && !gate.contains(".")) {
            return new AddNewApplicationFormValidation(true, StringConstants.kSuccess);
        } else if ((gate.length()>=0 &&gate.length()<=3) && (Integer.parseInt(gate)<=0 || Integer.parseInt(gate)>=100)) {
            return new AddNewApplicationFormValidation(false, "Please enter score in the range of 0-100");
        }
        return new AddNewApplicationFormValidation(false, "Please valid gate score");
    }

}
