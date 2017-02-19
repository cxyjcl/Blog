package org.exception;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.junit.Test;

import com.sun.mail.util.MailSSLSocketFactory;

public class Listenner {
	@Test
public void fun1() throws AddressException, MessagingException {
Properties prop = new Properties();
prop.put("mail.transport.protocol", "smtp");
prop.setProperty("mail.host", "smtp.exmail.qq.com");
prop.setProperty("mail.smtp.auth", "true");
// ssl邮箱端口
prop.put("mail.smtp.socketFactory.port", 587);// 465
// 开启ssl
prop.put("mail.smtp.ssl.enable", "true");
Authenticator auth = new Authenticator() {

protected PasswordAuthentication getPasswordAuthentication() {

return new PasswordAuthentication("406714868", "myrofikxjewucafc");
}
};
Session session = Session.getInstance(prop, auth);
session.setDebug(true);
MimeMessage msg = new MimeMessage(session);
msg.setFrom(new InternetAddress("406714868@qq.com")); // 设置发件人
msg.setRecipients(RecipientType.TO, "3251885371@qq.com"); // 设置收件人
// msg.setRecipients(RecipientType.CC, "3251885371@qq.com"); // 设置抄送
 msg.setRecipients(RecipientType.BCC, "514700548@qq.com"); // 设置暗送

msg.setSubject("这个是标题~~哈哈哈哈哈哈哈哈哈");// 设置标题
msg.setContent("fasfas fs  fa fhahahhahhhasaf sf", "text/html;charset=utf-8");// 设置正文

Transport.send(msg);

}
public void fun2() throws AddressException, MessagingException, GeneralSecurityException{
	Properties props = new Properties();
	props.setProperty("mail.smtp.auth", "true");// 必须 普通客户端
		props.setProperty("mail.transport.protocol", "smtp");// 必须选择协议
	//
	 MailSSLSocketFactory sf = new MailSSLSocketFactory();  
	 sf.setTrustAllHosts(true);  
	 props.put("mail.smtp.ssl.enable", "true");  
	 props.put("mail.smtp.ssl.socketFactory", sf); 
	//
	Session session = Session.getDefaultInstance(props);
	session.setDebug(true);// 设置debug模式 在控制台看到交互信息
	Message msg = new MimeMessage(session); // 建立一个要发送的信息
	msg.setText("li72  welcome ");// 设置简单的发送内容
	msg.setFrom(new InternetAddress("406714868@qq.com"));// 发件人邮箱号
	msg.setSubject("test");
	Transport transport = session.getTransport();// 发送信息的工具
	transport.connect("smtp.qq.com", 465, "406714868@qq.com", "myrofikxjewucafc");// 发件人邮箱号// 和密码
//		transport.connect("smtp.exmail.qq.com", 25, "wenjian_332401890@qq.com", "MEIY0Umima");// 发件人邮箱号
	transport.sendMessage(msg, new Address[] { new InternetAddress("3251885371@qq.com") });// 对方的地址
	transport.close();
}
}
