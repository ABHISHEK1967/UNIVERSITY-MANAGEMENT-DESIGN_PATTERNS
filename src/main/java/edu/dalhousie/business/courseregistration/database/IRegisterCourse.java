package edu.dalhousie.business.courseregistration.database;

import edu.dalhousie.business.courseregistration.model.Course;

public interface IRegisterCourse {
    int registerForSpecificCourse(Course course);
}
