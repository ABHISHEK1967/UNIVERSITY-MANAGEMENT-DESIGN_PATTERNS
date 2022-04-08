package edu.dalhousie.business.registration.constants;

import java.util.HashMap;
import java.util.Map;

public class RegistrationConstants {
    public static final Map<Integer, String> genders = new HashMap<Integer, String>() {
        {
            put(1, "Male");
            put(2, "Female");
            put(3, "Other");
        }
    };

    public static final String STUDENT = "student";
    public static final String FACULTY = "faculty";
    public static final String REGISTER_AS_A_STUDENT = "Register as a student";
    public static final String REGISTER_AS_A_FACULTY = "Register as a faculty";
    public static final String VERIFYING_YOUR_DETAILS = "\nVerifying your details...";
    public static final String DETAILS_VERIFIED = "Details verified...\n";
    public static final String YOUR_USERNAME = "Your username is 'userName'.";
    public static final String PLEASE_LOGIN = "\nPlease login using your username and password to access your portal.\n";
    public static final String SOMETHING_WENT_WRONG_PLEASE_TRY_AGAIN = "Something went wrong, please try again...\n";
    public static final String MEMBERSHIP_CREATED = "Your membership is also created.";

    public static final String ENTER_FIRST_NAME = "Enter your first name: ";
    public static final String ENTER_VALID_FIRST_NAME = "Enter valid first name: ";
    public static final String ENTER_LAST_NAME = "Enter your last name: ";
    public static final String ENTER_VALID_LAST_NAME = "Enter valid last name: ";
    public static final String ENTER_EMAIL = "Enter your email address: ";
    public static final String ENTER_VALID_EMAIL = "Enter valid email address: ";
    public static final String ENTER_CONTACT_NUMBER = "Enter your contact number: ";
    public static final String ENTER_VALID_CONTACT_NUMBER = "Enter valid contact number: ";
    public static final String ENTER_PASSWORD = "Enter your password (Must include uppercase, lowercase letters along with numeric and special characters): ";
    public static final String ENTER_VALID_PASSWORD = "Enter valid password in requested format: ";
    public static final String ENTER_CONFIRM_PASSWORD = "Verify your Password: ";
    public static final String VALID_CONFIRM_PASSWORD = "Verify your Password (confirm password should be match with password): ";
    public static final String ENTER_DOB = "Enter your Date of Birth: (MM-DD-YYYY): ";
    public static final String ENTER_VALID_DOB = "Enter valid Date of Birth in the MM-DD-YYYY format: ";
    public static final String ENTER_GENDER = "Enter your gender (1: Male, 2: Female, 3: Other): ";
    public static final String ENTER_VALID_GENDER = "Enter valid gender: ";
    public static final String ENTER_STREET_ADDRESS = "Enter your street address: ";
    public static final String ENTER_VALID_STREET_ADDRESS = "Enter valid street address: ";
    public static final String ENTER_APARTMENT_NUMBER = "Enter your apartment number (if any): ";
    public static final String ENTER_CITY = "Enter your city: ";
    public static final String ENTER_VALID_CITY = "Enter valid city: ";
    public static final String ENTER_PROVINCE = "Enter your province/state: ";
    public static final String ENTER_VALID_PROVINCE = "Enter valid province/state: ";
    public static final String ENTER_ZIPCODE = "Enter your zip code: ";
    public static final String ENTER_VALID_ZIPCODE = "Enter valid zipcode: ";

    public static final String EMAIL_REGEX = "^(.+)@(.+)\\.(.+)$";
    public static final String CONTACT_NUMBER_REGEX = "^[0-9]{10}$";
    public static final String DATE_OF_BIRTH_REGEX = "^(\\d\\d)-(\\d\\d)-(\\d\\d\\d\\d)$";
    public static final String PASSWORD_REGEX = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]).{4,20}$";

    public static final String GET_USER_QUERY = "SELECT * from tableName WHERE user_name='userName'";

    public static final String ADD_MEMBERSHIP_QUERY = "INSERT INTO tableName(balance, subscription, member_id) VALUES(1000, 'BRONZE', userId)";

    public static final String INSERT_USER_QUERY = "INSERT INTO tableName(first_name, last_name, email_address, contact_number, password, dob, gender, address, apartment_number, city, province, zip_code, user_name, type_of_user) VALUES('firstName', 'lastName', 'emailAddress', 'contactNumber', 'passwordValue', 'dateOfBirth', 'genderValue', 'addressValue', 'apartmentNumber', 'cityValue', 'provinceValue', 'zipCode', 'username', 'typeOfUser')";
}
