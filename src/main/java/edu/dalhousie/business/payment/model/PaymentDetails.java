/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 */
package edu.dalhousie.business.payment.model;

public class PaymentDetails {
    private final int courseId;
    private final int studentId;
    private final String courseName;
    private final String courseType;

    public int getCourseId() {
        return courseId;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public PaymentDetails(int courseId, int studentId, String courseName, String courseType) {
        this.courseId = courseId;
        this.studentId = studentId;
        this.courseName = courseName;
        this.courseType = courseType;
    }
}
