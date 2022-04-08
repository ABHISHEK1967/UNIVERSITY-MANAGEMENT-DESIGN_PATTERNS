package edu.dalhousie.business.roommatefinder.business;

public class ValidateRoommateFinder implements IValidateRoommateFinder {

    public boolean verifyGender(int input) {
        if (input == 1 || input == 2) {
            return true;
        }
        return false;
    }

    public boolean verifyFood(int input) {
        if (input == 1 || input == 2 || input == 3) {
            return true;
        }
        return false;
    }

    public boolean verifyGenderPreference(int input) {
        if (input == 1 || input == 2 || input == 3) {
            return true;
        }
        return false;
    }

    public boolean verifyCampus(int input) {
        if (input == 1 || input == 2) {
            return true;
        }
        return false;
    }

    public boolean verifyAccomodation(int input) {
        if (input == 1 || input == 2) {
            return true;
        }
        return false;
    }
}
