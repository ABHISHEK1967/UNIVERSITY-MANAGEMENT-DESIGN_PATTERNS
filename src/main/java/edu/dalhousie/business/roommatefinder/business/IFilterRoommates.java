package edu.dalhousie.business.roommatefinder.business;

import edu.dalhousie.business.roommatefinder.model.RoommateFinderObjectModel;

import java.util.List;

public interface IFilterRoommates {
    public List<String> filterData(RoommateFinderObjectModel roommateFinderObject, List<String> matches);
}
