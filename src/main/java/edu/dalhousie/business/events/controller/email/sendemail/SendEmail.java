/**
 * Author: Abhishek karthik Manikandan
 * Banner ID: B00870510
 * */
package edu.dalhousie.business.events.controller.email.sendemail;

import edu.dalhousie.business.events.controller.email.Email;
import edu.dalhousie.logger.ILogger;
import edu.dalhousie.logger.LoggerAbstractFactory;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class SendEmail implements ISendEmail{
    private static ILogger logger = LoggerAbstractFactory
            .getFactory().newLoggerInstance();
    public SendEmail(){
    }
    @Override
    public void sendEmail(String toEmail,Email email) {
        final String userName = "testu1967@gmail.com";
        final String password = "vzvlsqjtpzzwjwcm";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.socketFactory.port", 465);
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        System.out.println("the properties is : " + prop);

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };

        Session session = Session.getInstance(prop, auth);

        Message message = new MimeMessage(session);
        try {

            message.setFrom(new InternetAddress(userName));

            InternetAddress[] toAddresses = { new InternetAddress(toEmail) };

            message.setRecipients(Message.RecipientType.TO, toAddresses);

            message.setSubject(email.getSubject());

            message.setSentDate(new Date());

            message.setContent(email.getBody(), "text/html");

            Transport.send(message);
        } catch (MessagingException e) {
            logger.error(SendEmail.class.toString(),e.getMessage());
            e.printStackTrace();
        }
    }

}
