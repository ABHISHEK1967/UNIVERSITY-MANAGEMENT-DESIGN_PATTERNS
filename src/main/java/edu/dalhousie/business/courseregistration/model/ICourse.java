package edu.dalhousie.business.courseregistration.model;

public interface ICourse {
    int getCourseId();

    void setCourseId(int courseId);

    String getCourseName();

    void setCourseName(String courseName);

    int getAvailableSeats();

    void setAvailableSeats(int availableSeats);

    Integer getPreRequisiteCourseId();

    void setPreRequisiteCourseId(int preRequisiteCourseId);
}
