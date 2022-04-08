package edu.dalhousie.business.roommatefinder.business;

public interface IValidateRoommateFinder {
    public boolean verifyGender(int input);
    public boolean verifyFood(int input);
    public boolean verifyGenderPreference(int input);
    public boolean verifyCampus(int input);
    public boolean verifyAccomodation(int input);
}
