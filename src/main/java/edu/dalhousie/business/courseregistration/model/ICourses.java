package edu.dalhousie.business.courseregistration.model;

import java.util.List;

public interface ICourses {
    List<Course> getCourses();

    void setCourses(List<Course> courses);
}
