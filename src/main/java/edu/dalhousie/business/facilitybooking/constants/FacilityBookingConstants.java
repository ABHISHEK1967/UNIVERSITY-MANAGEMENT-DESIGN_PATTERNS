package edu.dalhousie.business.facilitybooking.constants;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FacilityBookingConstants {
    public static final Map<Integer, String> facilities = new HashMap<Integer, String>() {
        {
            put(1, "swimming");
            put(2, "badminton");
            put(3, "table tennis");
            put(4, "gym");
        }
    };
    public static final List<Integer> facilityChoices = Arrays.asList(1, 2, 3, 4);

    public static final String AVAILABLE = "Available";
    public static final String BOOKED = "Booked";

    public static final String FACILITY_BOOKING = "Facility booking";
    public static final String AVAILABILITY_FOR = "Availability for ";
    public static final String ENTER_YOUR_USERNAME = "Enter your username:";
    public static final String PLEASE_PROVIDE_VALID_USERNAME = "\nPlease provide valid username.";
    public static final String ENTER_CHOICE_FOR_FACILITY = "Enter the facility name: (1: Swimming, 2: Badminton, 3: Table tennis, 4: Gym)";
    public static final String PLEASE_PROVIDE_VALID_CHOICE = "Please provide valid choice.";
    public static final String ENTER_ID_FROM_LIST = "\nEnter id of your choice from above list for booking:";
    public static final String ENTER_VALID_ID_FROM_LIST = "Please provide valid id from above list for booking:";
    public static final String BOOKING_SUCCESSFUL = "\nYour booking is successful.\n";
    public static final String NO_SLOTS_AVAILABLE = "\nNo slots available for booking.\n";
    public static final String ALREADY_BOOKED_SLOT = "\nThere is a conflict, you have already booked some facility on this date and time.";
    public static final String SOMETHING_WENT_WRONG_PLEASE_TRY_AGAIN = "\nSomething went wrong, please try again...\n";

    public static final String FACILITY_ID_COLUMN = "facility_id";
    public static final String FACILITY_NAME_COLUMN = "facility_name";
    public static final String FACILITY_AVAILABLE_DATE_COLUMN = "available_date";
    public static final String FACILITY_AVAILABLE_TIME_COLUMN = "available_time";
    public static final String FACILITY_AVAILABLE_SLOTS_COLUMN = "available_slots";
    public static final String FACILITY_DATE = "facility_date";
    public static final String FACILITY_TIME = "facility_time";
    public static final String USER_NAME = "user_name";

    public static final String SELECT_ALL_USERS_QUERY = "SELECT * from tableName";

    public static final String BOOK_FACILITY_QUERY = "INSERT INTO tableName(user_name, facility_name, facility_date, facility_time) VALUES('username', 'facilityName', 'facilityDate', 'facilityTime')";

    public static final String GET_BOOKED_FACILITIES_OF_USER = "SELECT * from tableName WHERE user_name='userName'";

    public static final String UPDATE_FACILITY_SLOTS_QUERY = "UPDATE tableName SET available_slots=availableSlots WHERE facility_id=facilityId";

    public static final String SELECT_FACILITY_AVAILABILITY_QUERY = "SELECT * from tableName WHERE facility_name='facilityName'";
}


