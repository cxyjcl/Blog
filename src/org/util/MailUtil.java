package org.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.entity.User;

public class MailUtil {
	
	public static void send(User user,String content) throws AddressException, MessagingException {
		
		Properties props = new Properties();
		props.setProperty("mail.host", "smtp.163.com");
		props.setProperty("mail.smtp.auth","true");
		Authenticator auth = new Authenticator(){
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication("cbjcl0204", "13575254951");
			}
		};
		Session session = Session.getInstance(props,auth);
		MimeMessage msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("cbjcl0204@163.com"));
		msg.setRecipients(RecipientType.TO,user.getEmail());
		msg.setSubject("来自私人Blog的一封信，请注意不是垃圾邮件！！！！！！！！！");
		msg.setContent(content,"text/html;charset=utf-8");
		Transport.send(msg);
	}
}
