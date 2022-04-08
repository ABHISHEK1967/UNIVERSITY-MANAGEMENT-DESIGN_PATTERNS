package edu.dalhousie.business.courseregistration.model;

import java.util.List;

public class RegisteredCourses implements IRegisteredCourses {
    private static List<Course> registeredCourses;

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Course> registeredCourses) {
        RegisteredCourses.registeredCourses = registeredCourses;
    }
}
