/**
 * 
 */
package com.noirougeevents.com.server.email;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

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

/**
 * @author RynoM
 *
 */
public class Mail
{
	/**
	 * @param recipientAdress
	 * @param recipientName
	 * @param message
	 */
	public void sendMail(String recipientAdress,String recipientName, String message, String subject)
	{
	        Properties props = new Properties();
	        Session session = Session.getDefaultInstance(props, null);	        

	        try 
	        {
	      	  Multipart mp = new MimeMultipart();

	           MimeBodyPart htmlPart = new MimeBodyPart();
	           htmlPart.setContent(message, "text/html");
	           mp.addBodyPart(htmlPart);

	      /*     MimeBodyPart attachment = new MimeBodyPart();
	           attachment.setFileName("manual.pdf");
	           attachment.setContent(attachmentData, "application/pdf");
	           mp.addBodyPart(attachment);*/

	          // message.setContent(mp);
	      	  
	            Message msg = new MimeMessage(session);
	            msg.setFrom(new InternetAddress("admin@noirougeevents.com", "Noi Rouge Events"));
	            msg.addRecipient(Message.RecipientType.TO,
	                             new InternetAddress(recipientAdress, recipientName));
	            msg.setSubject(subject);
	          //  msg.setText(message);
	            msg.setContent(mp);
	            Transport.send(msg);

	        } 
	        catch (AddressException e) 
	        {
	            // ...
	        } 
	        catch (MessagingException e) 
	        {
	            // ...
	        }
			catch (UnsupportedEncodingException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
