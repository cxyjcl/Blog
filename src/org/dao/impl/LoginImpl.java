package org.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.dao.UserDao;
import org.entity.User;
import org.util.TxQueryRunner;

public class LoginImpl implements UserDao {

	public boolean findUser(User user) throws SQLException{
		QueryRunner qr = new TxQueryRunner();
		String sql = "select count(*) FROM userinfo where userName='"+user.getUserName()+"' and password='"+user.getPassword()+"'";
		if(qr.query(sql, new ScalarHandler<Long>())>0)
			return true;
		return false;
	}

	@Override
	public void addUser(User user) throws SQLException {}

	@Override
	public void deleteUser(User user) throws SQLException {}

	@Override
	public void updateUser(User user) throws SQLException {}

	@Override
	public User getUser(User user) throws SQLException {
		QueryRunner qr = new TxQueryRunner();
		String sql = "select userName,userProperty,touxiang from userinfo where userName='"+user.getUserName()+"'";
		return qr.query(sql,  new BeanHandler<User>(User.class));
	}

	@Override
	public int getUserID(String str) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
