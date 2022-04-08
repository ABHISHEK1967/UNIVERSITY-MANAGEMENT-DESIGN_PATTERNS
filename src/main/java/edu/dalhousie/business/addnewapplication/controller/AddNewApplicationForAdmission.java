package edu.dalhousie.business.addnewapplication.controller;

import edu.dalhousie.business.addnewapplication.business.*;
import edu.dalhousie.business.addnewapplication.database.AddNewApplicationForAdmissionData;
import edu.dalhousie.business.addnewapplication.database.IAddNewApplicationForAdmissionData;
import edu.dalhousie.business.addnewapplication.model.AddNewApplicationFormObject;
import edu.dalhousie.business.addnewapplication.model.AddNewApplicationFormValidation;
import edu.dalhousie.business.addnewapplication.constants.StringConstants;
import edu.dalhousie.controllers.StudentMainClass;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.sql.SQLException;

public class AddNewApplicationForAdmission implements IAddNewApplicationForAdmission{
    ICommonPrinting view;
    AddNewApplicationFormObject addNewApplication;
    IValidateNewApplication validateNewApplication;
    ComputeScoreForNewApplicationTemplate computeScoreTemplate;
    IAddNewApplicationForAdmissionData storeAdmissionInfo;
    AddNewApplicationFormValidation validation;
    StudentMainClass student;

    public AddNewApplicationForAdmission() throws SQLException {
        view = CommonPrinting.getInstance();
        addNewApplication = new AddNewApplicationFormObject();
        validateNewApplication = new ValidateNewApplication();
        computeScoreTemplate = new ComputeScoreForNewApplication(addNewApplication);
        storeAdmissionInfo = new AddNewApplicationForAdmissionData();
        validation = new AddNewApplicationFormValidation();
        student = StudentMainClass.getInstance();
    }

    public void showNewForm() throws Exception {

        view.showMessage(StringConstants.kFirstQuestion);
        String courseName = view.getString();
        validation = validateNewApplication.verifyCourseName(courseName);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kFirstQuestion);
                courseName = view.getString();
                validation = validateNewApplication.verifyCourseName(courseName);
            }
        }
        addNewApplication.setCourse(courseName);

        view.showMessage(StringConstants.kSecondQuestion);
        String previousSchoolName = view.getString();
        validation = validateNewApplication.verifyPreviousSchoolName(previousSchoolName);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kSecondQuestion);
                previousSchoolName = view.getString();
                validation = validateNewApplication.verifyPreviousSchoolName(previousSchoolName);
            }
        }
        addNewApplication.setUniversity(previousSchoolName);

        view.showMessage(StringConstants.kThirdQuestion);
        String previousLevelOfEducation = view.getString();
        validation = validateNewApplication.verifypreviousLevelOfEducation(previousLevelOfEducation);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kThirdQuestion);
                previousLevelOfEducation = view.getString();
                validation = validateNewApplication.verifypreviousLevelOfEducation(previousLevelOfEducation);
            }
        }
        addNewApplication.setEducation(previousLevelOfEducation);

        view.showMessage(StringConstants.kFourthQuestion);
        String cgpa = view.getString();
        validation = validateNewApplication.verifyCGPA(cgpa);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kFourthQuestion);
                cgpa = view.getString();
                validation = validateNewApplication.verifyCGPA(cgpa);
            }
        }
        addNewApplication.setGpa(cgpa);

        view.showMessage(StringConstants.kFifthQuestion);
        String tenthPercentage = view.getString();
        validation = validateNewApplication.verifyTenthPercentage(tenthPercentage);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kFifthQuestion);
                tenthPercentage = view.getString();
                validation = validateNewApplication.verifyTenthPercentage(tenthPercentage);
            }
        }
        addNewApplication.setTenthMarks(tenthPercentage);

        view.showMessage(StringConstants.kSixthQuestion);
        String twelfthPercentage = view.getString();
        validation = validateNewApplication.verifyTwelfthPercentage(twelfthPercentage);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kSixthQuestion);
                twelfthPercentage = view.getString();
                validation = validateNewApplication.verifyTwelfthPercentage(twelfthPercentage);
            }
        }
        addNewApplication.setTwelfthMarks(twelfthPercentage);

        view.showMessage(StringConstants.kSeventhQuestion);
        String ielts = view.getString();
        validation = validateNewApplication.verifyIELTS(ielts);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kSeventhQuestion);
                ielts = view.getString();
                validation = validateNewApplication.verifyIELTS(ielts);
            }
        }
        addNewApplication.setIELTS(ielts);

        view.showMessage(StringConstants.kEigthQuestion);
        String gre = view.getString();
        validation = validateNewApplication.verifyGRE(gre);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kEigthQuestion);
                gre = view.getString();
                validation = validateNewApplication.verifyGRE(gre);
            }
        }
        addNewApplication.setGRE(gre);

        view.showMessage(StringConstants.kNinethQuestion);
        String researchPapers = view.getString();
        validation = validateNewApplication.verifyReasearchPapers(researchPapers);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kNinethQuestion);
                researchPapers = view.getString();
                validation = validateNewApplication.verifyReasearchPapers(researchPapers);
            }
        }
        addNewApplication.setResearchPapers(researchPapers);

        view.showMessage(StringConstants.kTenthQuestion);
        String workExperience = view.getString();
        validation = validateNewApplication.verifyWorkExperience(workExperience);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kTenthQuestion);
                workExperience = view.getString();
                validation = validateNewApplication.verifyWorkExperience(workExperience);
            }
        }
        addNewApplication.setWorkExp(workExperience);

        view.showMessage(StringConstants.kEleventhQuestion);
        String gmat = view.getString();
        validation = validateNewApplication.verifyGMAT(gmat);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kEleventhQuestion);
                gmat = view.getString();
                validation = validateNewApplication.verifyGMAT(gmat);
            }
        }
        addNewApplication.setGMAT(gmat);

        view.showMessage(StringConstants.kTwelfthQuestion);
        String gate = view.getString();
        validation = validateNewApplication.verifyGATE(gate);
        if (!validation.getValid()) {
            while(!validation.getValid()) {
                view.showMessage(validation.getMessage());
                view.showMessage(StringConstants.kTwelfthQuestion);
                gate = view.getString();
                validation = validateNewApplication.verifyGATE(gate);
            }
        }
        addNewApplication.setGATE(gate);

        view.showMessage(StringConstants.kCalculationInProgress);
        view.showMessage(StringConstants.kResultWillBeShownInSometime);

        storeAdmissionInfo.storeData(addNewApplication);
        String result = computeScoreTemplate.calculateScore();
        String score = addNewApplication.getResult();
        storeAdmissionInfo.storeScore(addNewApplication);
        view.showMessage(StringConstants.kDecision + result);

        student.displayStudentMenu();
    }
}