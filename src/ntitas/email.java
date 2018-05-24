/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntitas;

/**
 *
 * @author shuvo khan
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class email {


	email(String to,String fn,String ln){
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
                                @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("noreplynt.limited@gmail.com","ntitas123");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from@no-spam.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
			message.setSubject("Rcruitment");
			message.setText("Dear " + fn + " "+ln +","+
					"\n\nYou have been recruited in Ntitas Limited"
                                        +"\nWelcome to Ntitas Family"
                                + "\n\nYour Regards"
                                + "\n\nNtitas Limited");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
                        System.out.println("failed");
			throw new RuntimeException(e);
		}
        }
}