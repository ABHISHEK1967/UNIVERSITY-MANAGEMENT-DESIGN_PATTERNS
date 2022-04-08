package edu.dalhousie.business.roommatefinder.database;

import edu.dalhousie.business.roommatefinder.model.RoommateFinderObjectModel;

import java.sql.SQLException;
import java.util.List;

public interface IRoommateFinderData {
    void storeData(RoommateFinderObjectModel roommateFinderObject) throws SQLException;
    List<String> retrieveData(RoommateFinderObjectModel roommateFinderObject) throws SQLException;
}
