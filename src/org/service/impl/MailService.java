package org.service.impl;

import java.sql.SQLException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.dao.UserDao;
import org.dao.impl.FindUserName;
import org.entity.User;
import org.util.MailUtil;
import org.util.SecurityUtil;

public class MailService {
	
	UserDao dao = new FindUserName();
	
	public boolean find(User user) throws SQLException{
		return dao.findUser(user);
	}
	public void send(User user,String content) throws AddressException, MessagingException{
		String str = SecurityUtil.getKey(user.getEmail());
		content = content.concat("/?email="+user.getEmail()+"&arb="+str);
		MailUtil.send(user, content);
	}
}
