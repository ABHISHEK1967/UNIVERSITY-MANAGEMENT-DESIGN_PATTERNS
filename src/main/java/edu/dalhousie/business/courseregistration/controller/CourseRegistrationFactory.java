package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.business.ValidateCourseRegistration;
import edu.dalhousie.business.courseregistration.database.*;
import edu.dalhousie.business.courseregistration.model.*;

public class CourseRegistrationFactory {
    private static CourseRegistrationFactory courseRegistrationFactory = null;

    ICourseRegistration courseRegistration;
    ICourse course;
    ICourses courses;
    IRegisteredCourses registeredCourses;
    ValidateCourseRegistration validateCourseRegistration;
    ICompleteCourseList completeCourseList;
    IRegisteredCourseList registeredCourseList;
    ISpecificCourseList specificCourseList;
    IRegisterCourse registerCourse;
    ICourseListView courseListView;
    ISearchSpecificCourse searchSpecificCourse;
    IRegisterSpecificCourseForm registerSpecificCourseForm;
    IRegisterForCourse registerForCourse;
    IRegisteredCourseListView registeredCourseListView;

    public CourseRegistrationFactory() {
        courseRegistration = new CourseRegistration();
        course = new Course();
        courses = new Courses();
        registeredCourses = new RegisteredCourses();
        validateCourseRegistration = new ValidateCourseRegistration();
        completeCourseList = new CompleteCourseList();
        registeredCourseList = new RegisteredCourseList();
        specificCourseList = new SpecificCourseList();
        registerCourse = new RegisterCourse();
        courseListView = new CourseListView();
        searchSpecificCourse = new SearchSpecificCourse();
        registerSpecificCourseForm = new RegisterSpecificCourseForm();
        registerForCourse = new RegisterForCourse();
        registeredCourseListView = new RegisteredCourseListView();
    }

    public static CourseRegistrationFactory getInstance() {
        if (courseRegistrationFactory == null) {
            courseRegistrationFactory = new CourseRegistrationFactory();
        }
        return courseRegistrationFactory;
    }

    public ICourseRegistration getCourseRegistration() {
        return courseRegistration;
    }

    public ICourse getCourse() {
        return course;
    }

    public ICourses getCourses() {
        return courses;
    }

    public IRegisteredCourses getRegisteredCourses() {
        return registeredCourses;
    }

    public ValidateCourseRegistration getValidateCourseRegistration() {
        return validateCourseRegistration;
    }

    public ICompleteCourseList getCompleteCourseList() {
        return completeCourseList;
    }

    public IRegisteredCourseList getRegisteredCourseList() {
        return registeredCourseList;
    }

    public ISpecificCourseList getSpecificCourseList() {
        return specificCourseList;
    }

    public IRegisterCourse getRegisterCourse() {
        return registerCourse;
    }

    public ICourseListView getCourseListView() {
        return courseListView;
    }

    public ISearchSpecificCourse getSearchSpecificCourse() {
        return searchSpecificCourse;
    }

    public IRegisterSpecificCourseForm getRegisterSpecificCourseForm() {
        return registerSpecificCourseForm;
    }

    public IRegisterForCourse getRegisterForCourse() {
        return registerForCourse;
    }

    public IRegisteredCourseListView getRegisteredCourseListView() {
        return registeredCourseListView;
    }
}
