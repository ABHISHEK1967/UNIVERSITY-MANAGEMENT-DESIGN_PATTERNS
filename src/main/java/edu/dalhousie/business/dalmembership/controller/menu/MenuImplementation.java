/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * citation: https://github.com/pravinsarode301/D2H_console_Application
 * Used this project repo to get ideas to implement design patterns
 * */
package edu.dalhousie.business.dalmembership.controller.menu;
import edu.dalhousie.business.dalmembership.controller.balance.Balance;
import edu.dalhousie.business.dalmembership.controller.services.Services;
import edu.dalhousie.business.dalmembership.controller.subscription.SubscriptionImplementation;
import edu.dalhousie.controllers.UserSession;
import edu.dalhousie.database.IDatabaseConnection;
import edu.dalhousie.database.DatabaseConnectivity;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;

import java.util.Scanner;

public class MenuImplementation implements IMenu{
    public MainMenu menu;
    public final static Scanner input = new Scanner(System.in);
    private final IDatabaseConnection IDatabaseConnection;
    UserSession userSession;
    private static MenuImplementation menuImplementation;
    private static ILogger logger = LoggerAbstractFactory
            .getFactory().newLoggerInstance();
    private  MenuImplementation(){
        userSession = UserSession.getInstance();
        menu = Menu.getInstance() ;
        this.IDatabaseConnection = DatabaseConnectivity.getInstance();
    }
    public static MenuImplementation getInstance(){
        if(menuImplementation == null){
            menuImplementation = new MenuImplementation();
        }
        return menuImplementation;
    }
    @Override
    public void start() {
        menu.start();
        try{
            while(true){
                int choice = input.nextInt();
                switch (choice){
                    case 1:
                        try{
                            Balance balance = new Balance();
                            balance.showExistingBalance(IDatabaseConnection);
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        try{
                            System.out.println("Enter the amount you want to recharge with:");
                            double amount = input.nextInt();
                            Balance balance = new Balance();
                            balance.rechargeBalance(IDatabaseConnection,amount);
                        }
                        catch(Exception e){
                            logger.error(Balance.class.toString(),e.getMessage());
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                            Services services = new Services();
                            services.getListOfServices();
                        break;
                    case 4:
                        SubscriptionImplementation subscriptionImplementation
                                = new SubscriptionImplementation();
                        System.out.println("Enter choice:");
                        String Choice = input.next();
                        System.out.println("Enter duration:");
                        double Duration = input.nextDouble();
                        subscriptionImplementation.subscribe(
                                Choice,Duration,
                                userSession.getUser(), IDatabaseConnection);
                        break;
                    case 5:
                        return;
                    default:
                        break;
                }
            }
        }
        catch (Exception e){
            logger.error(MenuImplementation.class.toString(),e.getMessage());
            System.out.println(e.getMessage());
        }
    }

}
