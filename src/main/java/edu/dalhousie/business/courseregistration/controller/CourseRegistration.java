package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.business.IValidateCourseRegistration;
import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.database.ICompleteCourseList;
import edu.dalhousie.business.courseregistration.database.IRegisteredCourseList;
import edu.dalhousie.business.courseregistration.model.ICourses;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;
import edu.dalhousie.utilities.Constants;
import edu.dalhousie.utilities.printing.PrintHeading;

public class CourseRegistration implements ICourseRegistration {
    @Override
    public String getChoiceForCourseRegistration() {
        ICommonPrinting view = CommonPrinting.getInstance();
        IValidateCourseRegistration validate = CourseRegistrationFactory.getInstance().getValidateCourseRegistration();
        String userChoice = "";

        view.showMessage(CourseRegistrationConstants.WANT_TO_SEARCH_FOR_SPECIFIC_COURSE);
        userChoice = view.getString().toLowerCase();
        while (validate.isInvalidChoice(userChoice)) {
            view.showMessage(CourseRegistrationConstants.WANT_TO_SEARCH_FOR_SPECIFIC_COURSE);
            userChoice = view.getString().toLowerCase();
        }
        return userChoice;
    }

    @Override
    public void startRegisterForCourses() {
        ICommonPrinting view = CommonPrinting.getInstance();
        ICourses courses = CourseRegistrationFactory.getInstance().getCourses();
        ICompleteCourseList completeCourseList = CourseRegistrationFactory.getInstance().getCompleteCourseList();
        IRegisteredCourseList registeredCourseList = CourseRegistrationFactory.getInstance().getRegisteredCourseList();
        ICourseListView courseListView = CourseRegistrationFactory.getInstance().getCourseListView();
        ISearchSpecificCourse searchSpecificCourse = CourseRegistrationFactory.getInstance().getSearchSpecificCourse();
        IRegisterSpecificCourseForm registerSpecificCourseForm = CourseRegistrationFactory.getInstance().getRegisterSpecificCourseForm();
        String userChoice = "";

        PrintHeading.printHeadingForTheScreen(CourseRegistrationConstants.LIST_OF_COURSES_FOR_REGISTRATION, 38);
        userChoice = getChoiceForCourseRegistration();

        registeredCourseList.getRegisteredCourseList();

        if (userChoice.equals(CourseRegistrationConstants.NO)) {
            completeCourseList.getCompleteCourseList();
            courseListView.renderCourseListView(courses.getCourses());
            registerSpecificCourseForm.renderRegisterForSpecificCourseForm();
        } else if (userChoice.equals(CourseRegistrationConstants.YES)) {
            searchSpecificCourse.renderSearchForParticularCourseView();
        }

        System.out.println(Constants.PRESS_ENTER_TO_GO_BACK);
        view.getString();
    }
}
