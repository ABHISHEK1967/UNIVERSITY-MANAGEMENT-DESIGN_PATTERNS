/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.model.Student;

import edu.dalhousie.business.events.model.Event.EventNotification;
import edu.dalhousie.utilities.printing.CommonPrinting;

public class Student implements IStudent{
    public String StudentName;
    public CommonPrinting studentView;
    public EventNotification eventNotification;
    public Student(){

    }
    public Student(String StudentName){
        this.setUserName(StudentName);
    }

    @Override
    public String getUserName() {
        return this.StudentName;
    }

    @Override
    public void setUserName(String StudentName) {
        this.StudentName = StudentName;
    }

    public void sendNotificationToStudents(){
        eventNotification = new EventNotification();
        eventNotification.sendEventNotificationToVolunteers();
    }

}
