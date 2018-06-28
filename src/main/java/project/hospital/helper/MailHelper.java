package project.hospital.helper;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailHelper {
	
	public static Session getMailSession() throws Exception {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getInstance(props,new javax.mail.Authenticator() {
														protected PasswordAuthentication getPasswordAuthentication() {
															return new PasswordAuthentication("noreplyproject2018@gmail.com", "!project1234");
														}
													});
		return session;
	}
	
	public static void passwordResetEmail(String recipient, String token, String username) throws Exception{
		Session session = getMailSession();
		
		try {
			MimeMessage email = new MimeMessage(session);
			email.setFrom(new InternetAddress("noreplyproject2018@gmail.com"));
			email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			email.setSubject("Wachtwoord reset");
			email.setText("<p>je hebt een wachtwoord reset aangevraagd op Questlog !</p>" +
						  "<p><a href=http://localhost:8080/QuestLog/executeResetPassword?id=" + username + "&accountToken=" + token + ">klik hier</a> om terug te gaan naar de website en je wachtwoord te veranderen</p> </br> </br>" +
						  "<p style='font-size:14px'>als je geen wachtwoord reset hebt aangevraagd kun je deze mail negeren</p>", 
						  "utf-8", 
						  "html");
			
			Transport.send(email);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void createAccountEmail(String recipient, String token) throws Exception {
		Session session = getMailSession();
		
		try {
			MimeMessage email = new MimeMessage(session);
			email.setFrom(new InternetAddress("noreplyproject2018@gmail.com"));
			email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			email.setSubject("Create Account");
			email.setText("<p>Je hebt een account aangemaakt op Questlog !</p>" +
						  "<p><a href=http://localhost:8080/hospital/activateAccount?&accountToken=" + token + ">Klik hier</a> om je account te activeren en terug te gaan naar de website</p> </br> </br>" +
						  "<p style='font-size:14px'>als je geen account hebt aangemaakt kun je deze mail negeren</p>",
						  "utf-8",
						  "html");
			
			Transport.send(email);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void test(String recipient) throws Exception{
		Session session = getMailSession();
		
		try {
			MimeMessage email = new MimeMessage(session);
			email.setFrom(new InternetAddress("noreplyproject2018@gmail.com"));
			email.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
			email.setSubject("Wachtwoord reset");
			email.setText("<p>je hebt een wachtwoord reset aangevraagd op Questlog !</p>" +
						  "<p><a href=http://localhost:8080/QuestLog/executeResetPassword?id=accountToken=>klik hier</a> om terug te gaan naar de website en je wachtwoord te veranderen</p> </br> </br>" +
						  "<p style='font-size:14px'>als je geen wachtwoord reset hebt aangevraagd kun je deze mail negeren</p>", 
						  "utf-8", 
						  "html");
			
			Transport.send(email);
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
}
