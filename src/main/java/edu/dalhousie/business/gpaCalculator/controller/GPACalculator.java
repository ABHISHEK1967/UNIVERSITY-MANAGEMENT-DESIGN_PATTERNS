package edu.dalhousie.business.gpaCalculator.controller;

import edu.dalhousie.business.gpaCalculator.constants.GPACalculatorConstants;
import edu.dalhousie.business.gpaCalculator.model.IGPACalculatorModel;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;
import edu.dalhousie.utilities.printing.PrintHeading;

import java.text.DecimalFormat;

public class GPACalculator implements IGPACalculator {

    public String calculateGPA() {

        ICommonPrinting view = CommonPrinting.getInstance();
        IGPACalculatorModel gpaCalculatorModel = GPACalculatorFactory.initialize().getGpaCalculatorModel();

        gpaCalculatorModel.setTotalPoints(0);
        gpaCalculatorModel.setTotalCredits(0);

        boolean addMoreSubjects = true;

        while (addMoreSubjects) {

            gpaCalculatorModel.setCredits(0);
            boolean validCreditChecker = false;

            while (!validCreditChecker) {
                validCreditChecker = true;

                view.showMessage(GPACalculatorConstants.enterCredits);
                gpaCalculatorModel.setSubjectCredits(view.getString());

                try {
                    gpaCalculatorModel.setCredits(Integer.parseInt(gpaCalculatorModel.getSubjectCredits()));
                }
                catch (NumberFormatException exc){
                    view.showMessage(GPACalculatorConstants.enterValidCredits);
                    validCreditChecker = false;
                }
            }

            boolean validGradeChecker = false;
            gpaCalculatorModel.setGradeValue(0);
            gpaCalculatorModel.setGrade("");

            while (!validGradeChecker) {
                validGradeChecker = true;

                view.showMessage(GPACalculatorConstants.enterGrade);
                gpaCalculatorModel.setGrade(view.getString());

                if (gpaCalculatorModel.getGrade().equalsIgnoreCase("A+")) {

                    gpaCalculatorModel.setGradeValue(4.00);

                } else if (gpaCalculatorModel.getGrade().equalsIgnoreCase("A")) {

                    gpaCalculatorModel.setGradeValue(3.67);

                } else if (gpaCalculatorModel.getGrade().equalsIgnoreCase("A-")) {

                    gpaCalculatorModel.setGradeValue(3.33);

                } else if (gpaCalculatorModel.getGrade().equalsIgnoreCase("B+")) {

                    gpaCalculatorModel.setGradeValue(3.00);

                } else if (gpaCalculatorModel.getGrade().equalsIgnoreCase("B")) {

                    gpaCalculatorModel.setGradeValue(2.67);

                } else if (gpaCalculatorModel.getGrade().equalsIgnoreCase("B-")) {

                    gpaCalculatorModel.setGradeValue(2.33);

                }else if (gpaCalculatorModel.getGrade().equalsIgnoreCase("C+")) {

                    gpaCalculatorModel.setGradeValue(2.00);

                }else if (gpaCalculatorModel.getGrade().equalsIgnoreCase("C")) {

                    gpaCalculatorModel.setGradeValue(1.33);

                }else if (gpaCalculatorModel.getGrade().equalsIgnoreCase("D")) {

                    gpaCalculatorModel.setGradeValue(1.00);

                }else if (gpaCalculatorModel.getGrade().equalsIgnoreCase("F")) {

                    gpaCalculatorModel.setGradeValue(0);

                }else {

                    view.showMessage(GPACalculatorConstants.enterValidGrade);
                    validGradeChecker = false;

                }
            }

            gpaCalculatorModel.setPoints(gpaCalculatorModel.getGradeValue() * gpaCalculatorModel.getCredits());

            gpaCalculatorModel.setTotalPoints(gpaCalculatorModel.getTotalPoints() + gpaCalculatorModel.getPoints());
            gpaCalculatorModel.setTotalCredits(gpaCalculatorModel.getTotalCredits() + gpaCalculatorModel.getCredits());
            view.showMessage(GPACalculatorConstants.enterAdditionalSubjects);
            String moreClassesString = view.getString();

            addMoreSubjects = moreClassesString.equalsIgnoreCase("Yes");

        }

        gpaCalculatorModel.setPattern("0.00");
        DecimalFormat decimalFormat = new DecimalFormat(gpaCalculatorModel.getPattern());
        gpaCalculatorModel.setOverallGPA(gpaCalculatorModel.getTotalPoints()/gpaCalculatorModel.getTotalCredits());

        view.showMessage(GPACalculatorConstants.totalCredits + gpaCalculatorModel.getTotalCredits());
        view.showMessage(GPACalculatorConstants.overallGPA + decimalFormat.format(gpaCalculatorModel.getOverallGPA()));
        return decimalFormat.format(gpaCalculatorModel.getOverallGPA());
    }

    public void viewGPACalculator()
    {
        PrintHeading.printHeadingForTheScreen(GPACalculatorConstants.GPACalculatorTitle, 38);
        calculateGPA();
    }

}
