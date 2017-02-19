package org.service.impl;

import java.sql.SQLException;

import org.dao.UserDao;
import org.dao.impl.LoginImpl;
import org.entity.User;
import org.service.LSEService;

public class LoginServiceImpl implements LSEService{
	
	UserDao dao = new LoginImpl();
	
	@Override
	public boolean find(User user) throws SQLException{
			return dao.findUser(user);
	}

	@Override
	public void add(User user) throws SQLException {}

	@Override
	public User get(User user) throws SQLException {
		return dao.getUser(user);
	}

}
