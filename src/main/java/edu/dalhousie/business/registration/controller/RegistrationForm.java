package edu.dalhousie.business.registration.controller;

import edu.dalhousie.business.registration.business.*;
import edu.dalhousie.business.registration.constants.RegistrationConstants;
import edu.dalhousie.business.registration.model.IUser;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;
import edu.dalhousie.utilities.Hashing;

public class RegistrationForm implements IRegistrationForm {
    @Override
    public void renderRegistrationForm(String typeOfUser) {
        ICommonPrinting view = CommonPrinting.getInstance();
        IUserType userType = RegistrationFactory.getInstance().getUserType();
        IUser user = RegistrationFactory.getInstance().getUser();
        IValidatePassword validatePassword = RegistrationFactory.getInstance().getValidatePassword();
        ICreateUsername createUsername = RegistrationFactory.getInstance().getUsernameCreator();
        IValidateEmail validateEmail = RegistrationFactory.getInstance().getValidateEmail();
        IValidateDateOfBirth validateDateOfBirth = RegistrationFactory.getInstance().getValidateDateOfBirth();
        IValidateGender validateGender = RegistrationFactory.getInstance().getValidateGender();
        IValidateContactNumber validateContactNumber = RegistrationFactory.getInstance().getValidateContactNumber();

        String firstName = "", lastName = "", email = "", contactNumber = "", password = "", confirmPassword = "", dateOfBirth = "", gender = "", streetAddress = "", city = "", province = "", zipcode = "";

        view.showMessage(RegistrationConstants.ENTER_FIRST_NAME);
        firstName = view.getString();
        while (firstName.isEmpty()) {
            view.showMessage(RegistrationConstants.ENTER_VALID_FIRST_NAME);
            firstName = view.getString();
        }
        user.setFirstName(firstName);

        view.showMessage(RegistrationConstants.ENTER_LAST_NAME);
        lastName = view.getString();
        while (lastName.isEmpty()) {
            view.showMessage(RegistrationConstants.ENTER_VALID_LAST_NAME);
            lastName = view.getString();
        }
        user.setLastName(lastName);

        view.showMessage(RegistrationConstants.ENTER_EMAIL);
        email = view.getString();
        while (email.isEmpty() || validateEmail.isInvalidEmail(email)) {
            view.showMessage(RegistrationConstants.ENTER_VALID_EMAIL);
            email = view.getString();
        }
        user.setEmail(email);

        view.showMessage(RegistrationConstants.ENTER_CONTACT_NUMBER);
        contactNumber = view.getString();
        while (contactNumber.isEmpty() || validateContactNumber.isInvalidContactNumber(contactNumber)) {
            view.showMessage(RegistrationConstants.ENTER_VALID_CONTACT_NUMBER);
            contactNumber = view.getString();
        }
        user.setContactNumber(contactNumber);

        view.showMessage(RegistrationConstants.ENTER_PASSWORD);
        password = view.getString();
        while (password.isEmpty() || validatePassword.isInvalidPassword(password)) {
            view.showMessage(RegistrationConstants.ENTER_VALID_PASSWORD);
            password = view.getString();
        }
        user.setPassword(password);

        view.showMessage(RegistrationConstants.ENTER_CONFIRM_PASSWORD);
        confirmPassword = view.getString();
        while (confirmPassword.isEmpty() || validatePassword.isInvalidConfirmPassword(password, confirmPassword)) {
            view.showMessage(RegistrationConstants.VALID_CONFIRM_PASSWORD);
            confirmPassword = view.getString();
        }
        user.setConfirmPassword(confirmPassword);
        user.setPassword(Hashing.doPasswordHashing(password));

        view.showMessage(RegistrationConstants.ENTER_DOB);
        dateOfBirth = view.getString();
        while (dateOfBirth.isEmpty() || validateDateOfBirth.isInvalidDateOfBirth(dateOfBirth)) {
            view.showMessage(RegistrationConstants.ENTER_VALID_DOB);
            dateOfBirth = view.getString();
        }
        user.setDateOfBirth(dateOfBirth);

        view.showMessage(RegistrationConstants.ENTER_GENDER);
        gender = view.getString();
        while (gender.isEmpty() || validateGender.isInvalidGender(gender)) {
            view.showMessage(RegistrationConstants.ENTER_VALID_GENDER);
            gender = view.getString();
        }
        gender = RegistrationConstants.genders.get(Integer.parseInt(gender));
        user.setGender(gender);

        view.showMessage(RegistrationConstants.ENTER_STREET_ADDRESS);
        streetAddress = view.getString();
        while (streetAddress.isEmpty()) {
            view.showMessage(RegistrationConstants.ENTER_VALID_STREET_ADDRESS);
            streetAddress = view.getString();
        }
        user.setStreetAddress(streetAddress);

        view.showMessage(RegistrationConstants.ENTER_APARTMENT_NUMBER);
        user.setApartmentNumber(view.getString());

        view.showMessage(RegistrationConstants.ENTER_CITY);
        city = view.getString();
        while (city.isEmpty()) {
            view.showMessage(RegistrationConstants.ENTER_VALID_CITY);
            city = view.getString();
        }
        user.setCity(city);

        view.showMessage(RegistrationConstants.ENTER_PROVINCE);
        province = view.getString();
        while (province.isEmpty()) {
            view.showMessage(RegistrationConstants.ENTER_VALID_PROVINCE);
            province = view.getString();
        }
        user.setProvince(province);

        view.showMessage(RegistrationConstants.ENTER_ZIPCODE);
        zipcode = view.getString();
        while (zipcode.isEmpty()) {
            view.showMessage(RegistrationConstants.ENTER_VALID_ZIPCODE);
            zipcode = view.getString();
        }
        user.setZipcode(zipcode);

        user.setUsername(createUsername.createUsernameFromName(user.getFirstName(), user.getLastName()));
        user.setTypeOfUser(userType.isStudent(typeOfUser) ? RegistrationConstants.STUDENT : RegistrationConstants.FACULTY);
    }
}
