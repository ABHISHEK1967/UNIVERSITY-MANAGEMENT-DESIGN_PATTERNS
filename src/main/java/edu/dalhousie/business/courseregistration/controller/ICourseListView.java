package edu.dalhousie.business.courseregistration.controller;

import edu.dalhousie.business.courseregistration.model.Course;

import java.util.List;

public interface ICourseListView {
    void renderCourseListView(List<Course> courses);
}
