package edu.dalhousie.business.roommatefinder.controller;

import edu.dalhousie.business.addnewapplication.constants.StringConstants;

public class RoommateFinderFactory {

    public static IRoommateFinder getRoommateFinder(String roommateFinder) {

        IRoommateFinder roommate = null;

        if(roommateFinder == null) {
            return null;
        } else if (roommateFinder == StringConstants.kRoommateFinder) {
            roommate = new RoommateFinder();
        }

        return roommate;

    }
}
