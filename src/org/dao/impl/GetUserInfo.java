package org.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.dao.UserDao;
import org.entity.User;
import org.util.TxQueryRunner;

public class GetUserInfo implements UserDao {

	@Override
	public void addUser(User user) throws SQLException {}

	@Override
	public void deleteUser(User user) throws SQLException {}

	@Override
	public void updateUser(User user) throws SQLException {}

	@Override
	public boolean findUser(User user) throws SQLException {return false;}

	@Override
	public User getUser(User user) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "select userName userProperty touxiang FROM userinfo where userName='"+user.getUserName()+"'";
		return qr.query(sql,  new BeanHandler<User>(User.class));
	}

	public int getUserID(String str) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select ID FROM userinfo where userName='"+str+"'";
		return qr.query(sql,  new ScalarHandler<Integer>());
	}
}
