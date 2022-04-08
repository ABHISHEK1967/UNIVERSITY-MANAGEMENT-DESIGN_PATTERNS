package edu.dalhousie.business.roommatefinder.business;

import edu.dalhousie.business.roommatefinder.constants.StringConstants;
import edu.dalhousie.business.roommatefinder.model.RoommateFinderObjectModel;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterRoommatesTest {

    @Test
    public void testNoMatchFilteredData() {
        RoommateFinderObjectModel roommateFinderObjectModel = new RoommateFinderObjectModel("vignesh", 1,2,1, "cricket", 1,1,1);
        FilterRoommates filterRoommates = new FilterRoommates();
        List<String> matches = filterRoommates.filterData(roommateFinderObjectModel, new ArrayList<>());
        assertEquals(StringConstants.kNoBuddies, matches.get(0));
    }

    @Test
    public void testMatchFilteredData() {
        List<String> match = new ArrayList<>();
        match.add("json");
        RoommateFinderObjectModel roommateFinderObjectModel = new RoommateFinderObjectModel("vignesh", 1,2,1, "cricket", 1,1,1);
        FilterRoommates filterRoommates = new FilterRoommates();
        List<String> matches = filterRoommates.filterData(roommateFinderObjectModel, match);
        assertEquals("json", matches.get(0));
    }

}