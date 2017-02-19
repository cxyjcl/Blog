package org.service.impl;

import java.sql.SQLException;
import java.util.Date;

import org.dao.UserDao;
import org.dao.impl.GetUserInfo;
import org.dao.impl.ReplyDao;
import org.entity.Reply;
import org.entity.Visit;

public class ReplyService {
	ReplyDao dao = new ReplyDao();
	UserDao userdao = new GetUserInfo();
	
	public void addWord(Reply reply, String userName) throws SQLException{
		reply.setUser_id(userdao.getUserID(userName));
		dao.addWord(reply);
	}
}
