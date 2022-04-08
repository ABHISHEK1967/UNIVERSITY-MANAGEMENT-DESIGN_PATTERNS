package edu.dalhousie.business.roommatefinder.controller;

import edu.dalhousie.business.roommatefinder.business.FilterRoommates;
import edu.dalhousie.business.roommatefinder.business.IFilterRoommates;
import edu.dalhousie.business.roommatefinder.business.IValidateRoommateFinder;
import edu.dalhousie.business.roommatefinder.business.ValidateRoommateFinder;
import edu.dalhousie.business.roommatefinder.database.IRoommateFinderData;
import edu.dalhousie.business.roommatefinder.database.RoommateFinderData;
import edu.dalhousie.business.roommatefinder.model.RoommateFinderObjectModel;
import edu.dalhousie.business.roommatefinder.constants.StringConstants;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.util.List;

public class RoommateFinder implements IRoommateFinder{

    ICommonPrinting view;
    RoommateFinderObjectModel roommateFinderObject;
    IRoommateFinderData roommateFinderData;
    IValidateRoommateFinder validateRoommateFinder;
    IFilterRoommates filterRoommates;

    public RoommateFinder() {
        view = CommonPrinting.getInstance();
        roommateFinderObject = new RoommateFinderObjectModel();
        roommateFinderData = new RoommateFinderData();
        validateRoommateFinder = new ValidateRoommateFinder();
        filterRoommates = new FilterRoommates();
    }

    public void displayForm() throws Exception {
        view.showMessage(StringConstants.kGender);
        int gender = view.getInt();
        boolean genderVerified = validateRoommateFinder.verifyGender(gender);
        if (!genderVerified) {
            while(!genderVerified) {
                view.showMessage(StringConstants.kWrongInput);
                view.showMessage(StringConstants.kGender);
                gender = view.getInt();
                genderVerified = validateRoommateFinder.verifyGender(gender);
            }
        }
        view.showMessage(String.valueOf(gender));
        roommateFinderObject.setGender(gender);

        view.showMessage(StringConstants.kFood);
        int food = view.getInt();
        boolean foodVerified = validateRoommateFinder.verifyFood(food);
        if (!foodVerified) {
            while(!foodVerified) {
                view.showMessage(StringConstants.kWrongInput);
                view.showMessage(StringConstants.kFood);
                food = view.getInt();
                foodVerified = validateRoommateFinder.verifyGender(food);
            }
        }
        view.showMessage(String.valueOf(food));
        roommateFinderObject.setFoodPreference(food);

        view.showMessage(StringConstants.kGenderPreference);
        int genderPreference = view.getInt();
        boolean genderPreferenceVerified = validateRoommateFinder.verifyGenderPreference(genderPreference);
        if (!genderPreferenceVerified) {
            while(!genderPreferenceVerified) {
                view.showMessage(StringConstants.kWrongInput);
                view.showMessage(StringConstants.kGenderPreference);
                genderPreference = view.getInt();
                genderPreferenceVerified = validateRoommateFinder.verifyGenderPreference(genderPreference);
            }
        }
        view.showMessage(String.valueOf(genderPreference));
        roommateFinderObject.setGenderPreference(genderPreference);

        view.showMessage(StringConstants.kHobbies);
        roommateFinderObject.setHobbies(view.getString());

        view.showMessage(StringConstants.kCampus);
        int campus = view.getInt();
        boolean campusVerified = validateRoommateFinder.verifyCampus(campus);
        if (!campusVerified) {
            while(!campusVerified) {
                view.showMessage(StringConstants.kWrongInput);
                view.showMessage(StringConstants.kCampus);
                campus = view.getInt();
                campusVerified = validateRoommateFinder.verifyCampus(campus);
            }
        }
        view.showMessage(String.valueOf(campus));
        roommateFinderObject.setCampusPreference(campus);

        view.showMessage(StringConstants.kAccomodation);
        int accomodation = view.getInt();
        boolean accomodationVerified = validateRoommateFinder.verifyAccomodation(accomodation);
        if (!accomodationVerified) {
            while(!accomodationVerified) {
                view.showMessage(StringConstants.kWrongInput);
                view.showMessage(StringConstants.kAccomodation);
                accomodation = view.getInt();
                accomodationVerified = validateRoommateFinder.verifyAccomodation(accomodation);
            }
        }
        view.showMessage(String.valueOf(accomodation));
        roommateFinderObject.setAccomodationPreference(accomodation);

        roommateFinderData.storeData(roommateFinderObject);

        List<String> matches = roommateFinderData.retrieveData(roommateFinderObject);
        List<String> filteredMatches = filterRoommates.filterData(roommateFinderObject, matches);

        view.showMessage(StringConstants.kLoading);
        view.showMessage(StringConstants.kSuggestions);

        for(String match: filteredMatches) {
            view.showMessage(match);
        }
    }
}