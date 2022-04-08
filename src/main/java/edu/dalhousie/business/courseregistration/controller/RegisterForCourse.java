package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.business.IValidateCourseRegistration;
import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.database.IRegisterCourse;
import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.business.courseregistration.model.ICourses;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;


public class RegisterForCourse implements IRegisterForCourse {
    @Override
    public int registerForSpecificCourse() {
        ICommonPrinting view = CommonPrinting.getInstance();
        IValidateCourseRegistration validateCourse = CourseRegistrationFactory.getInstance().getValidateCourseRegistration();
        IRegisterCourse registerCourse = CourseRegistrationFactory.getInstance().getRegisterCourse();
        ICourses courses = CourseRegistrationFactory.getInstance().getCourses();
        Course course = null;
        String courseId = "";

        view.showMessage(CourseRegistrationConstants.ENTER_COURSE_ID_FOR_ENROLL);
        courseId = view.getString().toLowerCase();

        if (courseId.equals(CourseRegistrationConstants.NO)) {
            return -1;
        } else if (validateCourse.isInvalidCourseId(courseId)) {
            view.showMessage(CourseRegistrationConstants.PROVIDE_VALID_COURSE_ID);
        } else if (validateCourse.isAlreadyRegisteredCourse(courseId)) {
            view.showMessage(CourseRegistrationConstants.ALREADY_REGISTERED);
        } else if (validateCourse.isNotAvailableCourse(courseId)) {
            view.showMessage(CourseRegistrationConstants.COURSE_FULL);
        } else if (validateCourse.hasPreRequisiteCourse(courseId)) {
            view.showMessage(CourseRegistrationConstants.COURSE_HAS_PRE_REQUISITE_COURSE);
        } else {
            for (Course courseObject : courses.getCourses()) {
                if (courseObject.getCourseId() == Integer.parseInt(courseId)) {
                    course = courseObject;
                }
            }
            return registerCourse.registerForSpecificCourse(course);
        }
        return -1;
    }
}
