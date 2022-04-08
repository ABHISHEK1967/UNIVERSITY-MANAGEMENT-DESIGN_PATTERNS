package edu.dalhousie.business.registration.business;

public class CreateUsername implements ICreateUsername {
    @Override
    public String createUsernameFromName(String firstName, String lastName) {
        String username = firstName + "." + lastName;
        return username.toLowerCase();
    }
}
