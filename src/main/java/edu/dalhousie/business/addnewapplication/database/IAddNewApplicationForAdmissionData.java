package edu.dalhousie.business.addnewapplication.database;

import edu.dalhousie.business.addnewapplication.model.AddNewApplicationFormObject;

import java.sql.SQLException;

public interface IAddNewApplicationForAdmissionData {
    public void storeData(AddNewApplicationFormObject newApplication) throws SQLException;
    public void storeScore(AddNewApplicationFormObject newApplicationFormObject) throws SQLException;
}
