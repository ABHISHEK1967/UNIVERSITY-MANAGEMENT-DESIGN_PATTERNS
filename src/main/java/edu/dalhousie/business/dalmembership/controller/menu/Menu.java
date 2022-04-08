/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.dalmembership.controller.menu;

public class Menu extends MainMenu{
    private static Menu instance;
    private Menu(){

    }
    public static Menu getInstance(){
        if(instance==null){
            return new Menu();
        }
        return instance;
    }
}
