/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.dalmembership.controller.menu;

import edu.dalhousie.business.dalmembership.controller.inMemoryDatabase.MasterDB;

public abstract class MainMenu {

    private void welcomeMessage() {
        System.out.println("Welcome to Dalhousie STUDENT Membership");
    }

    private void printMenu() {
        final int[] count = {1};
        System.out.println("Please select an option:");
        MasterDB.menu.forEach(x -> {
            System.out.println(count[0] + ". " + x);
            count[0]++;
        });

    }
    public void start() {
        welcomeMessage();
        printMenu();
    }
}
