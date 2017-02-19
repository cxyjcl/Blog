package org.service.impl;

import java.sql.SQLException;

import org.dao.UserDao;
import org.dao.impl.CheckEmailImpl;
import org.dao.impl.CheckNameImpl;
import org.entity.User;
import org.service.LSEService;

public class CheckEmailServiceImpl  implements LSEService {
	
	UserDao dao = new CheckEmailImpl();
	@Override
	public boolean find(User user) throws SQLException {
		return dao.findUser(user);
	}

	@Override
	public void add(User user) throws SQLException {}

	@Override
	public User get(User user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
