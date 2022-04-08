package edu.dalhousie.business.scholarship.controller;

import edu.dalhousie.business.scholarship.constants.StringConstants;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

public class ScholarshipMenu {

    ICommonPrinting view;
    int choice;

    public ScholarshipMenu() {
        view = CommonPrinting.getInstance();
    }

    public void displayMenu() throws Exception {
        view.showMessage(StringConstants.kApplyForScholarship);
        view.showMessage(StringConstants.kBackToStudentMenu);
        choice = view.getInt();
        EScholarshipMenuOptions.valueOf(StringConstants.kScholarshipMenuOptionsSuffix + String.valueOf(choice)).displayScholarshipMenu();
    }
}
