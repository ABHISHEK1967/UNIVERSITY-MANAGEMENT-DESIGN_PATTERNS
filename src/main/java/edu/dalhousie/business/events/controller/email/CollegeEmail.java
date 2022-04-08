/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.email;

import edu.dalhousie.utilities.printing.ICommonPrinting;
import edu.dalhousie.utilities.printing.CommonPrinting;

public class CollegeEmail implements IEmail{
    ICommonPrinting studentView;
    CollegeEmail(){
       this.studentView = CommonPrinting.getInstance();
    }
    @Override
    public Email generateEmail() {
        System.out.println("Enter the subject for email");
        String subject = this.studentView.getString();

        System.out.println("Enter the body for email");
        String body = this.studentView.getString();

        Email collegeEmail = new Email(subject,body);
        return collegeEmail;
    }
}
