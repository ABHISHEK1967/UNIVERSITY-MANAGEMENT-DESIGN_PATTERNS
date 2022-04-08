package edu.dalhousie.business.courseregistration.model;

import java.util.List;

public interface IRegisteredCourses {
    List<Course> getRegisteredCourses();

    void setRegisteredCourses(List<Course> registeredCourses);
}
