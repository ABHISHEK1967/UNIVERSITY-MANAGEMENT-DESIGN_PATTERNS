package edu.dalhousie.controllers;

import edu.dalhousie.business.addnewapplication.constants.StringConstants;
import edu.dalhousie.business.addnewapplication.controller.AddNewApplicationForAdmissionFactory;
import edu.dalhousie.business.addnewapplication.controller.IAddNewApplicationForAdmission;
import edu.dalhousie.business.courseregistration.controller.CourseRegistrationFactory;
import edu.dalhousie.business.courseregistration.controller.ICourseRegistration;
import edu.dalhousie.business.dalmembership.controller.menu.MenuImplementation;
import edu.dalhousie.business.events.controller.EventApplication;
import edu.dalhousie.business.feedback.controllers.FeedbackMenuFactory;
import edu.dalhousie.business.feedback.controllers.IFeedbackMenu;
import edu.dalhousie.business.gpaCalculator.controller.GPACalculator;
import edu.dalhousie.business.gpaCalculator.controller.IGPACalculator;
import edu.dalhousie.business.roommatefinder.controller.IRoommateFinder;
import edu.dalhousie.business.roommatefinder.controller.RoommateFinderFactory;
import edu.dalhousie.business.scholarship.controller.ScholarshipMenu;
import edu.dalhousie.business.sportnomination.controller.ISportsNomination;
import edu.dalhousie.business.tender.controller.Tender.Tender;
import edu.dalhousie.business.facilitybooking.controller.FacilityBookingFactory;
import edu.dalhousie.business.facilitybooking.controller.IFacilityBooking;
import edu.dalhousie.business.sportnomination.controller.SportsNomination;
import edu.dalhousie.business.viewprofile.controller.IViewProfile;
import edu.dalhousie.business.viewprofile.controller.ViewProfile;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;
import edu.dalhousie.utilities.printing.PrintHeading;

public class StudentMainClass {
    private final ICommonPrinting view;
    private static StudentMainClass studentMainClass;
    private static final String addNewApplication = "Add new application for admission";
    private static final String profile = "Profile (Personal information and course details)";
    private static final String listOfCourses = "List of courses for registration";
    private static final String feePaymentDetails = "Fee payment details";
    private static final String feedback = "Feedback";
    private static final String applyForScholarship = "Apply for scholarships";
    private static final String organizeEvents = "Organize events";
    private static final String roommateFinder = "Roommate finder";
    private static final String healthReimbursement = "Health Reimbursement";
    private static final String nominationForSports = "Nomination for sports";
    private static final String tender = "Organize e-tender";
    private static final String dalMembership = "Dalhousie STUDENT card";
    private static final String facilityBooking = "Facility booking";
    private static final String gpaCalclator = "GPA Calculator";
    private static final String logout = "Logout";
private UserSession userSession;
    private StudentMainClass(){
        this.view = CommonPrinting.getInstance();
        userSession = UserSession.getInstance();
    }

    public static StudentMainClass getInstance(){
        if(studentMainClass==null){
            studentMainClass = new StudentMainClass();
        }
        return  studentMainClass;
    }

    public void displayStudentMenu() throws Exception {
        while (true) {
            PrintHeading.printHeadingForTheScreen("Student Menu", 45);

            view.showMessage("1. " + addNewApplication);
            view.showMessage("2. " + profile);
            view.showMessage("3. " + listOfCourses);
            view.showMessage("4. " + feePaymentDetails);
            view.showMessage("5. " + feedback);
            view.showMessage("6. " + applyForScholarship);
            view.showMessage("7. " + organizeEvents);
            view.showMessage("8. " + roommateFinder);
            view.showMessage("10. " + nominationForSports);
            view.showMessage("11. " + tender);
            view.showMessage("12. " + dalMembership);
            view.showMessage("13. " + facilityBooking);
            view.showMessage("14. " + gpaCalclator);
            view.showMessage("15. " + logout);

            System.out.println("\nEnter your choice:");
            int choice = view.getInt();
            switch (choice) {
                case 1:
                    IAddNewApplicationForAdmission addNewApplicationForAdmission = AddNewApplicationForAdmissionFactory.createAddNewApplicationForAdmission(StringConstants.kAddNewApplication);
                    addNewApplicationForAdmission.showNewForm();
                    break;
                case 2:
                    IViewProfile viewProfile = new ViewProfile();
                    viewProfile.viewProfilePage("STUDENT");
                    break;
                case 3:
                    ICourseRegistration courseRegistration = CourseRegistrationFactory.getInstance().getCourseRegistration();
                    courseRegistration.startRegisterForCourses();
                    break;
                case 4:
                    FeesPaymentDetailsMenu feesPaymentDetails
                            = FeesPaymentDetailsMenu.getInstance();
                    feesPaymentDetails.showPaymentInformationMenu();
                    break;
                case 5:
                    IFeedbackMenu feedbackMenu = FeedbackMenuFactory.getFeedbackMenu(StringConstants.kFeedbackMenu);
                    feedbackMenu.displayFeedbackMenu();
                    break;
                case 6:
                    ScholarshipMenu scholarshipMenu = new ScholarshipMenu();
                    scholarshipMenu.displayMenu();
                    break;
                case 7:
                    EventApplication eventApplication = EventApplication.getInstance();
                    eventApplication.hostEvent();
                    break;
                case 8:
                    IRoommateFinder roommateFinder = RoommateFinderFactory.getRoommateFinder(StringConstants.kRoommateFinder);
                    roommateFinder.displayForm();
                    break;
                case 10:
                    ISportsNomination sportsNomination = new SportsNomination();
                    sportsNomination.viewSportsNomination();
                    break;
                case 11:
                    Tender tender = Tender.getInstance();
                    tender.getTenderData();
                    break;
                case 12:
                    MenuImplementation menu = MenuImplementation.getInstance();
                    menu.start();
                    break;
                case 13:
                    IFacilityBooking facilityBooking = FacilityBookingFactory.getInstance().getFacilityBooking();
                    facilityBooking.startFacilityBookingService();
                    break;
                case 14:
                    IGPACalculator gpaCalculator = new GPACalculator();
                    gpaCalculator.viewGPACalculator();
                    break;
                case 15:
                    userSession.destroyUserSession();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}