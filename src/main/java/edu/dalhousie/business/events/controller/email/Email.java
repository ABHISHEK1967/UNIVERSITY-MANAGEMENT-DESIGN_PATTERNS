/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.email;

public class Email {
    private String subject;
    private String body;


    public Email(){

    }
    public Email(String subject, String body){
        this.subject = subject;

        this.body = body;

    }
    public String getSubject() {
        return subject;
    }



    public String getBody() {
        return body;
    }



}
