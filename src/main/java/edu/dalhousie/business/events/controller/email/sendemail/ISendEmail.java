/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.email.sendemail;

import edu.dalhousie.business.events.controller.email.Email;

public interface ISendEmail {
    public void sendEmail(String toEmail, Email email);
}
