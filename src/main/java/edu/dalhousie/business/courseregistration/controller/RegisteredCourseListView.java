package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.constants.CourseRegistrationConstants;
import edu.dalhousie.business.courseregistration.model.Course;
import edu.dalhousie.utilities.printing.CommonPrinting;
import edu.dalhousie.utilities.printing.ICommonPrinting;

import java.util.List;

public class RegisteredCourseListView implements IRegisteredCourseListView {
    @Override
    public void renderRegisteredCourseList(List<Course> courses) {
        ICommonPrinting view = CommonPrinting.getInstance();
        int count = 0;

        if (courses.size() > 0) {
            view.showFormattedMessage("\n%25s\n", CourseRegistrationConstants.LIST_OF_REGISTERED_COURSES.toUpperCase());
            view.showFormattedMessage("%5s %15s\n", "ID", "Course name");
            for (Course course : courses) {
                String counter = ++count + "";
                String courseId = course.getCourseId() + "";
                String courseName = course.getCourseName();
                view.showFormattedMessage("%s.  %s | %s\n", counter, courseId, courseName);
            }
        } else {
            view.showMessage(CourseRegistrationConstants.NO_REGISTERED_COURSES_FOUND_MESSAGE);
        }
    }
}
