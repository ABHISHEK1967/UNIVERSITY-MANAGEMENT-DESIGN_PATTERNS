package edu.dalhousie.business.registration.business;

public interface IValidatePassword {
    boolean isInvalidPassword(String password);

    boolean isInvalidConfirmPassword(String password, String confirmPassword);
}
