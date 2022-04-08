package edu.dalhousie.controllers;

import edu.dalhousie.business.viewprofile.controller.IViewProfile;
import edu.dalhousie.business.viewprofile.controller.ViewProfile;
import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;
import edu.dalhousie.utilities.printing.PrintHeading;

public class FacultyMainClass {
    ICommonPrinting view = null;

    private int userChoice;
    private static final String profile = "Profile";
    private static final String studentGrading = "Student Grading";
    private static final String eTender = "E-tender for canteen";
    private static final String logout = "Logout";
    public FacultyMainClass(){
        this.view = CommonPrinting.getInstance();
    }
    public void displayFacultyMenu() {
        while (true) {
            PrintHeading.printHeadingForTheScreen("Faculty Menu", 45);

            System.out.println("1. " + profile);
            System.out.println("2. " + studentGrading);
            System.out.println("3. " + eTender);
            System.out.println("4. " + logout);

            System.out.println("\nEnter your choice:");
            userChoice = view.getInt();

            switch (userChoice) {
                case 1:
                    //call method
                    System.out.println("You selected 1");
                    break;
                case 2:
                    IViewProfile viewProfile = new ViewProfile();
                    viewProfile.viewProfilePage("FACULTY");
                    break;
                case 3:
                    //call method
                    System.out.println("You selected 3");
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }
}
