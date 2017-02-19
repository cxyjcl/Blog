package org.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.dao.UserDao;
import org.dao.impl.GetUserInfo;
import org.dao.impl.VisitDao;
import org.entity.User;
import org.entity.Visit;
import org.entity.VisitWordDivide;

public class VisitService {

	VisitDao dao = new VisitDao();
	UserDao userdao = new GetUserInfo();

	public void addWord(String str,String userName,boolean bool) throws SQLException {
		Date time= new Date();
		Visit visit = new Visit();
		visit.setUser_id(userdao.getUserID(userName));
		visit.setSecret(bool);
		visit.setTime(time);
		visit.setWord(str);
		dao.addWord(visit);
	}
	
}
