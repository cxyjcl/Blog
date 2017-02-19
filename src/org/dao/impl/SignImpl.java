package org.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.dao.UserDao;
import org.entity.User;
import org.util.TxQueryRunner;

public class SignImpl implements UserDao {

	public void addUser(User user) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "insert into userinfo(userName,password,email,userProperty) values(?,?,?,?)";
		String params[]={user.getUserName(),user.getPassword(),user.getEmail(),user.getUserProperty()};
		qr.update(sql, params);
	}
	@Override
	public void deleteUser(User user) throws SQLException {}

	@Override
	public void updateUser(User user) throws SQLException {}

	@Override
	public boolean findUser(User user) throws SQLException {return false;}

	@Override
	public User getUser(User user) throws SQLException {return null;}
	@Override
	public int getUserID(String str) throws SQLException {
		return 0;
	}

}
