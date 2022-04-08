/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.email;

public class EmailFactory {

    public IEmail getEmailTemplate(String type){
        if(type.equalsIgnoreCase("STUDENT")){
            return new StudentEmail();
        }
        else if (type.equalsIgnoreCase("college")){
            return new CollegeEmail();
        }
        return null;
    }
}
