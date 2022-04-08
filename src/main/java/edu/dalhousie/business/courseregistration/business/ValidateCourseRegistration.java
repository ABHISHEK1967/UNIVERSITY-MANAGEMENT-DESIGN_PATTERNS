package edu.dalhousie.business.courseregistration.business;

import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.controller.CourseRegistrationFactory;
import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.business.courseregistration.model.ICourses;
import edu.dalhousie.business.courseregistration.model.IRegisteredCourses;

public class ValidateCourseRegistration implements IValidateCourseRegistration {
    @Override
    public boolean isInvalidCourseId(String courseId) {
        ICourses courses = CourseRegistrationFactory.getInstance().getCourses();
        if (courseId.matches("\\d+")) {
            for (Course course : courses.getCourses()) {
                if (course.getCourseId() == Integer.parseInt(courseId)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isInvalidChoice(String choice) {
        return !CourseRegistrationConstants.yesNoList.contains(choice.toLowerCase());
    }

    @Override
    public boolean isValidKeyword(String keyword) {
        String keywordString = keyword.toLowerCase();
        return !keywordString.equals(CourseRegistrationConstants.QUIT);
    }

    @Override
    public boolean isNotAvailableCourse(String courseId) {
        ICourses courses = CourseRegistrationFactory.getInstance().getCourses();
        for (Course course : courses.getCourses()) {
            if (course.getCourseId() == Integer.parseInt(courseId)) {
                if (course.getAvailableSeats() > 0) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public boolean hasPreRequisiteCourse(String courseId) {
        ICourses courses = CourseRegistrationFactory.getInstance().getCourses();
        for (Course course : courses.getCourses()) {
            if (course.getCourseId() == Integer.parseInt(courseId)) {
                if (course.getPreRequisiteCourseId() == 0) {
                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isAlreadyRegisteredCourse(String courseId) {
        IRegisteredCourses registeredCourses = CourseRegistrationFactory.getInstance().getRegisteredCourses();
        for (Course course : registeredCourses.getRegisteredCourses()) {
            if (course.getCourseId() == Integer.parseInt(courseId)) {
                return true;
            }
        }
        return false;
    }
}
