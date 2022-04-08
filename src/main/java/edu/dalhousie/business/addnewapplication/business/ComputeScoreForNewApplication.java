package edu.dalhousie.business.addnewapplication.business;

import edu.dalhousie.business.addnewapplication.model.AddNewApplicationFormObject;
import edu.dalhousie.constants.StringConstants;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.util.Locale;

public class ComputeScoreForNewApplication extends ComputeScoreForNewApplicationTemplate {

    private ICommonPrinting view;
    private AddNewApplicationFormObject addNewApplicationFormObject;
    private final float approvalMarks = 320;
    private final float satisfactoryMarks = 20;
    private final float belowAverageMarks = 25;
    private final float averageMarks = 30;
    private final float aboveAverage = 35;
    private final float goodMarks = 40;
    private final float veryGoodMarks = 45;
    private final float outstandingMarks = 50;
    public float score = 0;
    public boolean isPass = true;

    public ComputeScoreForNewApplication(AddNewApplicationFormObject addNewApplicationFormObject) {
        view = CommonPrinting.getInstance();
        this.addNewApplicationFormObject = addNewApplicationFormObject;
    }

    @Override
    void computeUniversityScore() {
        if (addNewApplicationFormObject.getUniversity().toLowerCase(Locale.ROOT).contains(StringConstants.kIIT) || addNewApplicationFormObject.getUniversity().toLowerCase(Locale.ROOT).contains(StringConstants.kIndianInstituteOfTechnology)) {
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        } else if (addNewApplicationFormObject.getUniversity().toLowerCase(Locale.ROOT).contains(StringConstants.kNIT) || addNewApplicationFormObject.getUniversity().toLowerCase(Locale.ROOT).contains(StringConstants.kNationalInstituteOfTechnology)) {
            score += veryGoodMarks;
            view.showMessage(String.valueOf(score));
        } else {
            score += averageMarks;
            view.showMessage(String.valueOf(score));
        }
    }

    @Override
    void computeEducationScore() {
        if (addNewApplicationFormObject.getEducation().equals("1")) {
            score += belowAverageMarks;
            view.showMessage(String.valueOf(score));
        } else if (addNewApplicationFormObject.getEducation().equals("2")) {
            score += aboveAverage;
            view.showMessage(String.valueOf(score));
        } else if (addNewApplicationFormObject.getEducation().equals("3")){
            score += goodMarks;
            view.showMessage(String.valueOf(score));
        } else {
            score += veryGoodMarks;
            view.showMessage(String.valueOf(score));
        }
    }

    @Override
    void computeGPAScore() {
        if (((Float.parseFloat(addNewApplicationFormObject.getGpa())) >= 8.5) && ((Float.parseFloat(addNewApplicationFormObject.getGpa())) <= 9)) {
            score += aboveAverage;
            view.showMessage(String.valueOf(score));
        } else if (((Float.parseFloat(addNewApplicationFormObject.getGpa())) > 9) && ((Float.parseFloat(addNewApplicationFormObject.getGpa())) <= 9.5)) {
            score += veryGoodMarks;
            view.showMessage(String.valueOf(score));
        } else if ((Float.parseFloat(addNewApplicationFormObject.getGpa())) > 9.5) {
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        } else if (((Float.parseFloat(addNewApplicationFormObject.getGpa())) >= 8) && (((Float.parseFloat(addNewApplicationFormObject.getGpa())) < 8.5))){
            score += satisfactoryMarks;
            view.showMessage(String.valueOf(score));
        } else {
            isPass = false;
        }
    }

    @Override
    void computeTenthScore() {
        if (((Float.parseFloat(addNewApplicationFormObject.getTenthMarks())) >= 85) && ((Float.parseFloat(addNewApplicationFormObject.getTenthMarks())) <= 90)) {
            score += aboveAverage;
            view.showMessage(String.valueOf(score));
        } else if (((Float.parseFloat(addNewApplicationFormObject.getTenthMarks())) > 90) && ((Float.parseFloat(addNewApplicationFormObject.getTenthMarks())) <= 95)) {
            score += veryGoodMarks;
            view.showMessage(String.valueOf(score));
        } else if ((Float.parseFloat(addNewApplicationFormObject.getTenthMarks())) > 95) {
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        } else if (((Float.parseFloat(addNewApplicationFormObject.getTenthMarks())) > 45) && (((Float.parseFloat(addNewApplicationFormObject.getTenthMarks())) < 85))){
            score += satisfactoryMarks;
            view.showMessage(String.valueOf(score));
        } else {
            isPass = false;
        }
    }

    @Override
    void computeTwelfthScore() {
        if (((Float.parseFloat(addNewApplicationFormObject.getTwelfthMarks())) >= 85) && ((Float.parseFloat(addNewApplicationFormObject.getTwelfthMarks())) <= 90)) {
            score += aboveAverage;
            view.showMessage(String.valueOf(score));
        } else if (((Float.parseFloat(addNewApplicationFormObject.getTwelfthMarks())) > 90) && ((Float.parseFloat(addNewApplicationFormObject.getTwelfthMarks())) <= 95)) {
            score += veryGoodMarks;
            view.showMessage(String.valueOf(score));
        } else if ((Float.parseFloat(addNewApplicationFormObject.getTwelfthMarks())) > 95) {
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        } else if (((Float.parseFloat(addNewApplicationFormObject.getTwelfthMarks())) > 45) && (((Float.parseFloat(addNewApplicationFormObject.getTwelfthMarks())) < 85))){
            score += satisfactoryMarks;
            view.showMessage(String.valueOf(score));
        } else {
            isPass = false;
        }
    }

