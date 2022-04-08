/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.model.University;

import edu.dalhousie.business.events.model.Event.EventNotification;
import edu.dalhousie.business.events.model.Student.Student;
import edu.dalhousie.business.events.model.Student.StudentIterator;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

import java.util.ArrayList;
import java.util.Iterator;

public class UniversityDetails implements StudentIterator {
    public University university;
    public ICommonPrinting studentView;
    public static ArrayList<Student> student;
    public EventNotification eventNotification;
    public UniversityDetails(){

    }
    public UniversityDetails(String name){
        student = new ArrayList<>();
        university = new University(name);
        studentView = CommonPrinting.getInstance();
    }

    @Override
    public Iterator Iterator() {
        return student.iterator();
    }

    public void addStudent(){
        this.studentView.showMessage("Enter Student name:");
        String studentName = this.studentView.getString();
        student.add(new Student(studentName));
    }

    public void studentInfo(){
        university.studentInfo();
    }

    public boolean sendNotificationToUniversity(String universityName){
        eventNotification = new EventNotification();
        eventNotification.sendEventNotification(universityName);
        return eventNotification.invitationStatus();
    }
}
