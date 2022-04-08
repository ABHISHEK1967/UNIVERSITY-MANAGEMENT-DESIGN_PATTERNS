package edu.dalhousie.business.courseregistration.business;

public interface IValidateCourseRegistration {
    boolean isInvalidCourseId(String courseId);

    boolean isInvalidChoice(String choice);

    boolean isValidKeyword(String keyword);

    boolean isNotAvailableCourse(String courseId);

    boolean hasPreRequisiteCourse(String courseId);

    boolean isAlreadyRegisteredCourse(String courseId);
}
