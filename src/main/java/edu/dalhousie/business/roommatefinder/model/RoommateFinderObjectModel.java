package edu.dalhousie.business.roommatefinder.model;

public class RoommateFinderObjectModel {

    String userName;
    int gender;
    int foodPreference;
    int genderPreference;
    String hobbies;
    int campusPreference;
    int accomodationPreference;
    int priority;

    public RoommateFinderObjectModel() {
    }

    public RoommateFinderObjectModel(String userName, int gender, int foodPreference, int genderPreference, String hobbies, int campusPreference, int accomodationPreference, int priority) {
        this.userName = userName;
        this.gender = gender;
        this.foodPreference = foodPreference;
        this.genderPreference = genderPreference;
        this.hobbies = hobbies;
        this.campusPreference = campusPreference;
        this.accomodationPreference = accomodationPreference;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(int foodPreference) {
        this.foodPreference = foodPreference;
    }

    public int getGenderPreference() {
        return genderPreference;
    }

    public void setGenderPreference(int genderPreference) {
        this.genderPreference = genderPreference;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public int getCampusPreference() {
        return campusPreference;
    }

    public void setCampusPreference(int campusPreference) {
        this.campusPreference = campusPreference;
    }

    public int getAccomodationPreference() {
        return accomodationPreference;
    }

    public void setAccomodationPreference(int accomodationPreference) {
        this.accomodationPreference = accomodationPreference;
    }

}
