package edu.dalhousie.business.addnewapplication.controller;

import edu.dalhousie.business.addnewapplication.constants.StringConstants;

import java.sql.SQLException;

public class AddNewApplicationForAdmissionFactory {

    public static IAddNewApplicationForAdmission createAddNewApplicationForAdmission(String addNewApplicationForAdmission) throws SQLException {

        IAddNewApplicationForAdmission newApplicationForAdmission = null;

        if (addNewApplicationForAdmission == null) {
            return null;
        } else if (addNewApplicationForAdmission.equals(StringConstants.kAddNewApplication)) {
            newApplicationForAdmission = new AddNewApplicationForAdmission();
        }

        return newApplicationForAdmission;

    }
}
