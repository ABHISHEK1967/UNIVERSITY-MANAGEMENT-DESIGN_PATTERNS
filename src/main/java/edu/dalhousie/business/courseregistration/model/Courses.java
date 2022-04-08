package edu.dalhousie.business.courseregistration.model;

import java.util.List;

public class Courses implements ICourses {
    private static List<Course> courses;

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