    @Override
    void computeIELTSScore() {
        if ((Float.parseFloat(addNewApplicationFormObject.getIELTS())) == 7) {
            score += aboveAverage;
            view.showMessage(String.valueOf(score));
        } else if ((Float.parseFloat(addNewApplicationFormObject.getIELTS())) == 7.5) {
            score += goodMarks;
            view.showMessage(String.valueOf(score));
        } else if ((Float.parseFloat(addNewApplicationFormObject.getIELTS())) > 7.5) {
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        } else {
            isPass = false;
        }
    }

    @Override
    void computeGREScore() {
        if (((Integer.parseInt(addNewApplicationFormObject.getGRE())) >= 290) && ((Integer.parseInt(addNewApplicationFormObject.getGRE())) <= 300)) {
            score += averageMarks;
            view.showMessage(String.valueOf(score));
        } else if (((Integer.parseInt(addNewApplicationFormObject.getGRE())) > 300) && ((Integer.parseInt(addNewApplicationFormObject.getGRE())) <= 310)) {
            score += goodMarks;
            view.showMessage(String.valueOf(score));
        } else if ((Integer.parseInt(addNewApplicationFormObject.getGRE())) > 310) {
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        } else {
            score += satisfactoryMarks;
            view.showMessage(String.valueOf(score));
        }
    }

    @Override
    void computeResearchPapersScore() {
        if ((Integer.parseInt(addNewApplicationFormObject.getResearchPapers())) == 1) {
            score += aboveAverage;
            view.showMessage(String.valueOf(score));
        } else if ((Integer.parseInt(addNewApplicationFormObject.getResearchPapers())) == 2) {
            score += veryGoodMarks;
            view.showMessage(String.valueOf(score));
        } else if ((Integer.parseInt(addNewApplicationFormObject.getResearchPapers())) > 3) {
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        } else {
            score += satisfactoryMarks;
            view.showMessage(String.valueOf(score));
        }
    }

    @Override
    void computeWorkExperienceScore() {
        if (((Float.parseFloat(addNewApplicationFormObject.getWorkExp())) >= 1) && ((Float.parseFloat(addNewApplicationFormObject.getWorkExp())) <= 2)) {
            score += averageMarks;
            view.showMessage(String.valueOf(score));
        } else if (((Float.parseFloat(addNewApplicationFormObject.getWorkExp())) > 2) && ((Float.parseFloat(addNewApplicationFormObject.getWorkExp())) <= 4)) {
            score += goodMarks;
            view.showMessage(String.valueOf(score));
        } else if ((Float.parseFloat(addNewApplicationFormObject.getWorkExp())) > 4) {
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        } else {
            score += satisfactoryMarks;
            view.showMessage(String.valueOf(score));
        }
    }

    @Override
    void computeGMATScore() {
        if (((Integer.parseInt(addNewApplicationFormObject.getGMAT())) >= 550) && ((Integer.parseInt(addNewApplicationFormObject.getGMAT())) <= 600)) {
            score += averageMarks;
            view.showMessage(String.valueOf(score));
        } else if (((Integer.parseInt(addNewApplicationFormObject.getGMAT())) > 600) && ((Integer.parseInt(addNewApplicationFormObject.getGMAT())) <= 650)) {
            score += goodMarks;
            view.showMessage(String.valueOf(score));
        } else if ((Integer.parseInt(addNewApplicationFormObject.getGMAT())) > 650) {
            score += outstandingMarks;
            view.showMessage(String.valueOf(score));
        } else {
            score += satisfactoryMarks;
            view.showMessage(String.valueOf(score));
        }
    }

    @Override
    void computeGATEScore() {
        if (((Integer.parseInt(addNewApplicationFormObject.getGATE())) >= 0) && ((Integer.parseInt(addNewApplicationFormObject.getGATE())) <= 30)) {
            score += averageMarks;
        } else if (((Integer.parseInt(addNewApplicationFormObject.getGATE())) > 30) && ((Integer.parseInt(addNewApplicationFormObject.getGATE())) <= 60)) {
            score += goodMarks;
        } else if ((Integer.parseInt(addNewApplicationFormObject.getGATE())) > 60) {
            score += outstandingMarks;
        }
    }

    @Override
    String checkEligibility() {
        addNewApplicationFormObject.setResult(String.valueOf(score));
        System.out.println("Score is " + score);
        addNewApplicationFormObject.setResult(String.valueOf(score));

        if (score>approvalMarks && isPass) {
            return StringConstants.kApplicationApproved;
        } else {
            return StringConstants.kApplicationDenied;
        }
    }
}
