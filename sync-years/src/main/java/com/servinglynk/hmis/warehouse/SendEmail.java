package com.servinglynk.hmis.warehouse;

import java.util.Calendar;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {

	static Properties mailServerProperties;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
 
	public static void main(String args[]) throws AddressException, MessagingException {
		generateAndSendEmail("sandeep.dolia@gmail.com",null);
		System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
	}
 
	public static void generateAndSendEmail(String toAddress,String filename) throws AddressException, MessagingException {
		// Step1
		System.out.println("\n 1st ===> setup Mail Server Properties..");
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		System.out.println("Mail Server Properties have been setup successfully..");
 
		// Step2
		System.out.println("\n\n 2nd ===> get Mail Session..");
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress("logicsandeep@yahoo.com"));
		generateMailMessage.setSubject("Greetings from ServingLynk LLC");
		String emailBody = "Please find your APR report for 2015 attached. " + " Regards, <br>ServingLynk Admin";
		 BodyPart messageBodyPart = new MimeBodyPart();

	        messageBodyPart.setText(emailBody);

	        if(filename !=null) {
	        	   Multipart multipart = new MimeMultipart();

	   	        multipart.addBodyPart(messageBodyPart);

	   	        messageBodyPart = new MimeBodyPart();
		        DataSource source = new FileDataSource(filename);

		        messageBodyPart.setDataHandler(new DataHandler(source));

		        messageBodyPart.setFileName("APR_Report_"+Calendar.getInstance().getTime()+".pdf");
		        multipart.addBodyPart(messageBodyPart);
	        }

	       // generateMailMessage.setContent(multipart);
		    generateMailMessage.setContent(emailBody, "text/html");
		System.out.println("Mail Session has been created successfully..");
 
		// Step3
		System.out.println("\n\n 3rd ===> Get Session and Send mail");
		Transport transport = getMailSession.getTransport("smtp");
 
		// Enter your correct gmail UserID and Password
		// if you have 2FA enabled then provide App Specific Password
		transport.connect("smtp.gmail.com", "sdoliaric8@gmail.com", "Tomcat#2020");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}
}