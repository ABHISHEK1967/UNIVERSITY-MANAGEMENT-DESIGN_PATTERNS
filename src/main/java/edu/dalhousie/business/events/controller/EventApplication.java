/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * citation: https://github.com/anvitsaxena/SchoolEventManagementSystem
 * Used this project repo to get ideas to implement design patterns
 * */
package edu.dalhousie.business.events.controller;

import edu.dalhousie.business.events.controller.cost.EventCost;
import edu.dalhousie.business.events.model.Student.Student;
import edu.dalhousie.business.events.model.University.UniversityDetails;

import java.util.Arrays;
import java.util.Scanner;

public class EventApplication {
    private static EventApplication eventApplication;
    private static Event event;
    private static boolean eventFlag = false;
    private EventApplication(){
        event = new Event();
    }
    public static EventApplication getInstance(){
        if(eventApplication == null){
            eventApplication = new EventApplication();
        }
        return  eventApplication;
    }
    static String[] getUniversityDetails(UniversityDetails[] universities, Scanner sc){

        String[] universityName = new String[universities.length];
        System.out.println("University Registration");
        System.out.println("========================================");
        for(int i=0; i<universities.length;  i++ )
        {
            System.out.print("Please enter university name : ");
            universityName[i] = sc.next();
            universities[0] = new UniversityDetails(universityName[i]);
        }

        for(int i=0; i<universities.length;  i++ )
        {
            System.out.println("Student Registration for "+universityName[i]);
            System.out.println("========================================");
            for(int j=0; j<universities.length;  j++ ){
                universities[0].addStudent();
            }

            System.out.println("Student Information "+universityName[i]);
            System.out.println("========================================");
            universities[0].studentInfo();
        }

        System.out.println("Display Registered University List");
        System.out.println("==============================");
        for (String university : universityName) {
            System.out.println(university);
        }

        return universityName;
    }

    public void hostEvent() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of universities " +
                "going to participate in the event: ");
        int size = sc.nextInt();
        UniversityDetails[] universities = new UniversityDetails[size];

        String[] universityName = getUniversityDetails(universities,sc);

        System.out.println("Please Enter Event Name : ");
        String eventName = sc.next();

        System.out.println("Please Enter Event Location : ");
        String eventLocation = sc.next();

        System.out.println("Please Enter Event Date : ");
        String eventDate = sc.next();

        System.out.println("Please Enter Event Time : ");
        String eventTime = sc.next();

        System.out.println("Please Enter Event Description : ");
        String eventDesc = sc.next();

        System.out.println("Please Enter Organizing University Name : ");
        String universityNameForEvent = sc.next();


        if(Arrays.asList(universityName).contains(universityNameForEvent)) {
            event = new Event(eventName, eventLocation, eventDate, eventTime, eventDesc);

            System.out.println(("\n "+universityNameForEvent+
                    " organizes technical event\n"));

            System.out.println("Event information");
            System.out.println("=================");
            event.getEventInfo();

            for (String s : universityName) {
                if (!s.equals(universityNameForEvent)) {
                    if (universities[0]
                            .sendNotificationToUniversity(s)) {
                        System.out.println("Invitation was accepted by "
                                + s + " \n");
                        eventFlag = true;
                    } else
                        System.out.println("Invitation was rejected by " +
                                s + " \n");
                }

            }

            System.out.println("Enter number of STUDENT volunteers for event : ");
            int num = sc.nextInt();

            System.out.println("Payment");
            System.out.println("Cost for STUDENT to attend the event : $10 ");
            System.out.println("Event is free for volunteer students ");
            EventCost payment = new EventCost();
            payment.studentPayment(num);

            if(eventFlag)
            {
                Student student = new Student();
                student.sendNotificationToStudents();
                System.out.println("Event Starts");
                event.EventProgress();

            }
            else {
                System.out.println("No one has accepted your invitation");
            }

        }else {
            System.out.println("Please Register. ");
        }
    }
}
