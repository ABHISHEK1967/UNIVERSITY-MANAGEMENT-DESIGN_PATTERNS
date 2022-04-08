package edu.dalhousie.business.registration.controller;

import edu.dalhousie.business.registration.business.*;
import edu.dalhousie.business.registration.database.*;
import edu.dalhousie.business.registration.model.IUser;
import edu.dalhousie.business.registration.model.User;

public class RegistrationFactory {
    private static RegistrationFactory registrationFactory = null;

    IRegistration registration;
    IValidatePassword validatePassword;
    ISaveUser saveUser;
    IUser user;
    ICreateUsername createUsername;
    IUserType userType;
    IRegisterUser registerUser;
    IRegistrationForm registrationForm;
    IValidateEmail validateEmail;
    IValidateDateOfBirth validateDateOfBirth;
    IValidateGender validateGender;
    IValidateContactNumber validateContactNumber;
    IGetUSer fetchUser;
    IAddMembership addMembership;

    public RegistrationFactory() {
        registration = new Registration();
        validatePassword = new ValidatePassword();
        saveUser = new SaveUser();
        user = new User();
        createUsername = new CreateUsername();
        userType = new UserType();
        registerUser = new RegisterUser();
        registrationForm = new RegistrationForm();
        validateEmail = new ValidateEmail();
        validateDateOfBirth = new ValidateDateOfBirth();
        validateGender = new ValidateGender();
        validateContactNumber = new ValidateContactNumber();
        fetchUser = new GetUser();
        addMembership = new AddMembership();
    }

    public static RegistrationFactory getInstance() {
        if (registrationFactory == null) {
            registrationFactory = new RegistrationFactory();
        }
        return registrationFactory;
    }

    public IRegistration getRegistration() {
        return registration;
    }

    public IValidatePassword getValidatePassword() {
        return validatePassword;
    }

    public ISaveUser getSaveUser() {
        return saveUser;
    }

    public IUser getUser() {
        return user;
    }

    public ICreateUsername getUsernameCreator() {
        return createUsername;
    }

    public IUserType getUserType() {
        return userType;
    }

    public IRegisterUser getRegisterUser() {
        return registerUser;
    }

    public IRegistrationForm getRegistrationForm() {
        return registrationForm;
    }

    public IValidateEmail getValidateEmail() {
        return validateEmail;
    }

    public IValidateDateOfBirth getValidateDateOfBirth() {
        return validateDateOfBirth;
    }

    public IValidateGender getValidateGender() {
        return validateGender;
    }

    public IValidateContactNumber getValidateContactNumber() {
        return validateContactNumber;
    }

    public IGetUSer getFetchUser() {
        return fetchUser;
    }

    public IAddMembership getAddMembership() {
        return addMembership;
    }
}
