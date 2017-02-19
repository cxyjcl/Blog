package org.service.impl;

import java.sql.SQLException;

import org.dao.UserDao;
import org.dao.impl.SignImpl;
import org.entity.User;
import org.service.LSEService;

public class SignServiceImpl implements LSEService {

	UserDao dao = new SignImpl();
	@Override
	public boolean find(User user) throws SQLException {return false;}

	@Override
	public void add(User user) throws SQLException {
		dao.addUser(user);
	}

	@Override
	public User get(User user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
